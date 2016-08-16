package com.chrs.iit.android.greg.joberfied;

/**
 * Created by greg on 8/15/16.
 */
public class Employer_AttacheClass {

            public int employerImage;
            public int employerStatus;
            public String pinNum,
                          appSkills;

            public boolean isExploring;

    public Employer_AttacheClass(){

    }

    public Employer_AttacheClass(int employerImage, int employerStatus, String pinNum, String appSkills, boolean isExploring) {
        this.employerImage = employerImage;
        this.employerStatus = employerStatus;
        this.pinNum = pinNum;
        this.appSkills = appSkills;
        this.isExploring = isExploring;
    }

    public int getEmployerImage() {
        return employerImage;
    }

    public int getEmployerStatus() {
        return employerStatus;
    }

    public String getPinNum() {
        return pinNum;
    }

    public String getAppSkills() {
        return appSkills;
    }

    public boolean isExploring() {
        return isExploring;
    }
}
