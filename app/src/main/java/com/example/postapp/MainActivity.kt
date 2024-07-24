package com.example.postapp

import ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView: RecyclerView
    lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initialize the binding
        setContentView(binding.root)
        fetchPosts()
        recyclerView = binding.rvApi
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun fetchPosts() {
        val apiInterface = ApiClient.buildApiInterface(PostApiInterface::class.java)
        val request = apiInterface.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    posts?.let {
                        postAdapter = PostAdapter(it)
                        recyclerView.adapter = postAdapter
                    }
                    Toast.makeText(baseContext, "Fetched ${posts!!.size} posts", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}