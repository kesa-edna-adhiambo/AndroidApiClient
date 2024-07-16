package com.example.postapp


import retrofit2.http.GET


interface PostApiInterface {
    @GET ("/posts")
    fun getPosts (): retrofit2.Call<List<Post>>

}