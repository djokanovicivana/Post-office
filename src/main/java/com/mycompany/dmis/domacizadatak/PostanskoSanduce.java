/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis.domacizadatak;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivana
 */
public class PostanskoSanduce {
    private String adresa;
    private ArrayList<Posiljka> posiljke;
    private int kapacitet;

    public PostanskoSanduce(String adresa, int kapacitet) {
        this.adresa = adresa;
        this.kapacitet=kapacitet;
        posiljke=new ArrayList<Posiljka>(kapacitet);
    }

    public String getAdresa() {
        return adresa;
    }

    public synchronized ArrayList<Posiljka> getPosiljke() {
        if(posiljke.isEmpty()){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        return posiljke;
    }
    public synchronized Posiljka getPrvaPosiljka(){
        if(posiljke.isEmpty()){
            try{
                wait();
                System.out.println("Ceka se posiljka za preuzimanje");
            }
            catch(InterruptedException e){}
        }else{
        Posiljka prvaPosiljka= posiljke.remove(0);
        notify();
        return prvaPosiljka;}
        return null;
    }
    public synchronized Posiljka getPosiljkaZaAdresu(String adresa){
        if(posiljke.isEmpty()){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
      for(int i=0;i<posiljke.size();i++){
          if(posiljke.get(i).getAdresa().equals(adresa))
              return posiljke.remove(i);
      }
     return null;
    }
    public  String getAdresaPrve(){
        if(posiljke.isEmpty()){
            return null;
        }else
            return posiljke.get(0).getAdresa();
            
    }
    public synchronized void dodajPosiljku(Posiljka posiljka){
        if(posiljke.size()<kapacitet){
            posiljke.add(posiljka);
            notify();
        }else {
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
    }

 @Override
public String toString() {
    String posiljkeString = "";
    for (Posiljka p: posiljke) {
        posiljkeString+=p.toString()+'\n';}
    
    return posiljkeString;
}
    
}
