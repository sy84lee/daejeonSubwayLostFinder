import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sy.daejeon.finder.OnItemClick
import com.sy.daejeon.finder.R
import com.sy.daejeon.finder.databinding.ItemRecycler2Binding
import com.sy.daejeon.finder.item.Item

class LostFinderAdapter(listener : OnItemClick) : PagingDataAdapter<Item, LostFinderAdapter.Holder>(
    IMAGE_DIFF
) {
    var mCallback:OnItemClick = listener

    class Holder(val binding: ItemRecycler2Binding, val callback: OnItemClick): RecyclerView.ViewHolder(binding.root) {
        lateinit var currentItem: Item
        //클릭처리는 init에서만 한다
        init {
            binding.root.setOnClickListener {
                val title = binding.textTitle.text
                callback.onClick(currentItem)
            }
        }

        // 3. 받은 데이터를 화면에 출력
        fun setItem(item: Item) {
            currentItem = item
            with(binding) {
                textTitle.text = item.name
                textDate.text = item.pickupdate
//                if (item.lostimage.endsWith("img02_no_img.gif")) {
//                    Glide.with(root).load(R.drawable.phone).into(imageViewPhone)
//                }
//                else {
//                    Glide.with(root).load(item.lostimage).into(imageViewPhone)
//                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecycler2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, mCallback)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //1. 사용할 데이터를 꺼내고
        //val item = listData.get(position)
        //2.  홀더에 데이터를 전달
        getItem(position)?.let { holder.setItem(it) }

    }

    companion object {
        private val IMAGE_DIFF = object: DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem
        }
    }
}