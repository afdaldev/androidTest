package io.kodingworks.data.local.model

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CategoryModel.TABLE_NAME)
data class CategoryModel(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("menu_order")
    val menuOrder: Int? = null
) {
    companion object {
        const val TABLE_NAME = "category"
        const val COLUMN_ID = BaseColumns._ID
    }
}