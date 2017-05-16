package com.example.brian.reflection;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Brian on 4/4/2017.
 */

//TODO: neds to extend RecyclerView.Adapter
public class RefletionListAdapter extends RecyclerView.Adapter<RefletionListAdapter.ReflectionViewHolder> {


    @Override
    public ReflectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ReflectionViewHolder holder, int position) {

    }
    
    @Override
    public int getItemCount() {
        return 0;
    }
    class ReflectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ReflectionViewHolder(View view){
            super(view);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
