package io.kodingworks.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.kodingworks.data.local.dao.CategoryDao
import io.kodingworks.data.local.model.CategoryModel

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */


// TODO : Add your database configurations here
@Database(entities = [CategoryModel::class], version = 1, exportSchema = false)
abstract class DatabaseFactory : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {
        private var INSTANCE: DatabaseFactory? = null
        private val lock = Any()
        private const val DB_NAME = "db_category"

        fun getDatabase(context: Context): DatabaseFactory {
            if (INSTANCE == null) {
                synchronized(lock) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseFactory::class.java,
                        DB_NAME
                    ).allowMainThreadQueries().build()
                }
                return INSTANCE as DatabaseFactory
            }
            return INSTANCE as DatabaseFactory
        }
    }
}