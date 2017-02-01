/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob;

/**
 *
 * @author dyno
 */
public class Tour {
    
private int IDTour;
private String title; 
private String shortDescription;
private String longDescription;
private int availablePlaces;
private float price;
private String destinationName;
private String mounth;

    public Tour(int IDTour, String title, String shortDescription, String longDescription, int availablePlaces, float price, String destinationName, String mounth) {
        this.IDTour = IDTour;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.availablePlaces = availablePlaces;
        this.price = price;
        this.destinationName = destinationName;
        this.mounth = mounth;
    }

    public int getIDTour() {
        return IDTour;
    }

    public void setIDTour(int IDTour) {
        this.IDTour = IDTour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getMounth() {
        return mounth;
    }

    public void setMounth(String mounth) {
        this.mounth = mounth;
    }



}
