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


public class MainActivity extends AppCompatActivity implements MyAdapter.ViewHolderCallbacks<String>{

    private MyAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * I have used a list of strings to simplify this
        * but your data should go here
        * */
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

        /*
        * Initialize your adapter and pass the required arguments
        * Make sure to implement MyAdapter.ViewHolderCallbacks<>
        * */
        mAdapter = new MyAdapter<>(R.layout.list_item,strings,this);
        recyclerView.setAdapter(mAdapter);


    }

    /*
    * Optionally you can turn your adapter to a field in
    * this case mAdapter and use it to get all or get one item
    * as illustrated below
    * */
    /*
    * Get all items from the Adapter
    * */
    private List<String> getAllItems(){
        return mAdapter.getAllItems();
    }

    /*
     * Get one item from the Adapter
     * */
    private String getOneItem(int position){
        return mAdapter.getItemAtPosition(position);
    }
    /*
    * Bind data to your views as you would normally do
    * in the view holder
    * */

    /*
     * Refresh or Update data
     * */
    private void setData(List<String> data){
        this.mAdapter.setData(data);
    }
    @Override
    public void bindDataToViews(String item, View view) {
        TextView textView = view.findViewById(R.id.tv_test);
        textView.setText(item);
    }

    /*
    * Handle click events from the view holder here
    * */
    @Override
    public void onViewHolderClick(String item,int position) {
        Toast.makeText(this, "Clicked at position" +  position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewHolderLongClick(String item, int position) {
        Toast.makeText(this, "Long clicked item at position: " + position , Toast.LENGTH_SHORT).show();
    }
}
