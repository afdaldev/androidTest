package io.kodingworks.androidtest

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        categoryAdapter = CategoryAdapter {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete Category ${it.name}")
            builder.setMessage("Are you sure to delete category ${it.name} ?")
            builder.setPositiveButton("YES") { dialog, which ->
                categoryViewModel.deleteCategoryFromLocal(it.id)
                Toast.makeText(this, "Category ${it.name} has been deleted", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }
            builder.setNegativeButton("NO") { dialog, which ->
                dialog.cancel()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        categoryViewModel.getCategories(isConnect(this))
        categoryViewModel.categories.observe(this, Observer {
            it.data?.let { categoryList -> categoryAdapter.setCategoryList(categoryList) }
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