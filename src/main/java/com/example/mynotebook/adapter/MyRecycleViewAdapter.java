package com.example.mynotebook.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mynotebook.Note;
import com.example.mynotebook.NoteStorage;
import com.example.mynotebook.R;
import com.example.mynotebook.view.ViewHolder;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {


    private ViewHolder.NoteClickListener listener;
    private ArrayList<String> headline;


    public MyRecycleViewAdapter(ViewHolder.NoteClickListener listener){
        this.listener = listener;

    }

    public void setHeadlines(ArrayList<String> headlines) {
        this.headline = headlines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout we made
        LinearLayout ll = (LinearLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.customrow, parent, false);

        return new ViewHolder(ll, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    //elementer i listen
    public int getItemCount() {
        return NoteStorage.notes.size();
    }
}