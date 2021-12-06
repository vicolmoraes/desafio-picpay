package com.picpay.desafio.android.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: UsersViewModel by viewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initObserver()
        viewModel.getUsers()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = View.VISIBLE
    }

    private fun initObserver() {
        viewModel.actionState.observe(this, Observer {
            when (it) {
                is UsersViewModel.ResponseState.getUsersSucess -> {
                    progressBar.visibility = View.GONE
                    recyclerView.adapter = UserListAdapter(it.response)
                }
                is UsersViewModel.ResponseState.getUsersError -> {
                    val message = getString(R.string.error)

                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE

                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}
