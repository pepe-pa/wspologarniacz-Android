package pl.wspologarniacz.mobile.group.repository.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Group(var id: Long = 0,
                 var name: String) : Parcelable {
}