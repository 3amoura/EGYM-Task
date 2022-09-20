package egym.omar.egymtask.data.models

import android.os.Parcel
import android.os.Parcelable

class TopStoryMultimedia(var url: String?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TopStoryMultimedia> {
        override fun createFromParcel(parcel: Parcel): TopStoryMultimedia {
            return TopStoryMultimedia(parcel)
        }

        override fun newArray(size: Int): Array<TopStoryMultimedia?> {
            return arrayOfNulls(size)
        }
    }
}