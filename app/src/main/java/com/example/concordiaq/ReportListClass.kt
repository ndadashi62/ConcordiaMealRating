package com.example.concordiaq

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class ReportListClass
    (
    var selectedItem: String,
    var rate: Float,
    var oneStar:String="Rating 1" ,
    var twoStar:String="Rating 2",
    var threeStar:String="Rating 3",
    var customerOrderReport:String="Customer Order:$selectedItem Rating:$rate"

)

    : Parcelable {
    override fun toString(): String {

        return "$customerOrderReport"
    }


}


