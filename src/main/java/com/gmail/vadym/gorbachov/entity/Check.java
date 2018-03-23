package com.gmail.vadym.gorbachov.entity;

public class Check {
    private String ok;
    private int id;

    public Check() {
    }

    public Check(String ok, int id) {
        this.ok = ok;
        this.id = id;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Check{" +
                "ok='" + ok + '\'' +
                ", id=" + id +
                '}';
    }
}
