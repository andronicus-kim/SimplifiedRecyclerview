package io.andronicus.simplifiedrecyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.andronicus.simplifiedrecyclerview.MyAdapter;

public class MainActivity extends AppCompatActivity implements MyAdapter.ViewHolderClicksHandler<String>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter<>(R.layout.list_item,strings,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void bindDataToViews(String item, View view) {
        TextView textView = view.findViewById(R.id.tv_test);
        textView.setText(item);
    }

    @Override
    public void onViewHolderClick(String item,int position) {
        Toast.makeText(this, "Clicked at position" +  position, Toast.LENGTH_SHORT).show();
    }
}
