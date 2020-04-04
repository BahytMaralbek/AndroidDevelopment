package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AppDatabase database;
    DAO DAO;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = MyApp.getInstance().getDatabase();
        DAO = AppDatabase.taskDAO();

        initRecyclerView();

        Button button = findViewById(R.id.save_button);
        Button buttonDeleteAll = findViewById(R.id.deleteAll);
        final EditText newstatus = findViewById(R.id.newstatus);
        final EditText newcategory = findViewById(R.id.newcategory);
        final EditText newduration = findViewById(R.id.newduration);
        final EditText newtitle = findViewById(R.id.newtitle);
        final EditText newdescription = findViewById(R.id.newdescription);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task task = new Task();
                task.description = newdescription.getText().toString();
                task.category = newcategory.getText().toString();
                task.duration = newduration.getText().toString();
                task.status = newstatus.getText().toString();
                task.title = newtitle.getText().toString();
                DAO.insert(task);

                newtitle.setText("");
                newdescription.setText("");
                newstatus.setText("");
                newcategory.setText("");
                newduration.setText("");

                database = MyApp.getInstance().getDatabase();
                DAO = AppDatabase.taskDAO();

                initRecyclerView();
            }
        });

        buttonDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO.deleteAll();
                database = MyApp.getInstance().getDatabase();
                DAO = AppDatabase.taskDAO();

                initRecyclerView();
            }
        });
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        TaskAdapter adapter = new TaskAdapter(this, new ArrayList<Task>(MyApp.getInstance().getDatabase().taskDAO().getAll()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
