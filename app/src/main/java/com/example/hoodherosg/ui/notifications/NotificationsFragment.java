package com.example.hoodherosg.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hoodherosg.R;
import com.example.hoodherosg.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    //ListView
    ListView listView;

    //Data to be displayed into list
    String[] Status = {
            "A Maintenance Report  has been posted ", "Report has been rectified"
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        setContentView(R.layout.fragment_notifications);

        listView = (ListView) findViewByID(R.id.listview);

        //Array Adapter:
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                Status
        );

        listView.setAdapter(adapter);
    }

    private void setContentView(int fragment_notifications) {
    }

    private Object findViewByID(int listview) {
        return null;
    }

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

    binding = FragmentNotificationsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        return root;
    }}


