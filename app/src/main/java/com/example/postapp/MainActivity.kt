package com.example.postapp

import ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }

    fun fetchPosts(){
        val apiInterface = ApiClient.buildApiInterface(PostApiInterface::class.java)
        val request = apiInterface.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(p0: Call<List<Post>>, p1: Response<List<Post>>) {
               if(p1.isSuccessful){
                   val posts = p1.body()
                   Toast.makeText(baseContext, "Fetched ${posts!!.size} post", Toast.LENGTH_LONG).show()
               }
            }

            override fun onFailure(p0: Call<List<Post>>, p1: Throwable) {
                Toast.makeText(baseContext,p1.message.toString(), Toast.LENGTH_LONG).show()
            }

        })


    }
}