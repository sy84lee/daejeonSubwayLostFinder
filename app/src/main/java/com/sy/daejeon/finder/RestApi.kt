package com.sy.daejeon.finder

import com.sy.daejeon.finder.service.BASE_URL
import com.sy.daejeon.finder.service.LostFinderService
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit

class RestApi {
    private val lostFinderService: LostFinderService
    fun getService() : LostFinderService { return lostFinderService }
    init {
        val parser = TikXml.Builder().exceptionOnUnreadXml(false).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(TikXmlConverterFactory.create(parser))
            .build()
        lostFinderService = retrofit.create(LostFinderService::class.java)
    }

    companion object {
        val parser = TikXml.Builder().exceptionOnUnreadXml(false).build()
        fun loadService() : LostFinderService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(TikXmlConverterFactory.create(parser))
            .build()
            .create(LostFinderService::class.java)
    }
}