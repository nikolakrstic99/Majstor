package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.master.app.common.UserType
import com.master.app.data.model.Blog
import com.master.app.data.model.User

class BlogViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    val blog: Blog = Blog(1, "s", "s", "s", User(1, "s", "s", "s", "s", UserType.ADMIN, "s"), "s")
}