package io.kodingworks.androidtest

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import io.kodingworks.androidtest.viewmodels.CategoryViewModel
import io.kodingworks.data.datasource.CategoryLocalDataSource
import io.kodingworks.domain.models.Category
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModel()
    private lateinit var categoryAdapter: CategoryAdapter

    /*
    * TODO : Use categoryViewModel for observe and display categories to recyclerView here.
    *  See {@drawable/categories.png) for categories layout
    *  categories data source depends of user connection, so you should have feature to check user's connection.
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        categoryAdapter = CategoryAdapter()
        categoryViewModel.getCategories(true)
        categoryViewModel.categories.observe(this, Observer {
            it.data?.let { it1 -> categoryAdapter.setCategoryList(it1) }
        })
        rvCategories.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 5)
            adapter = categoryAdapter
        }
    }
}
