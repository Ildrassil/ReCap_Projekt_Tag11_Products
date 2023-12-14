package org.example;

public enum OrderStatus {

    IN_BEARBEITUNG("IB"),
    VERSENDET("V"),
    ABGESCHLOSSEN("A");

    private String abkürzung;

    OrderStatus(String a) {
        abkürzung  = a;
    }
    public String getAbkürzung(){
        return abkürzung;
    }
    public void setAbkürzung(String a){
        this.abkürzung = a;
    }
}
