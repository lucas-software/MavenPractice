package org.example.Staffers;

public class Worker extends Staff{
    protected String role;
    public Worker(int id,String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Coordinator[Role: " + role + ",\n Id: " +getId();
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
        System.out.println("Worker is working on technical tasks.");
    }

    @Override
    public void takeBreak() {
        System.out.println("Worker is taking a break.");
    }

}

