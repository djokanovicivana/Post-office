/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis.domacizadatak;

/**
 *
 * @author Ivana
 */
public class Posiljka implements Cloneable {
    private static int id=0;
    private int idPosiljka;
    private String adresa;

    public Posiljka(String adresa) {
        this.idPosiljka = id++;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    @Override
    protected Posiljka clone() throws CloneNotSupportedException {
        Posiljka p=(Posiljka)super.clone();
        p.idPosiljka=id++;
        return p;
    }

    @Override
    public String toString() {
        return idPosiljka+ " [" +adresa + "]";
    }
    
    
    
    
    
    
    
}
