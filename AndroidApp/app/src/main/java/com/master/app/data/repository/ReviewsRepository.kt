package com.master.app.data.repository

import com.master.app.data.model.Blog
import com.master.app.data.model.Review
import com.master.app.data.model.User

interface ReviewsRepository {
    suspend fun addReview(ratedUserId: Int, text: String, rating: Int): Resource<Review>
    suspend fun getReviewsByRatedUser(userId: Int): Resource<List<Review>>
    suspend fun getReviewsByCreatorUser(): Resource<List<Review>>
}