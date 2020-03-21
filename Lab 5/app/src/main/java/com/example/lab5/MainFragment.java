package com.example.lab5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    RecyclerView recyclerView;

    ArrayList<Email> mailList = new ArrayList<Email>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i=0; i<100 ; i++){
            int id = i;
            String title = "Title"+i;
            String description = "Description number: " + i;
            String Info = "info number: " + i;
            Email mail = new Email(i , title , description , Info);
            mailList.add(mail);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//      return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.main_fragment , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mailList , super.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(super.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        super.onViewCreated(view, savedInstanceState);
    }


}
