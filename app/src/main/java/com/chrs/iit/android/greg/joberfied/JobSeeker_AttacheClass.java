package com.chrs.iit.android.greg.joberfied;

/**
 * Created by greg on 7/20/16.
 */
public class JobSeeker_AttacheClass {

            String adsTitle,
                   adsQualifications,
                   adsSkills,
                   adsRefer;
    int adsLogo,
        adsBackground;


    public JobSeeker_AttacheClass(String adsTitle, String adsQualifications, String adsSkills, String adsRefer, int adsLogo, int adsBackground) {
        this.adsTitle = adsTitle;
        this.adsQualifications = adsQualifications;
        this.adsSkills = adsSkills;
        this.adsRefer = adsRefer;
        this.adsLogo = adsLogo;
        this.adsBackground = adsBackground;
    }

    public String getAdsTitle() {
        return adsTitle;
    }

    public void setAdsTitle(String adsTitle) {
        this.adsTitle = adsTitle;
    }

    public String getAdsQualifications() {
        return adsQualifications;
    }

    public void setAdsQualifications(String adsQualifications) {
        this.adsQualifications = adsQualifications;
    }

    public String getAdsSkills() {
        return adsSkills;
    }

    public void setAdsSkills(String adsSkills) {
        this.adsSkills = adsSkills;
    }

    public String getAdsRefer() {
        return adsRefer;
    }

    public void setAdsRefer(String adsRefer) {
        this.adsRefer = adsRefer;
    }

    public int getAdsLogo() {
        return adsLogo;
    }

    public void setAdsLogo(int adsLogo) {
        this.adsLogo = adsLogo;
    }

    public int getAdsBackground() {
        return adsBackground;
    }

    public void setAdsBackground(int adsBackground) {
        this.adsBackground = adsBackground;
    }
}
