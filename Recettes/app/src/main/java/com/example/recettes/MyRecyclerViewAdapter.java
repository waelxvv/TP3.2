package com.example.recettes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.UserAdapterVh> {

    private List<Recette> mData;
    private LayoutInflater mInflater;
    private Context context;
    private ItemClickListener mClickListener;
    private SelectedRecette selectedRecette;

    public MyRecyclerViewAdapter(List<Recette> mData, SelectedRecette selectedRecette) {
        this.mData = mData;
        this.selectedRecette = selectedRecette;
    }



    @Override
    public UserAdapterVh onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapterVh(LayoutInflater.from(context).inflate(R.layout.recyclerview_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVh holder, int position) {
        Recette recet = mData.get(position);
        String title = recet.getTitle();
        String desc = recet.getDesc();
        holder.titre.setText(title);
        holder.recette.setText(desc);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.recette);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Recette getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface SelectedRecette{
        void selectedRecette(Recette recette);

    }
    public class UserAdapterVh extends RecyclerView.ViewHolder{
        TextView titre;
        TextView recette;
        ImageView icon;
        public UserAdapterVh(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            recette = itemView.findViewById(R.id.recette);
            icon = itemView.findViewById(R.id.next);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedRecette.selectedRecette(mData.get(getAdapterPosition()));
                }
            });
        }
    }
}