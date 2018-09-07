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
    public MyAdapter(int layoutResId, List<T> data, ViewHolderClicksHandler<T> handler){
     this.mLayoutResId = layoutResId;
     this.mData = data;
     this.mHandler = handler;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutResId,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public interface ViewHolderClicksHandler<T>{
        void onViewHolderClick(T item);
        void bindDataToViews(T item,View view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View mView;
        public ViewHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);
            this.mView = view;
        }

        private void bind(T item){
            mHandler.bindDataToViews(item,mView);
        }

        @Override
        public void onClick(View view) {
            mHandler.onViewHolderClick(mData.get(getAdapterPosition()));
        }
    }
}
