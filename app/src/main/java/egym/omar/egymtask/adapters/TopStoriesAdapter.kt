package egym.omar.egymtask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import egym.omar.egymtask.R
import egym.omar.egymtask.data.models.TopStory

class TopStoriesAdapter(
    private val topStories: List<TopStory>,
    private val navigate: (TopStory) -> Unit
) : Adapter<TopStoriesAdapter.TopStoryViewHolder>() {

    inner class TopStoryViewHolder(itemView: View) : ViewHolder(itemView) {
        var storyImageView: ImageView = itemView.findViewById(R.id.story_image_view)
        var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        var authorTextView: TextView = itemView.findViewById(R.id.author_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoryViewHolder {
        return TopStoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_story_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopStoryViewHolder, position: Int) {
        val topStory = topStories[position]
        holder.titleTextView.text = topStory.title
        holder.authorTextView.text = topStory.byLine
        topStory.multimedia?.let {
            if (it.isNotEmpty()) {
                Glide.with(holder.storyImageView.context).load(it[0].url)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(holder.storyImageView)
            }
        }

        holder.itemView.setOnClickListener {
            topStory.let {
                navigate.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return topStories.size
    }
}