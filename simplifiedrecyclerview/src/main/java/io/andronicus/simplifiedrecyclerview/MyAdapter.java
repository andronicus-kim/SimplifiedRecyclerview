package io.andronicus.simplifiedrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class MyAdapter<T> extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private int mLayoutResId;
    private List<T> mData;
    private ViewHolderCallbacks<T> mHandler;
    private View mView;

    /*
    * MyAdapter constructor takes 3 arguments, the id of recycler view holder layout, list of data you
    * would like to display in your recyclerview and lastly ViewHolderCallbacks which is an interface
    * to handle binding data and click events
    * */
    public MyAdapter(int layoutResId, List<T> data, ViewHolderCallbacks<T> handler){
     this.mLayoutResId = layoutResId;
     this.mData = data;
     this.mHandler = handler;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutResId,parent,false);
        mView = view;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        /*
        * Pass the item at {position} to the calling activity/fragment
        * in order to bind data from this item to corresponding view holder child views
        * */
        mHandler.bindDataToViews(mData.get(position),mView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<T> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    /*
    * Get one item from the Adapter
    * */
    public T getItemAtPosition(int position){
        return this.mData.get(position);
    }

    public List<T> getAllItems(){
        return this.mData;
    }

    /*
    * Helper interface to handle binding data to views
    * as well click events from the view holder
    * */
    public interface ViewHolderCallbacks<T>{
        void onViewHolderClick(T item,int position);
        void onViewHolderLongClick(T item, int position);
        void bindDataToViews(T item,View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private ViewHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*
            * Pass the position and the item that was clicked
            * */
            int position = getAdapterPosition();
            mHandler.onViewHolderClick(mData.get(position),position);
        }

        @Override
        public boolean onLongClick(View v) {
            /*
             * Pass the position and the item that was long clicked
             * */
            int position = getAdapterPosition();
            mHandler.onViewHolderLongClick(mData.get(position), position);
            return true;
        }
    }
}
