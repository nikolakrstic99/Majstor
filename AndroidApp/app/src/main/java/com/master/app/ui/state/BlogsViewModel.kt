package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import com.master.app.data.model.BlogInfo

class BlogsViewModel: ViewModel() {
    val blogs: List<BlogInfo> = listOf(
        BlogInfo(
            1,
            "A Breakdown of the Full English Breakfast",
            "Welcome to Weekend Brunch! Skip the lines and make brunch at home. The coffee’s truly bottomless and the best part is PJs all the way! This week: a guide to the gloriousness that is known as A Full English Breakfast.",
            "picture",
            "01.04.2024",
            "Andrej Jokic"
        ),
        BlogInfo(
            2,
            "Tiktok Baked Feta Pasta",
            "This tiktok pasta has it all, big bold flavors, creamy comfort, and carbs!",
            "picture",
            "05.10.2024",
            "Nikola Krstic"
        ),
        BlogInfo(
            3,
            "Mixed Fish Sauce Recipe",
            "Everything you ever wanted to know about fish sauce, plus my secret recipe for the best fish sauce you’ve ever had.",
            "picture",
            "12.11.2024",
            "Sara Kolarevic"
        )
    )
}