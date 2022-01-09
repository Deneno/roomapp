package ya.deneno.roomapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ya.deneno.roomapp.R
import ya.deneno.roomapp.databinding.ItemLayoutBinding
import ya.deneno.roomapp.model.NoteModel
import ya.deneno.roomapp.screens.start.StartFragment

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var noteList: List<NoteModel> = emptyList()

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemLayoutBinding.bind(view)

        fun bind(note: NoteModel) {
            binding.apply {
                itemTitle.text = note.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
       return noteList.size
    }

    fun setList(list: List<NoteModel>) {
        noteList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(noteList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}