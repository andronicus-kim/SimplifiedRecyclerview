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
    private ViewHolderClicksHandler<T> mHandler;
    private View mView;

    public MyAdapter(int layoutResId, List<T> data, ViewHolderClicksHandler<T> handler){
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
        mHandler.bindDataToViews(mData.get(position),mView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface ViewHolderClicksHandler<T>{
        void onViewHolderClick(T item,int position);
        void bindDataToViews(T item,View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ViewHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mHandler.onViewHolderClick(mData.get(position),position);
        }
    }
}
