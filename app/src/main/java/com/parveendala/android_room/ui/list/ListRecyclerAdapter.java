package com.parveendala.android_room.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parveendala.android_room.R;
import com.parveendala.android_room.models.Note;

import java.util.ArrayList;
import java.util.List;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.MainViewHolder> {

    private List<Note> list = new ArrayList();

    public void setList(List<Note> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public Note getItem(int poition){
        return list.get(poition);
    }

    public void removeNote(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void addNote(Note item, int position) {
        list.add(position, item);
        notifyItemInserted(position);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Note current = list.get(position);

        holder.tvTitle.setText(current.getTitle());
        holder.tvBody.setText(current.getBody());
        holder.tvTime.setText(current.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvBody, tvTime;
        public View viewForeground;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.title);
            tvBody = itemView.findViewById(R.id.body);
            tvTime = itemView.findViewById(R.id.time);

            viewForeground = itemView.findViewById(R.id.foreground_view);
        }
    }
}
