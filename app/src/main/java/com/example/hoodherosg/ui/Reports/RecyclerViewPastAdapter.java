package com.example.hoodherosg.ui.Reports;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hoodherosg.R;
import com.example.hoodherosg.databinding.FragmentReportsBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewPastAdapter extends RecyclerView.Adapter<RecyclerViewPastAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Report> mReports = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewPastAdapter(ArrayList<Report> mReports, Context mcontext) {
        this.mReports = mReports;
        this.mcontext = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_past_reports, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Images Set");

        holder.textDate.setText(mReports.get(position).mdate);
        holder.textTitle.setText(mReports.get(position).mtitle);
        holder.textDesc.setText(mReports.get(position).mdescription);
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked");
                Toast.makeText(mcontext, mReports.get(position).mtitle, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textDate;
        TextView textTitle;
        TextView textDesc;
        RelativeLayout parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            textDate = itemView.findViewById(R.id.textDate);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}