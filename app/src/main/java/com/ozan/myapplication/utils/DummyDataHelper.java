package com.ozan.myapplication.utils;

import com.ozan.myapplication.model.TutorialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DummyDataHelper {

    public static TutorialData getRandomTutorialData() {
        List<TutorialData> tutorialDataList = getTutorialList();
        int randPos = new Random().nextInt(tutorialDataList.size() - 1);

        return tutorialDataList.get(randPos);

    }

    public static List<TutorialData> getTutorialList() {
        List<TutorialData> tutorialDataList = new ArrayList<>();
        tutorialDataList.add(new TutorialData("Android Lesson 1","First Lesson","Ozan URKAN",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("MVVM Example","Second Lesson","Enes URKAN",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("MVP Example","Third Lesson","Baran Karaoguz",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("DataBinding Example","Forth Lesson","Atilla Keskin",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("DI Example","fifth Lesson","Omercan URKAN",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("Reactive Programming Example","sixth Lesson","Ozgur Vatandas",new Random().nextInt(250)));
        tutorialDataList.add(new TutorialData("Data Stracture","seventh Lesson","Ugurcan Kaya",new Random().nextInt(250)));
        return tutorialDataList;
    }
}
