package com.piyushnanwani.newsapp

// MainActivity.kt
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        fetchNews()
    }

    private fun fetchNews() {
        val apiKey = "4543ae0b946d47b7a8530d2c5a756ecc"
        val call = RetrofitInstance.api.getNews(
            query = "tesla",
            fromDate = "2024-10-13",
            sortBy = "publishedAt",
            apiKey = apiKey
        )

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val articles = response.body()!!.articles

                    // Map API response to News data class
                    val newsList = articles.map { article ->
                        News(
                            title = article.title,
                            category = article.source.name,
                            description = article.description ?: "No description available",
                            imageUrl = article.urlToImage ?: "https://via.placeholder.com/150"
                        )
                    }

                    // Set up adapter with the fetched data
                    adapter = NewsAdapter(newsList)
                    recyclerView.adapter = adapter
                } else {
                    Log.e("MainActivity", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }

}
