package io.andronicus.simplifiedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.List;

public class Adapter<T> extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private Context mContext;
    private int mLayoutResId;
    private List<T> mData;
    Adapter(Context context, int layoutResId, List<T> data){
     this.mContext = context;
     this.mLayoutResId = layoutResId;
     this.mData = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutResId,viewGroup,false);
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View view) {
            super(view);
        }

        private void bind(T item){

        }
    }
}
