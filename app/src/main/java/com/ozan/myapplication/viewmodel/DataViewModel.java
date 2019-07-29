package com.ozan.myapplication.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.ozan.myapplication.model.TutorialData;
import com.ozan.myapplication.utils.DummyDataHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class DataViewModel extends Observable {

    public ObservableInt emptyViewVisibility;
    public ObservableInt recyclerViewVisibility;
    public ObservableField<String> emptyViewText;
    public static final int TOTAL_RESULT = 100;

    public Context context;
    public List<TutorialData> tdList;

    public DataViewModel(Context context) {
        this.context = context;
        this.tdList = new ArrayList<>();
        changeDataSet();
    }

    public void changeDataSet() {
        tdList.clear();
        tdList.addAll(DummyDataHelper.getTutorialList());
        setChanged();
        notifyObservers();
    }
    public List<TutorialData> getAllTdList(){
        return tdList;
    }
    public void onClickFAB(View view){
        changeDataSet();
    }
}
