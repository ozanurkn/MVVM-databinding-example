package com.ozan.myapplication.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.ozan.myapplication.R;
import com.ozan.myapplication.model.TutorialData;
import com.ozan.myapplication.utils.DummyDataHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class DataViewModel extends Observable {

    public ObservableInt recyclerVisibility;
    public ObservableField<String> hideButtonText;
    public Context context;
    public List<TutorialData> tdList;

    public DataViewModel(Context context) {
        this.context = context;
        this.tdList = new ArrayList<>();
        changeDataSet();
        recyclerVisibility = new ObservableInt(View.VISIBLE);
        hideButtonText = new ObservableField<>("göster");
    }

    public void changeDataSet() {
        tdList.clear();
        tdList.addAll(DummyDataHelper.getTutorialList());
        setChanged();
        notifyObservers();
    }

    public List<TutorialData> getAllTdList() {
        return tdList;
    }

    public void onClickFAB(View view) {
        if (isVisible()){
            changeDataSet();
        }else{
            recyclerVisibility.set(View.VISIBLE);
            changeDataSet();
        }



    }

    public void onClickHide(View view) {
        if (recyclerVisibility.get() == View.VISIBLE) {
            recyclerVisibility.set(View.GONE);
            hideButtonText.set(context.getString(R.string.show));
        } else {
            recyclerVisibility.set(View.VISIBLE);
            hideButtonText.set(context.getString(R.string.hide));
        }

    }

    public boolean isVisible() {
        if (recyclerVisibility.get() == View.VISIBLE) {
            return true;
        } else {
            return false;
        }
    }

}
