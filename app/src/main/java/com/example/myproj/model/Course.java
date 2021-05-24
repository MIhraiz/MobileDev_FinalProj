package com.example.myproj.model;

public class Course {
    private String name ;
    private String label;
    private String dep;
    private String faculty;
    private String description;
    private String credit;
    private int ImageId;

    public Course() {
    }

    public Course(String name, String label, String dep, String faculty, String description, String credit, int ImageId ) {
        this.name = name;
        this.label = label;
        this.dep = dep;
        this.faculty = faculty;
        this.description = description;
        this.credit = credit;
        this.ImageId=ImageId;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getDep() {
        return dep;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", dep='" + dep + '\'' +
                ", faculty='" + faculty + '\'' +
                ", description='" + description + '\'' +
                ", credit=" + credit +
                '}';
    }
}
