package com.example.sabahaksamtok;

public class Hasta {

    String hastaid;
    String hastailacad;
    String hastasabahaksam;
    String hastaactok;
    String hastasaat;
    String hastatarih;

    public Hasta(){

    }
    public Hasta(String hastaid, String hastailacad, String hastasabahaksam, String hastaactok, String hastasaat, String hastatarih) {
        this.hastaid = hastaid;
        this.hastailacad = hastailacad;
        this.hastasabahaksam = hastasabahaksam;
        this.hastaactok = hastaactok;
        this.hastasaat = hastasaat;
        this.hastatarih = hastatarih;
    }

    public String getHastaid() {
        return hastaid;
    }

    public void setHastaid(String hastaid) {
        this.hastaid = hastaid;
    }

    public String getHastailacad() {
        return hastailacad;
    }

    public void setHastailacad(String hastailacad) {
        this.hastailacad = hastailacad;
    }

    public String getHastasabahaksam() {
        return hastasabahaksam;
    }

    public void setHastasabahaksam(String hastasabahaksam) {
        this.hastasabahaksam = hastasabahaksam;
    }

    public String getHastaactok() {
        return hastaactok;
    }

    public void setHastaactok(String hastaactok) {
        this.hastaactok = hastaactok;
    }

    public String getHastasaat() {
        return hastasaat;
    }

    public void setHastasaat(String hastasaat) {
        this.hastasaat = hastasaat;
    }

    public String getHastatarih() {
        return hastatarih;
    }

    public void setHastatarih(String hastatarih) {
        this.hastatarih = hastatarih;
    }
}
