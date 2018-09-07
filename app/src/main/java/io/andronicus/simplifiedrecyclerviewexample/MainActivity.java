package io.andronicus.simplifiedrecyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        new MyAdapter<>(2,strings,this);

    }

    @Override
    public void bindDataToViews(String item, View view) {
        TextView textView = view.findViewById(R.id.tv_test);
        textView.setText(item);
    }

    @Override
    public void onViewHolderClick(String item) {
    }
}
