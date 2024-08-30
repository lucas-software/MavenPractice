package org.example.Staffers;

public final class Intern extends Staff implements Trainable, Payable {
    // Final Variable
    private final int internshipDuration;

    // Constructor
    public Intern(int id, int internshipDuration) {
        super(id);
        this.internshipDuration = internshipDuration;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode(Object obj) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public void work() {
        System.out.println("Intern is working on assigned tasks.");
    }

    @Override
    public void takeBreak() {
        System.out.println("Intern is taking a break.");
    }

    @Override
    public void attendTraining() {
        System.out.println("Intern is attending onboarding training.");
    }

    @Override
    public void receiveSalary() {
        System.out.println("Intern is receiving stipend.");
    }

    // Final Method
    public final void displayInternshipDuration() {
        System.out.println("Internship duration: " + internshipDuration + " months");
    }
}

