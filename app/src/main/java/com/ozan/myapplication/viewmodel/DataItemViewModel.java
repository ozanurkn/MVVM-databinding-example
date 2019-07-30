package com.ozan.myapplication.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.ozan.myapplication.model.TutorialData;

public class DataItemViewModel extends BaseObservable {

    private Context context;
    private TutorialData tutorialData;

    public DataItemViewModel(Context context, TutorialData tutorialData) {
        this.context = context;
        this.tutorialData = tutorialData;
    }

    public void setTutorialData(TutorialData tutorialData) {
        this.tutorialData = tutorialData;
        notifyChange();
    }

    public String getTitle() {
        return tutorialData.getTutorialTitle();
    }

    public String getDescription() {
        return tutorialData.getTutorialDescription();
    }

    public String getAuthorName() {
        return tutorialData.getAuthorName();
    }

    public int getNumberOfReading() {
        return tutorialData.getNumberOfReadings();
    }

    public String getJustForExample(){
        return tutorialData.getJustExample();
    }
}
