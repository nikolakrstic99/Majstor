package com.master.app.data.utils

import com.master.app.data.entity.BlogApiModel
import com.master.app.data.entity.ServiceApiModel
import com.master.app.data.entity.UserApiModel
import com.master.app.data.model.Blog
import com.master.app.data.model.Service
import com.master.app.data.model.User

fun fromUserApiToUser(userApiModel: UserApiModel): User =
    User(
        id = userApiModel.id,
        firstName = userApiModel.firstName,
        lastName = userApiModel.lastName,
        email = userApiModel.email,
        password = userApiModel.password,
        type = userApiModel.status,
        token = userApiModel.token
    )

fun fromBlogApiToBlog(blogApiModel: BlogApiModel): Blog =
    Blog(
        id = blogApiModel.id,
        title = blogApiModel.heading,
        description = blogApiModel.subHeading,
        text = blogApiModel.details,
        author = fromUserApiToUser(blogApiModel.user),
        createdAt = blogApiModel.createdAt
    )

fun fromServiceApiToService(serviceApiModel: ServiceApiModel): Service =
    Service(
        id = serviceApiModel.id,
        topLevelCategory = serviceApiModel.l1Category,
        category = serviceApiModel.l2Category,
        description = serviceApiModel.description,
        user = fromUserApiToUser(serviceApiModel.user)
    )
