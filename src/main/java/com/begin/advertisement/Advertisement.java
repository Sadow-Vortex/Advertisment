package com.begin.advertisement;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adv_id;

    private int advUserID;
    private int adv_CategoryID;
    private int advSubCategoryID;
    private String adv_Title;
    private String adv_Description;
    private int adv_Unit;
    private double adv_Price;
    private String adv_Address;
    private String adv_Image;
    private Date adv_Date = new Date();
    private boolean adv_Status;
    private Location adv_Location;

    private int count;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public Location getAdv_Location() {
        return adv_Location;
    }

    public void setAdv_Location(Location adv_Location) {
        this.adv_Location = adv_Location;
    }

    public int getAdv_id() {
        return adv_id;
    }

    public void setAdv_id(int adv_id) {
        this.adv_id = adv_id;
    }

    public int getAdvUserID() {
        return advUserID;
    }

    public void setAdvUserID(int adv_UserID) {
        this.advUserID = adv_UserID;
    }

    public int getAdv_CategoryID() {
        return adv_CategoryID;
    }

    public void setAdv_CategoryID(int adv_CategoryID) {
        this.adv_CategoryID = adv_CategoryID;
    }

    public int getAdvSubCategoryID() {
        return advSubCategoryID;
    }

    public void setAdvSubCategoryID(int advSubCategoryID) {
        this.advSubCategoryID = advSubCategoryID;
    }

    public String getAdv_Title() {
        return adv_Title;
    }

    public void setAdv_Title(String adv_Title) {
        this.adv_Title = adv_Title;
    }

    public String getAdv_Description() {
        return adv_Description;
    }

    public void setAdv_Description(String adv_Description) {
        this.adv_Description = adv_Description;
    }

    public int getAdv_Unit() {
        return adv_Unit;
    }

    public void setAdv_Unit(int adv_Unit) {
        this.adv_Unit = adv_Unit;
    }

    public double getAdv_Price() {
        return adv_Price;
    }

    public void setAdv_Price(double adv_Price) {
        this.adv_Price = adv_Price;
    }

    public String getAdv_Address() {
        return adv_Address;
    }

    public void setAdv_Address(String adv_Address) {
        this.adv_Address = adv_Address;
    }

    public String getAdv_Image() {
        return adv_Image;
    }

    public void setAdv_Image(String adv_Image) {
        this.adv_Image = adv_Image;
    }

    public Date getAdv_Date() {
        return adv_Date;
    }

    public void setAdv_Date(Date adv_Date) {
        this.adv_Date = adv_Date;
    }

    public boolean isAdv_Status() {
        return adv_Status;
    }

    public void setAdv_Status(boolean adv_Status) {
        this.adv_Status = adv_Status;
    }
}
