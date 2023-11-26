/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dmis.domacizadatak;

/**
 *
 * @author Ivana
 */
public class DMiSDomaciZadatak {

    public static void main(String[] args) throws InterruptedException, GreskaVreme {
        Postar postar=new Postar("Ivana", 50000, 10000, new PostanskoSanduce("Bulevar Kraljice Marije 3A", 5));
        postar.sanduce.dodajPosiljku(new Posiljka("Kralja Aleksandra 2"));
        postar.sanduce.dodajPosiljku(new Posiljka("Kralja Aleksandra 25"));
        postar.sanduce.dodajPosiljku(new Posiljka("Kralja Aleksandra 2"));
        postar.sanduce.dodajPosiljku(new Posiljka("Kralja Aleksandra 25"));
        PostanskoSanduce sanducePrimaoca=new PostanskoSanduce("Kralja Aleksandra 2", 3);
        postar.dodajSanduce(sanducePrimaoca);
        System.out.println(postar);
        Primalac primalac=new Primalac("Aleksa", 30000,15000, sanducePrimaoca);
        postar.start();
        primalac.start();
        Thread.sleep(50000);
        postar.interrupt();
        primalac.interrupt();
        System.out.println(postar);
        System.out.println(primalac);
       
        
        
    }
}
