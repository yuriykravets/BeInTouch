package com.partitionsoft.beintouch.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.partitionsoft.beintouch.data.remote.NewsApi
import com.partitionsoft.beintouch.data.remote.NewsPagingSource
import com.partitionsoft.beintouch.domain.model.Article
import com.partitionsoft.beintouch.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { NewsPagingSource(newsApi, sources.joinToString(",")) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }
}