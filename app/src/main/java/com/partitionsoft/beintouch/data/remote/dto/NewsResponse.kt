package com.partitionsoft.beintouch.data.remote.dto

import com.partitionsoft.beintouch.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)