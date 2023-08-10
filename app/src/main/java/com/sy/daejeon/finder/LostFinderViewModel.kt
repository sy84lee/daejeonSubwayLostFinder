package com.sy.daejeon.finder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sy.daejeon.finder.item.Item
import kotlinx.coroutines.flow.Flow

class LostFinderViewModel constructor (
    private val repository: LostFinderRepository
) : ViewModel() {

    private var queryString: String? = null
    var searchResult: Flow<PagingData<Item>>? = null

    fun searchRepository(queryString: String, sDate: String, eDate: String): Flow<PagingData<Item>> {
        val lastResult = searchResult
        //if (lastResult != null)
        //    return lastResult

        this.queryString = queryString
        val newResult = repository.getRepositorySearchItems(queryString, sDate, eDate)
            .cachedIn(viewModelScope)
        searchResult = newResult
        return newResult
    }
}