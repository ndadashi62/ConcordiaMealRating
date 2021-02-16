package com.example.concordiaq

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ReportListClass
    (
    var selectedItem: String,
    var rate: Float,
    var oneStar: String = "Customer Order:$selectedItem Rating:1",
    var twoStar: String = "Customer Order:$selectedItem Rating:2",
    var threeStar: String = "Customer Order:$selectedItem Rating:3",
    var customerOrderReport: String = "Customer Order:$selectedItem Rating:$rate"

)

    : Parcelable {
    override fun toString(): String {
        return "$customerOrderReport"
    }


}


