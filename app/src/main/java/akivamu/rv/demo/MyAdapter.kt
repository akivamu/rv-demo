package akivamu.rv.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(private val drawableResIds: List<Int>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(rootView as ImageView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // #1: lagging
//        holder.imageView.setImageResource(drawableResIds[position])

        // #2: lagging
//        holder.imageView.setImageDrawable(
//            ContextCompat.getDrawable(holder.imageView.context, dataSet[position])
//        )

        // #3: lagging
//        holder.imageView.setImageBitmap(
//            BitmapFactory.decodeResource(holder.imageView.context.resources, dataSet[position])
//        )

        // #4: smooth
        Glide.with(holder.imageView.context)
            .load(drawableResIds[position])
            .into(holder.imageView);
    }

    override fun getItemCount() = drawableResIds.size
}

