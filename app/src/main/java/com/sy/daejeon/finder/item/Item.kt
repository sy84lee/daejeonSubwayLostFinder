package com.sy.daejeon.finder.item

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import java.io.Serializable

@Xml(name = "response")
data class ImageItem(
    @Element(name = "body")
    val body: Body,
    @Element(name="header")
    val header: Header
)

@Xml(name="header")
data class Header(
    @PropertyElement(name="resultCode")
    val resultCode: Int,
    @PropertyElement(name="resultMsg")
    val resultMsg: String
)

@Xml(name = "body")
data class Body(
    @Element(name="items")
    val items: Items
)

@Xml(name= "items")
data class Items(
    @Element(name="item")
    val item: List<Item>
)

@Xml(name= "item")
data class Item(
    @PropertyElement(name = "comments")
    var comments: String? = "none",
    @PropertyElement(name = "keepingplace")
    var keepingplace: String? = "none",
    @PropertyElement(name="lostimage")
    var lostimage: String = "none",
    @PropertyElement(name="name")
    var name: String? = "none",
    @PropertyElement(name="pickupdate")
    var pickupdate: String? = "none",
    @PropertyElement(name="pickupplace")
    var pickupplace: String? = "none",
    @PropertyElement(name="registerdate")
    var registerdate: String? = "none",
    @PropertyElement(name="status")
    var status: String? = "none",
)
