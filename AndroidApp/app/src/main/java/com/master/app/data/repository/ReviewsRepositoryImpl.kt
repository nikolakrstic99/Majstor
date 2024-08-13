package com.master.app.data.repository

import com.master.app.data.entity.AddReviewRequest
import com.master.app.data.model.Review
import com.master.app.data.source.ApiService
import com.master.app.data.utils.fromReviewApiToReview
import javax.inject.Inject

class ReviewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ReviewsRepository {

    override suspend fun addReview(ratedUserId: Int, text: String, rating: Int): Resource<Review> {
        try {
            val response = apiService.addReview(AddReviewRequest(ratedUserId, text, rating))
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(fromReviewApiToReview(response.body()!!))
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getReviewsByRatedUser(userId: Int): Resource<List<Review>> {
        try {
            val response = apiService.getReviewsByRatedUser(userId)
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map {
                fromReviewApiToReview(it)
            })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

    override suspend fun getReviewsByCreatorUser(): Resource<List<Review>> {
        try {
            val response = apiService.getReviewsByCreatorUser()
            if (!response.isSuccessful) {
                return Resource.Error("Error: ${response.code()} - ${response.errorBody()?.string()}")
            }
            return Resource.Success(response.body()!!.map {
                fromReviewApiToReview(it)
            })
        }
        catch (e: Exception) {
            return Resource.Error(e.toString())
        }
    }

}