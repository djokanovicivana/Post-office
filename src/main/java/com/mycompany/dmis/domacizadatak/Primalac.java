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
public class Primalac extends AktivnaOsoba {

    public Primalac(String ime, long najduzeVreme, long najkraceVreme, PostanskoSanduce sanduce) throws GreskaVreme {
        super(ime, najduzeVreme, najkraceVreme, sanduce);
        //start();
    }

    public void setSanduce(PostanskoSanduce sanduce) {
        this.sanduce = sanduce;
    }
    
    
   public void radi(){
        synchronized(this){
        while(true){
        Posiljka posiljka=sanduce.getPrvaPosiljka();
        if(posiljka!=null){
        System.out.println("Primalac je preuzeo posiljku:"+posiljka);}
        notify();
        }}
    
        }
    }
   
    
    
    
