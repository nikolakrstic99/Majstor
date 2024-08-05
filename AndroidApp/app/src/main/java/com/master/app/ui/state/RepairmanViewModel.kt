package com.master.app.ui.state

import androidx.lifecycle.ViewModel
import com.master.app.data.model.Blog
import com.master.app.data.model.BlogInfo
import com.master.app.data.model.Repairman

class RepairmanViewModel(val repairmanId: Int): ViewModel() {
    val repairman: Repairman = Repairman(
        1,
        "Milojko Pantic",
        8.3723725,
        "0621482242",
        listOf("Moler", "Parketar")
    )
}