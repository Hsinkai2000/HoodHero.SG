package com.example.hoodherosg.ui.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoodherosg.R;
import com.example.hoodherosg.databinding.FragmentHomeBinding;
import com.example.hoodherosg.ui.Reports.RecyclerViewAdapter;
import com.example.hoodherosg.ui.Reports.RecyclerViewPastAdapter;
import com.example.hoodherosg.ui.Reports.Report;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;

    private ArrayList<Drawable> ImageUrls = new ArrayList<>();
    private ArrayList<String> ImageNames = new ArrayList<>();
    private ArrayList<Report> reportsArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        initImages();
        final TextView textView = binding.txtNearbyReports;

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
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

        reportsArrayList.add(new com.example.hoodherosg.ui.Reports.Report("11.12.2022", "Carpark 1A", "Gantry broken at main entrance"));
        reportsArrayList.add(new com.example.hoodherosg.ui.Reports.Report("5.11.2022", "Carpark 2A", "Gantry broken at main entrance"));
        reportsArrayList.add(new com.example.hoodherosg.ui.Reports.Report("4.8.2022", "Carpark 3B", "Gantry broken at main entrance"));
        reportsArrayList.add(new com.example.hoodherosg.ui.Reports.Report("4.8.2022", "Lift 453", "Up Button not working"));
        reportsArrayList.add(new com.example.hoodherosg.ui.Reports.Report("2.3.2022", "Lift 182", "Door wont close"));
        reportsArrayList.add(new Report("1.2.2022", "Carpark 1A", "Gantry broken at main entrance"));
        initRecyclerpast();
        initRecycler();
    }
    private void initRecycler(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = binding.recyclerviewreports;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(ImageUrls, ImageNames, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initRecyclerpast(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = binding.recyclerviewforum;
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