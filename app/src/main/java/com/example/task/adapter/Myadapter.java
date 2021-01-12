package com.example.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.Model.DataModel;
import com.example.task.R;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.myviewholder>
{    Context mcontext;
     List<DataModel> mData;

    public Myadapter(Context mcontext, List<DataModel> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(mcontext).inflate(R.layout.single_row,parent,false);

        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.textView.setText(mData.get(position).getTitle());
     //   holder.home.setText(mData.get(position).getHometown());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<DataModel> dataModel) {
        mData.addAll(dataModel);
        notifyDataSetChanged();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView textView,home;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv1);
            home=itemView.findViewById(R.id.tvhome);
        }
    }
}
