package com.example.hoodherosg.ui.Reports;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReportsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReportsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ongoing Reports");

    }

    public LiveData<String> getText() {
        return mText;
    }
}