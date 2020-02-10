package com.example.webservice;

public class Car {

    private String plateNumber;
    private String brand;
    private String model;
    private int price;
    private Rent rent;

    public Car(String plateNumber, String brand, String model, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Car(String plateNumber) {
    	this.plateNumber = plateNumber;		
	}

	public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

}