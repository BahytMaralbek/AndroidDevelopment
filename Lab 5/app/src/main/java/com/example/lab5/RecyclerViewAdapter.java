package com.example.lab5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    //    FragmentListener fragmentListener;
    Context context;
    ArrayList<Email> mailList = new ArrayList<Email>();
//    FragmentListener fragmentListener;

    public RecyclerViewAdapter(ArrayList<Email> mailList, Context context ){
        this.context = context;
        this.mailList = mailList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item , parent , false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder)holder;
        viewHolder.title.setText(mailList.get(position).getTitle());
        viewHolder.description.setText(mailList.get(position).getDescription());
        viewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        int position;
        LinearLayout linearLayout;
        TextView title;
        TextView description;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearlayout);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context , SecondActivity.class);
//                    intent.putExtra("mail" , mailList.get(position));
//                    fragmentListener.onClick()
//                    fragmentListener = (FragmentListener)SecondActivity.context;
//                    fragmentListener.onClick(mailList.get(position));
                    Email.selected = mailList.get(position);
                    SecondFragment.select();
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

//    public interface FragmentListener{
//        void onClick(Mail mail);
//    }
}
