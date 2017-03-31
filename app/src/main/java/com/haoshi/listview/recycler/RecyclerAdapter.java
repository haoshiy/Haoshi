package com.haoshi.listview.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haoshi.R;

import java.util.List;

/**
 * @author HaoShi
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {

    private List<String> texts;
    private List<Integer> images;
    private OnRecyclerItemClickListener onItemClick;

    public RecyclerAdapter(List<String> texts, List<Integer> images, OnRecyclerItemClickListener onItemClick) {
        this.texts = texts;
        this.images = images;
        this.onItemClick = onItemClick;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.textView.setText(texts.get(position));
        holder.imageView.setImageResource(images.get(position));
        holder.imageView.setOnClickListener(v -> onItemClick.onItemClick(holder.getLayoutPosition()));
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(int position);
    }

    public static class VH extends RecyclerView.ViewHolder {

        public ImageView imageView = null;
        public TextView textView = null;

        public VH(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}