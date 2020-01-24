package io.kodingworks.androidtest

import android.app.Service
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import io.kodingworks.androidtest.viewmodels.CategoryViewModel
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
        categoryViewModel.getCategories(isConnect(this))
        categoryViewModel.categories.observe(this, Observer {
            it.data?.let { it1 -> categoryAdapter.setCategoryList(it1) }
        })
        rvCategories.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 5)
            adapter = categoryAdapter
        }
    }

    private fun isConnect(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected
        }
    }
}