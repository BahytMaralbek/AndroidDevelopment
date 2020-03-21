package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity{

    FragmentManager fragmentManager;
    SecondFragment secondFragment;
    LogOutListener logOutListener;
    static Context context;
//    static SharedPreferences sharedPreferences;
//    SelectedElem selectedElem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
//        Email mail = getIntent().getParcelableExtra("mail");
        setContentView(R.layout.activity_second);
        fragmentManager = getSupportFragmentManager();
        secondFragment = new SecondFragment();
        fragmentManager.beginTransaction()
                .add(R.id.left_container , new MainFragment())
                .add(R.id.right_container , secondFragment).commit();
    }

    public void logOut(View v){
        Log.e("" , "Log out");
        logOutListener = (LogOutListener)MainActivity.context;
        logOutListener.out();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }



    public interface LogOutListener{
        void out();
    }
}
