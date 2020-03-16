package com.homework.calllogapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.homework.calllogapp.models.ModelCalls;

import java.util.List;

public class CallLogRViewAdapter extends RecyclerView.Adapter<CallLogRViewAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<ModelCalls> mlistCalls;
    private boolean updateList = false;

    static CallLogRViewAdapter sInstance;

    private CallLogRViewAdapter(Context context,List<ModelCalls> listCalls) {
        mContext = context;
        mlistCalls = listCalls;
    }

    public static CallLogRViewAdapter getInstance(Context context, List<ModelCalls> listCalls) {
        if(sInstance==null) {
            sInstance = new CallLogRViewAdapter(context, listCalls);
        }
        return sInstance;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_calls,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView name, date, type;

        name = holder.name;
        date = holder.date;
        type = holder.type;

        name.setText(mlistCalls.get(position).getNumber());
        date.setText(mlistCalls.get(position).getDate());
        type.setText(mlistCalls.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return mlistCalls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,date, type;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.call_name);
            date = itemView.findViewById(R.id.call_date);
            type = itemView.findViewById(R.id.call_type);
        }

    }

    public void updateListCalls(List<ModelCalls> listCalls) {
        mlistCalls = listCalls;
    }

}
