package com.example.lab5;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondFragment extends Fragment  {

    static TextView title , description , detailedInfo;
    static Email mail;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        detailedInfo = (TextView) view.findViewById(R.id.info);
    }

    public  static void select() {
//        Email mail = super.getActivity().getIntent().getParcelableExtra("mail");
        Email mail = Email.selected;
        title.setText(mail.getTitle() + " (id:"+mail.getId() + ")");
        description.setText(mail.getDescription());
        detailedInfo.setText(mail.getInfo());
    }

}
