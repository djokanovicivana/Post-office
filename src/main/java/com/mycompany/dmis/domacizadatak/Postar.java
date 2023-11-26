/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis.domacizadatak;

import java.util.ArrayList;

/**
 *
 * @author Ivana
 */
public class Postar extends AktivnaOsoba {
    private ArrayList<PostanskoSanduce> sanducici;

    public Postar(String ime, long najduzeVreme, long najkraceVreme, PostanskoSanduce sanduce) throws GreskaVreme {
        super(ime, najduzeVreme, najkraceVreme, sanduce);
        sanducici=new ArrayList<>();
       // start();
    }
    public void dodajSanduce(PostanskoSanduce sanduce){
        sanducici.add(sanduce);
    }

   public void radi(){
      synchronized(this){
      Posiljka posiljka=sanduce.getPrvaPosiljka();
      if(posiljka!=null){
      String adresa=posiljka.getAdresa();
      ArrayList<String> posiljke = new ArrayList<>();
      for(PostanskoSanduce s:sanducici){
          if(s.getAdresa().equals(adresa)){
              System.out.println("Postar je dostavio posiljku: "+posiljka);
              s.dodajPosiljku(posiljka);
              for(Posiljka p:sanduce.getPosiljke()){
                  if(p.getAdresa().equals(adresa)){
                      s.dodajPosiljku(p);
                      posiljke.add(p.getAdresa());
                      System.out.println("Postar je dostavio posiljku"+p);
                      notify();
                      for(String adresaPosiljke: posiljke){
                      sanduce.getPosiljkaZaAdresu(adresaPosiljke);
      }
                  }
          }}else{
              sanduce.dodajPosiljku(posiljka);
          }
      }}
      
      } 
      }}
       
    
 
    

