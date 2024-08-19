package com.master.app.data.source

import com.master.app.data.entity.AddReviewRequest
import com.master.app.data.entity.AddServiceRequest
import com.master.app.data.entity.BlogApiModel
import com.master.app.data.entity.CreateBlogRequest
import com.master.app.data.entity.LoginRequest
import com.master.app.data.entity.RegisterRequest
import com.master.app.data.entity.ReviewApiModel
import com.master.app.data.entity.ServiceApiModel
import com.master.app.data.entity.ImageApiModel
import com.master.app.data.entity.UserApiModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<UserApiModel>

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<UserApiModel>

    @POST("blog")
    suspend fun createBlog(@Body request: CreateBlogRequest): Response<BlogApiModel>

    @GET("user")
    suspend fun getLoggedUser(): Response<UserApiModel>

    @GET("blog")
    suspend fun getAllBlogs(): Response<List<BlogApiModel>>

    @GET("service/l1Categories")
    suspend fun getTopLevelCategories(): Response<List<String>>

    @GET("service/l2Categories/{l1Category}")
    suspend fun getCategories(@Path("l1Category") l1Category: String): Response<List<String>>

    @POST("service")
    suspend fun addService(@Body request: AddServiceRequest): Response<ServiceApiModel>

    @GET("service/usersProvidingL1Category/{l1Category}")
    suspend fun getUsersProvidingL1Category(@Path("l1Category") l1Category: String): Response<List<ServiceApiModel>>

    @GET("service/usersProvidingL2Category/{l2Category}")
    suspend fun getUsersProvidingL2Category(@Path("l2Category") l2Category: String): Response<List<ServiceApiModel>>

    @GET("user/{id}")
    suspend fun getUser(@Path("id") id: Int): Response<UserApiModel>

    @POST("review")
    suspend fun addReview(@Body request: AddReviewRequest): Response<ReviewApiModel>

    @GET("review/ratedUser/{userId}")
    suspend fun getReviewsByRatedUser(@Path("userId") userId: Int): Response<List<ReviewApiModel>>

    @GET("review/creatorUser")
    suspend fun getReviewsByCreatorUser(): Response<List<ReviewApiModel>>

    @GET("service/user/{userId}")
    suspend fun getServicesProvidedByUser(@Path("userId") userId: Int): Response<List<ServiceApiModel>>

    @GET("service/images/{id}")
    suspend fun getServiceImages(@Path("id") id: Int): Response<List<ImageApiModel>>

    @GET("blog/images/{id}")
    suspend fun getBlogImages(@Path("id") id: Int): Response<List<ImageApiModel>>

    @DELETE("blog/{id}")
    suspend fun deleteBlog(@Path("id") id: Int): Response<Unit>

    @DELETE("service/{id}")
    suspend fun deleteService(@Path("id") id: Int): Response<Unit>
}