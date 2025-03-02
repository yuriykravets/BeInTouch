package com.partitionsoft.beintouch.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.partitionsoft.beintouch.domain.model.Article

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(page, sources)
            totalNewsCount += newsResponse.articles.size

            val articles = newsResponse.articles.distinctBy { it.title } // Remove duplicates
            LoadResult.Page(
                data = articles,
                prevKey = null,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1
            )
        } catch (e: Exception) {
            Log.e("NewsPagingSource", "Error loading news", e)
            LoadResult.Error(e)
        }
    }


}