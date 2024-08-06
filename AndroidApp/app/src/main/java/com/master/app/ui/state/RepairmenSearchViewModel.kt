package com.master.app.ui.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.master.app.data.model.Repairman
import com.master.app.data.model.RepairmentCategory

class RepairmenSearchViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    val topLevelCategoryId: Int? = savedStateHandle.get<Int>("categoryId")

    val topLevelCategory: RepairmentCategory = RepairmentCategory(
        1,
        "Gradjevinski radovi",
        136,
        "pictureURL"
    )

    val repairmen: List<Repairman> = listOf(
        Repairman(
            1,
            "Milojko Pantic",
            8.3723725,
            "0621482242",
            listOf("Moler", "Parketar")
        ),
        Repairman(
            2,
            "Petar Vojinovic",
            7.2,
            "0621482242",
            listOf("Parketar")
        ),
        Repairman(
            3,
            "David Zlatkovic",
            10.0,
            "0621482242",
            listOf("Moler")
        ),
        Repairman(
            1,
            "Milojko Pantic",
            8.3723725,
            "0621482242",
            listOf("Moler", "Parketar")
        ),
        Repairman(
            2,
            "Petar Vojinovic",
            7.2,
            "0621482242",
            listOf("Parketar")
        ),
        Repairman(
            3,
            "David Zlatkovic",
            10.0,
            "0621482242",
            listOf("Moler")
        ),
        Repairman(
            1,
            "Milojko Pantic",
            8.3723725,
            "0621482242",
            listOf("Moler", "Parketar")
        ),
        Repairman(
            2,
            "Petar Vojinovic",
            7.2,
            "0621482242",
            listOf("Parketar")
        ),
        Repairman(
            3,
            "David Zlatkovic",
            10.0,
            "0621482242",
            listOf("Moler")
        ),
        Repairman(
            1,
            "Milojko Pantic",
            8.3723725,
            "0621482242",
            listOf("Moler", "Parketar")
        ),
        Repairman(
            2,
            "Petar Vojinovic",
            7.2,
            "0621482242",
            listOf("Parketar")
        ),
        Repairman(
            3,
            "David Zlatkovic",
            10.0,
            "0621482242",
            listOf("Moler")
        )
    )

    val categories: List<RepairmentCategory> = listOf(
        RepairmentCategory(
            1,
            "Keramicar",
            136,
            "pictureURL"
        ),
        RepairmentCategory(
            2,
            "Moler",
            26,
            "pictureURL"
        ),
        RepairmentCategory(
            3,
            "Parketar",
            8,
            "pictureURL"
        ),
        RepairmentCategory(
            1,
            "Keramicar",
            136,
            "pictureURL"
        ),
        RepairmentCategory(
            2,
            "Moler",
            26,
            "pictureURL"
        ),
        RepairmentCategory(
            3,
            "Parketar",
            8,
            "pictureURL"
        )
    )
}