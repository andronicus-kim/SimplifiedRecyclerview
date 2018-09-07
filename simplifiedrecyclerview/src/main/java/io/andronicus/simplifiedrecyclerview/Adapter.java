package io.andronicus.simplifiedrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class Adapter<T> extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private int mLayoutResId;
    private List<T> mData;
    private ViewHolderClicksHandler<T> mHandler;
    public Adapter(int layoutResId, List<T> data,ViewHolderClicksHandler<T> handler){
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
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);
        }

        private void bind(T item){

        }

        @Override
        public void onClick(View view) {
            mHandler.onViewHolderClick(mData.get(getAdapterPosition()));
        }
    }
}
