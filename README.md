# News App 📰

A simple Android News app built with Kotlin that fetches news articles from the NewsAPI and displays them using a `RecyclerView`.

## Features

- Fetches latest news articles about Tesla from [NewsAPI](https://newsapi.org/).
- Displays article title, source, description, and image.
- Uses Retrofit for API requests and Glide for image loading.

## Screenshots

![App Screenshot](https://github.com/user-attachments/assets/fc428b5b-ddfa-401c-8df8-0cb696e6e341)

## API Reference

This app uses the `everything` endpoint of NewsAPI:

- Endpoint: `https://newsapi.org/v2/everything`
- Query Parameters:
  - `q`: Search query (e.g., `tesla`)
  - `from`: Start date for articles (e.g., `2024-10-13`)
  - `sortBy`: Sort articles by (`publishedAt`)
  - `apiKey`: Your NewsAPI key

## Installation

1. Clone the repo:
   ```bash
   git clone https://github.com/yourusername/NewsApp.git

