package com.sy.daejeon.finder.service

import com.sy.daejeon.finder.item.ImageItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL = "http://www.djtc.kr/OpenAPI/service/LostSVC/"

interface LostFinderService {
    @Headers(
        "Content-Type:application/xml;charset=UTF-8"
    )
    @GET("getLostList?ServiceKey=DPo7pwuVB26NZUErOX%2BUltyyqxjRt%2FX%2Bj0mIof3ZS7UVy54bPj0mlyodQ9mgYzohKbPsh6QsH6PcIec1lUMUlA%3D%3D")
    suspend fun getLostList(
        @Query("sDate") sDate: String? = null,
        @Query("eDate") eDate: String? = null): ImageItem
}