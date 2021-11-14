package com.pb.kolodiazhniy.hw7;

public enum Size {
    XSS("Детский размер",32),
    XS("Взрослый размер",34),
    S("Взрослый размер",36),
    M("Взрослый размер",38),
    L("Взрослый размер",40);

    private int euroSize;
    private String description;

    Size (String description, int euroSize) {
        this.euroSize = euroSize;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getEuroSize() {
        return euroSize;
    }
}
