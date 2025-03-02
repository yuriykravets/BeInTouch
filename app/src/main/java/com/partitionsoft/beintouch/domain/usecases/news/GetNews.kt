package com.partitionsoft.beintouch.domain.usecases.news

import androidx.paging.PagingData
import com.partitionsoft.beintouch.domain.model.Article
import com.partitionsoft.beintouch.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }

}