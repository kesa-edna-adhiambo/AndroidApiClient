package com.example.postapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiInterface {
    @GET ("/posts")
    fun fetchPosts (): Call<List<Post>>

//    @GET ("/posts")
//    fun fetchPostsById (@Path("postId") postId: Int): Call<Post>
//    fun fetchPostsById(@Path("postId") postId: Int): Call<Post>
@GET("/posts/{postId}")
fun fetchPostsById(@Path("postId") postId: Int): Call<Post>

//    @GET ("api/comments/{postId}")
//    fun fetchCommentsByPostId(@Path("postId") postId: Int): Call<List<Comments>>
@GET("/posts/{postId}/comments")
fun fetchCommentsByPostId(@Path("postId") postId: Int): Call<List<Comments>>

}