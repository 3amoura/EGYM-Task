package egym.omar.egymtask.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class TopStory(
    var title: String?,
    var abstract: String?,
    @SerializedName("byline") var byLine: String?,
    var multimedia: ArrayList<TopStoryMultimedia>?,
    var url: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(TopStoryMultimedia),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeString(byLine)
        parcel.writeTypedList(multimedia)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TopStory> {
        override fun createFromParcel(parcel: Parcel): TopStory {
            return TopStory(parcel)
        }

        override fun newArray(size: Int): Array<TopStory?> {
            return arrayOfNulls(size)
        }
    }

}