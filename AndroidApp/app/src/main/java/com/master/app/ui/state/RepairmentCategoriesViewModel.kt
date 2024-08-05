package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import com.master.app.data.model.RepairmentCategory

class RepairmentCategoriesViewModel: ViewModel()  {
    val repairmentCategories: List<RepairmentCategory> = listOf(
        RepairmentCategory(
            1,
            "Gradjevinski radovi",
            495,
            "picture"
        ),
        RepairmentCategory(
            2,
            "Elektronika",
            25,
            "picture"
        ),
        RepairmentCategory(
            3,
            "Odrzavanje",
            105,
            "picture"
        ),
        RepairmentCategory(
            4,
            "Cevne instalacije",
            8,
            "picture"
        ),
        RepairmentCategory(
            5,
            "Nekategorizovano",
            2,
            "picture"
        )
    )
}