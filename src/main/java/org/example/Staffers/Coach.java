package org.example.Staffers;

public class Coach extends Staff implements Trainable, Payable, Promotable, Reportable, Insurable{

    private String name;
    private int age;

    public Coach(int id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Coordinator[Name: " + name + ",\n" + "Age: " + age + ",\n" + "Id: " +getId();
    }
    @Override
    public int hashCode(Object obj){
        return obj.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {return true;}
        else{return false;}

    }

    @Override
    public void work() {
        System.out.println("Coach is working on technical tasks.");
    }

    @Override
    public void takeBreak() {
        System.out.println("Coach is taking a break.");
    }

    @Override
    public void attendTraining() {
        System.out.println("Coach is attending technical training.");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Coach is received salary.");
    }

    @Override
    public void getPromotion() {
        System.out.println("Coach is getting promoted.");
    }

    @Override
    public void submitReport() {
        System.out.println("Coach is submitting a report.");
    }

    @Override
    public void enrollInsurance() {
        System.out.println("Coach is enrolling in insurance.");
    }
}
