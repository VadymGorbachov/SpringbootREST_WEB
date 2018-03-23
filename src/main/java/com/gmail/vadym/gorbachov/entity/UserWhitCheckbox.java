package com.gmail.vadym.gorbachov.entity;

public class UserWhitCheckbox extends User {
    private String check;

    public UserWhitCheckbox() {
    }

    public UserWhitCheckbox(int id, String login, String password, String firstname, String lastname, String chack) {
        super(id, login, password, firstname, lastname);
        this.check = chack;
    }

    public String getChack() {
        return check;
    }

    public void setChack(String chack) {
        this.check = chack;
    }

    @Override
    public String toString() {
        return "UserWhitCheckbox{" +
                "chack='" + check + '\'' +
                '}';
    }
}
