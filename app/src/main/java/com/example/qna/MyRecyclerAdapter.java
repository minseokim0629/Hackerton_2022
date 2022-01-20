package com.example.qna;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ArrayList<TrashList> TList;

    public MyRecyclerAdapter(ArrayList<TrashList> TList){
        this.TList = TList;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.trash.setText(TList.get(position).getTrash());
        holder.recycle.setText(TList.get(position).getRecycle());

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != TList ? TList.size() : 0);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView trash;
        TextView recycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.trash = (TextView) itemView.findViewById(R.id.trash);
            this.recycle = (TextView) itemView.findViewById(R.id.recycle);
        }

        void onBind(TrashList item){
            trash.setText(item.getTrash());
            recycle.setText(item.getRecycle());
        }
    }
}
