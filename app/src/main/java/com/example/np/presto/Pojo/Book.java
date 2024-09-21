package com.example.np.presto.Pojo;

public class Book {

    private int id;
    private String title;
    private int image;
    private String description;
    private String category;
    private String type;
    private String year;
    private int level;
    private String address;
    private String publication;
    private String author;
    private String price;

    public Book() {
    }


    public Book(String title, int image, String description, String type, String year, int level, String address, String publication, String author, String price) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.type = type;
        this.year = year;
        this.level = level;
        this.address = address;
        this.publication = publication;
        this.author = author;
        this.price = price;
    }

    public Book(int id, String title, int image, String description, String category, String type, String year, int level, String address, String publication, String author, String price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.category = category;
        this.type = type;
        this.year = year;
        this.level = level;
        this.address = address;
        this.publication = publication;
        this.author = author;
        this.price = price;
    }

    public Book(String title, int image, String author, String price) {
        this.title = title;
        this.image = image;
        this.price = price;
        this.author = author;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



}
