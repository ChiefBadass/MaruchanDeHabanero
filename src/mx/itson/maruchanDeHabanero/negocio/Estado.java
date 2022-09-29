/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.maruchanDeHabanero.negocio;

/**
 * Contiene nombres de estados con su respectiva clave.
 * @author Carlos Daniel Rebollo Toledo y Gabriela Pérez Bello.
 */
public class Estado {
    /**
     * Arroga la clave de un estado.
     * @param estado Frase a evaluar.
     * @return La clave unica de cada estado.
     */
    public String estadoClave(String estado){
        String claveUnica = "";
        estado = estado.replace(" ", "").replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u").toUpperCase();
        String estadoConClave = "Aguascalientes AS,BajaCalifornia BC,BajaCaliforniasu BS,Campache CC,Coahuila CL,Colima CM,Chiapas CS,Chihuahua CH,DistritoFederal DF,Durango DG,Guanajuato GT,Guerrero GR,Hidalgo HG,Jalisco JC,Mexico MC,Michoacan MN,Morelos MS,Nayarit NT,NuevoLeon NL,Oaxaca OC,Puebla PL,Queretaro QT,QuintanaRoo QR,SanLuisPotosi SP,Sinaloa SL,Sonora SR,Tabasco TC,Tamaulipas TS,Tlaxcala TL,Veracruz VZ,Yucatan YN,Zacatecas ZS,Nacidoenelextranjero NE";
        String[] estados = estadoConClave.toUpperCase().split(",");
         for(String a : estados){
             String[] clave = a.split(" ");
             for(String b : clave){
                 if(estado.equals(b)){
                     claveUnica = clave[1];
                 }
             }
         }
        return claveUnica;
    }  
}
