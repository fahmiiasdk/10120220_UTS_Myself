package com.example.a10120220_uts_myself;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecyclerViewFriend extends RecyclerView.Adapter<AdapterRecyclerViewFriend.ViewHolder> {
    //(2 juni 2023, 10120220, Fahmi Anwar Sidik, IF-06)
    private String[] SubjectValuesFriend;
    private int[] SubjectValuesImageFriend;
    private Context contextFriend;



    public AdapterRecyclerViewFriend(String[] subjectValuesFriend, int[] subjectValuesImageFriend, Context contextFriend) {
        SubjectValuesFriend = subjectValuesFriend;
        SubjectValuesImageFriend = subjectValuesImageFriend;
        this.contextFriend = contextFriend;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        ViewHolder(View v) {

            super(v);
            imageView = v.findViewById(R.id.imageItem);
            textView = v.findViewById(R.id.textItem);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(contextFriend).inflate(R.layout.list_friend_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValuesFriend[position]);
        holder.imageView.setImageResource(SubjectValuesImageFriend[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValuesFriend.length;
    }
}