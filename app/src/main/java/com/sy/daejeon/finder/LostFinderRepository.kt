package com.sy.daejeon.finder

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.filter
import com.sy.daejeon.finder.item.Item
import com.sy.daejeon.finder.pagingsource.LostFinderPagingSource
import com.sy.daejeon.finder.service.LostFinderService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LostFinderRepository (
    private val service: LostFinderService
) {
   fun getRepositorySearchItems(query: String, sDate: String, eDate: String): Flow<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = 15,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LostFinderPagingSource(service, query, sDate, eDate) }
        ).flow
            .map {pagingData ->
                pagingData.filter {
                    it.name?.contains(query) == true || it.pickupdate?.contains(query) == true ||
                            it.pickupplace?.contains(query) == true
                }
            }
    }
}