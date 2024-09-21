package com.example.np.presto.Pojo;

public class Instrument {

    private int id;
    private String title;
    private String model;
    private String brand;
    private String price;
    private String modelInfo;
    private String brandInfo;
    private String category;
    private String type;
    private String address;
    private int image;

    public Instrument(int image) {
        this.image = image;
    }

    public Instrument(int id, String title, int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public Instrument(String title, String model, int image, String price) {
        this.title = title;
        this.model = model;
        this.image = image;
        this.price = price;
    }

    public Instrument(int id, String title, String model, String brand, String price, String modelInfo, String brandInfo, String category, String type, String address, int image) {
        this.id = id;
        this.title = title;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.modelInfo = modelInfo;
        this.brandInfo = brandInfo;
        this.category = category;
        this.type = type;
        this.address = address;
        this.image = image;
    }

    public Instrument() {
    }

    public Instrument(String title, String model, String brand, String price, String modelInfo, String brandInfo, String category, String type, String address, int image) {
        this.title = title;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.modelInfo = modelInfo;
        this.brandInfo = brandInfo;
        this.category = category;
        this.type = type;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(String modelInfo) {
        this.modelInfo = modelInfo;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
