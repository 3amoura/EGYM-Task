package egym.omar.egymtask.models

import com.google.gson.annotations.SerializedName

class TopStory constructor(var title: String,
                           @SerializedName("byline") var byLine: String,
                            var multimedia: TopStoryMultimedia) {

}