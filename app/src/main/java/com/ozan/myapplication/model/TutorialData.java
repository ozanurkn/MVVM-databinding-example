package com.ozan.myapplication.model;

public class TutorialData {
    private String tutorialTitle;
    private String tutorialDescription;
    private String authorName;
    private int numberOfReadings;
    private String justExample;

    public String getJustExample() {
        return justExample;
    }

    public void setJustExample(String justExample) {
        this.justExample = justExample;
    }

    public TutorialData(String tutorialTitle, String tutorialDescription, String authorName, int numberOfReadings) {
        this.tutorialTitle = tutorialTitle;
        this.tutorialDescription = tutorialDescription;
        this.authorName = authorName;
        this.numberOfReadings = numberOfReadings;
    }

    public String getTutorialTitle() {
        return tutorialTitle;
    }

    public void setTutorialTitle(String tutorialTitle) {
        this.tutorialTitle = tutorialTitle;
    }

    public String getTutorialDescription() {
        return tutorialDescription;
    }

    public void setTutorialDescription(String tutorialDescription) {
        this.tutorialDescription = tutorialDescription;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfReadings() {
        return numberOfReadings;
    }

    public void setNumberOfReadings(int numberOfReadings) {
        this.numberOfReadings = numberOfReadings;
    }
}
