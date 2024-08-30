package org.example.Staffers;

public abstract class Staff {
    protected int id;

    protected Staff(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public abstract String toString();

    public abstract int hashCode(Object obj);

    public abstract boolean equals(Object obj);

    abstract void work();

    abstract void takeBreak();
}
