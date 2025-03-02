package com.partitionsoft.beintouch.domain.repository

import androidx.paging.PagingData
import com.partitionsoft.beintouch.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

}