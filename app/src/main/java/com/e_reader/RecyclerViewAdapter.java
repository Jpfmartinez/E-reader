package com.e_reader;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    @NonNull
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String>mNmaes=new ArrayList<>();
    private ArrayList<String>mImagesUrls =new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mNmaes, ArrayList<String> mImagesUrls, Context mContext) {
        this.mNmaes = mNmaes;
        this.mImagesUrls = mImagesUrls;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            image=itemView.findViewById(R.id.imvImagen);


        }

    }
}
