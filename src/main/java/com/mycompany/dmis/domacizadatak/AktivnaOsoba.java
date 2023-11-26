/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dmis.domacizadatak;

/**
 *
 * @author Ivana
 */
public abstract class AktivnaOsoba extends Thread{
    private String ime;
    long najduzeVreme;
    long najkraceVreme;
    PostanskoSanduce sanduce;

    public AktivnaOsoba(String ime, long najduzeVreme, long najkraceVreme, PostanskoSanduce sanduce) throws GreskaVreme {
        if (najkraceVreme < 0 || najduzeVreme < 0 || najkraceVreme > najduzeVreme) {
            throw new GreskaVreme();
        }
        this.ime = ime;
        this.najduzeVreme = najduzeVreme;
        this.najkraceVreme = najkraceVreme;
        this.sanduce =sanduce;
    }
    public abstract void radi() throws InterruptedException;

    @Override
    public void run() {
        try{
            while(!interrupted()){
                radi();
                long vreme=(long)Math.random()*(najduzeVreme-najkraceVreme)+najkraceVreme;
                sleep(vreme);
            }
    }
        catch(InterruptedException e){}}
    
    

    @Override
    public String toString() {
        return "Ime osobe:" + ime + "\nPridruženo sanduče:" + sanduce + '}';
    }
    
    
    
}
