package io.kodingworks.data.remote.model
import com.google.gson.annotations.SerializedName


/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

data class CategoriesResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("display")
    val display: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("_links")
    val links: Links? = null,
    @SerializedName("menu_order")
    val menuOrder: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("parent")
    val parent: Int? = null,
    @SerializedName("slug")
    val slug: String? = null
)

data class Image(
    @SerializedName("alt")
    val alt: String? = null,
    @SerializedName("date_created")
    val dateCreated: String? = null,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String? = null,
    @SerializedName("date_modified")
    val dateModified: String? = null,
    @SerializedName("date_modified_gmt")
    val dateModifiedGmt: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("src")
    val src: String? = null
)

data class Links(
    @SerializedName("collection")
    val collection: List<Collection?>? = null,
    @SerializedName("self")
    val self: List<Self?>? = null
)

data class Collection(
    @SerializedName("href")
    val href: String? = null
)

data class Self(
    @SerializedName("href")
    val href: String? = null
)