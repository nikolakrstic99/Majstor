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
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiService: ApiService {
    // localhost (127.0.0.1) refers to the device or emulator itself
    // 10.0.2.2 is a special alias to your host loopback interface
    private val BASE_URL = "http://10.0.2.2:8080/api/v1/"

    private val api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient())
            .build()
            .create(ApiService::class.java)
    }

    /**
     * Initialize OkhttpClient with interceptor
     */
    private fun okhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }

    override suspend fun login(request: LoginRequest): Response<UserApiModel> {
        return api.login(request)
    }

    override suspend fun register(request: RegisterRequest): Response<UserApiModel> {
        return api.register(request)
    }

    override suspend fun createBlog(request: CreateBlogRequest): Response<BlogApiModel> {
        return api.createBlog(request)
    }

    override suspend fun getLoggedUser(): Response<UserApiModel> {
        return api.getLoggedUser()
    }

    override suspend fun getAllBlogs(): Response<List<BlogApiModel>> {
        return api.getAllBlogs()
    }

    override suspend fun getTopLevelCategories(): Response<List<String>> {
        return api.getTopLevelCategories()
    }

    override suspend fun getCategories(l1Category: String): Response<List<String>> {
        return api.getCategories(l1Category)
    }

    override suspend fun addService(request: AddServiceRequest): Response<ServiceApiModel> {
        return api.addService(request)
    }

    override suspend fun getUsersProvidingL1Category(l1Category: String): Response<List<ServiceApiModel>> {
        return api.getUsersProvidingL1Category(l1Category)
    }

    override suspend fun getUsersProvidingL2Category(l2Category: String): Response<List<ServiceApiModel>> {
        return api.getUsersProvidingL2Category(l2Category)
    }

    override suspend fun getUser(id: Int): Response<UserApiModel> {
        return api.getUser(id)
    }

    override suspend fun addReview(request: AddReviewRequest): Response<ReviewApiModel> {
        return api.addReview(request)
    }

    override suspend fun getReviewsByRatedUser(userId: Int): Response<List<ReviewApiModel>> {
        return api.getReviewsByRatedUser(userId)
    }

    override suspend fun getReviewsByCreatorUser(): Response<List<ReviewApiModel>> {
        return api.getReviewsByCreatorUser()
    }

    override suspend fun getServicesProvidedByUser(userId: Int): Response<List<ServiceApiModel>> {
        return api.getServicesProvidedByUser(userId)
    }

    override suspend fun getServiceImages(id: Int): Response<List<ImageApiModel>> {
        return api.getServiceImages(id)
    }

    override suspend fun getBlogImages(id: Int): Response<List<ImageApiModel>> {
        return api.getBlogImages(id)
    }

    override suspend fun deleteBlog(id: Int): Response<Unit> {
        return api.deleteBlog(id)
    }

    override suspend fun deleteService(id: Int): Response<Unit> {
        return api.deleteService(id)
    }
}