package com.dimas.githubuserapp3.networking

import com.dimas.githubuserapp3.BuildConfig
import com.dimas.githubuserapp3.datasource.SearchResponse
import com.dimas.githubuserapp3.datasource.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: token $API_TOKEN", "UserResponse-Agent: request")

    @GET("users")
    suspend fun getUserListAsync(): ArrayList<UserResponse>

    @GET("users/{username}")
    suspend fun getDetailUserAsync(@Path("username") username: String): UserResponse

    @GET("search/users")
    fun getUserBySearch(@Query("q") username: String): Call<SearchResponse>

    @GET("users/{username}/followers")
    suspend fun getFollowersList(@Path("username") username: String): ArrayList<UserResponse>

    @GET("users/{username}/following")
    suspend fun getFollowingList(@Path("username") username: String): ArrayList<UserResponse>


    companion object {
        private const val API_TOKEN = BuildConfig.API_TOKEN
    }
}
