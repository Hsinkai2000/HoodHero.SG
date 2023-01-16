package com.example.hoodherosg.ui.Reports;

import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hoodherosg.R;
import com.example.hoodherosg.databinding.FragmentReportsBinding;

import java.util.ArrayList;

public class ReportsFragment extends Fragment {

private FragmentReportsBinding binding;

    private ArrayList<Drawable> ImageUrls = new ArrayList<>();
    private ArrayList<String> ImageNames = new ArrayList<>();
    private ArrayList<Report> reportsArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        ReportsViewModel reportsViewModel =
                new ViewModelProvider(this).get(ReportsViewModel.class);

    binding = FragmentReportsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        initImages();
        final TextView textView = binding.textReports;
        final Button makeReport = binding.button;

        makeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, new MakeReportFragment());
                fragmentTransaction.addToBackStack("Back");
                fragmentTransaction.commit();
            }
        });

        reportsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void goToMakeReport(){

    }

    private void initImages(){
        Drawable drawable = getResources().getDrawable(R.drawable.dummy);

        ImageUrls.add(drawable);
        ImageNames.add("Happy Vinayaka");
        Drawable drawable2 = getResources().getDrawable(R.drawable.events);
        ImageUrls.add(drawable2);
        ImageNames.add("Restaurants");
        Drawable drawable3 = getResources().getDrawable(R.drawable.account);
        ImageUrls.add(drawable3);
        ImageNames.add("Hot Dogs");

        Drawable drawable4 = getResources().getDrawable(R.drawable.reports);
        ImageUrls.add(drawable4);
        ImageNames.add("Pani Puri");

        ImageUrls.add(drawable);
        ImageNames.add("KFC Chicken");

        reportsArrayList.add(new Report("11.12.2022", "Carpark 1A", "Gantry broken at main entrance"));
        reportsArrayList.add(new Report("5.11.2022", "Carpark 2A", "Gantry broken at main entrance"));
        reportsArrayList.add(new Report("4.8.2022", "Carpark 3B", "Gantry broken at main entrance"));
        reportsArrayList.add(new Report("4.8.2022", "Lift 453", "Up Button not working"));
        reportsArrayList.add(new Report("2.3.2022", "Lift 182", "Door wont close"));
        reportsArrayList.add(new Report("1.2.2022", "Carpark 1A", "Gantry broken at main entrance"));
        initRecyclerpast();
        initRecycler();
    }
    private void initRecycler(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = binding.recyclerview;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(ImageUrls, ImageNames, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initRecyclerpast(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = binding.recyclerviewpast;
        RecyclerViewPastAdapter adapter = new RecyclerViewPastAdapter(reportsArrayList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}