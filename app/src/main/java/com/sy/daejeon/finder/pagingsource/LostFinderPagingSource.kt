package com.sy.daejeon.finder.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sy.daejeon.finder.item.Item
import com.sy.daejeon.finder.service.LostFinderService

class LostFinderPagingSource(
    private val backend: LostFinderService,
    val query: String,
    val sDate: String,
    val eDate: String
) : PagingSource<Int, Item>() {

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(0)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(0)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val nextPageNumber = params.key ?: 1
            //Log.i("TEST","[nextPageNumber ] " + nextPageNumber)
            val response = backend.getLostList(sDate, eDate)

            //val items : ArrayList<Item> = ArrayList()
            //for (i:Item in response.body.items.item) {
            //    val result : Boolean
            //    if (i.fdSbjt?.contains(query) == true) {
            //        items.add(i)
            //    }
           // }

            return LoadResult.Page(
                data = response.body.items.item,
                //data = items,
                prevKey = if (nextPageNumber == 0 || nextPageNumber == 1) null else nextPageNumber - 1,
                //nextKey = if (nextPageNumber == 0) 1 else nextPageNumber + 1
                //prevKey = 0,
                        nextKey = null
            )
        }
        catch (e: Exception) {
            Log.i("TEST","[Exception] : " + e.printStackTrace())
            return LoadResult.Error(e)
        }
    }
}