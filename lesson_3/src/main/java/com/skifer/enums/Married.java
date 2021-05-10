package com.skifer.enums;

public enum Married {

    SINGLE("Холост / одинока"),

    MARRIED("Женат / замужняя");

    private final String status;

    public String getStatus() {
        return status;
    }

    Married(String s) {
        this.status = s;
    }
}
