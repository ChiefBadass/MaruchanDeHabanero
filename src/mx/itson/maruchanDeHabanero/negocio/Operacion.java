/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.maruchanDeHabanero.negocio;



/**
 * Contiene metodos para realizar operaciones diversas.
 * @author Carlos Daniel Rebollo Toledo y Gabriela Pérez Bello.
 */
public class Operacion {
     /**
      * 
      * @param nombre Dato que sera modificado para la creacion de una CURP.
      * @param primerApellido Dato que sera modificado para la creacion de una CURP.
      * @param segundoApellido Dato que sera modificado para la creacion de una CURP.
      * @param dia Dato que sera modificado para la creacion de una CURP.
      * @param mes Dato que sera modificado para la creacion de una CURP.
      * @param año Dato que sera modificado para la creacion de una CURP.
      * @param sexo Dato que sera modificado para la creacion de una CURP.
      * @param estado Dato que sera modificado para la creacion de una CURP.
      * @return Una CURP de los datos ingresados.
      */
    public String consultaCurp(String nombre,String primerApellido,String segundoApellido,String dia,String mes, String año, String sexo, String estado){
        //Creacion de variables y arreglos.
        Estado estados = new Estado();
        nombre = nombre.trim().replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u").toUpperCase();
        String curp = "";
        String consonantes = "BCDFGHJKLMNPQRSTVXZWY";
        String vocales = "AEIOU"; 
        String[] nombreCompuesto = nombre.split(" ");
        String comparacion = "MARIA";
        String comparacion2 = "JOSE";
        char primeraConsonante = 0;
        char primeraConsonante2 = 0;
        char primeraConsonante3 = 0;        
        char inicialVocal = 0;
        char[] inicialNombre = nombre.toCharArray();
        char[] consonante = consonantes.toCharArray();
        char[] vocal = vocales.toCharArray();
        char[] primerApe = primerApellido.trim().replace(" ", "").replace("ñ", "x").replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u").toUpperCase().toCharArray();
        char[] segundoApe = segundoApellido.trim().replace(" ", "").replace("ñ", "x").replace("ú","u").replace("á","a").replace("é","e").replace("í","i").replace("ó","o").toUpperCase().toCharArray();
        //Se añadio la inicial del primer apellido.
        curp += primerApe[0] ;   
        //Ciclo para obtener la primera vocal del primer apellido.
        for(int a = primerApe.length - 1; a>=1; a--){           
            for(int b = vocal.length - 1; b>=0; b--){
                if (primerApe[a] == vocal[b]){
                  inicialVocal = primerApe[a];
                }
            }
        }
        //Se añadio la primera vocal del apellido.
        curp += inicialVocal;
        //Condicional para determinar la inicial del segundo apellido,
        //dependiendo del resultado se le asigna cierto valor.
        if(segundoApellido.trim().equals("") ){
           curp += "X";
        }else{           
            curp += segundoApe[0]; 
        }
        /*
        Condicional con ciclos for.
        En este apartado de aqui se determinan diferentes variables,
        una es la inicial del nombre que sera agregada en cuanto se cumpla la condicion
        y otra que sera la primera consonante no inicial del nommbre, que sera
        agregada mas adelante en el codigo.
        */
        if(nombre.equals("JOSE") || nombre.equals("MARIA")){
            curp += inicialNombre [0];
            for(int b = inicialNombre.length - 1; b>=1; b--){
                    for(int c = consonante.length - 1; c>=0; c--){
                       if(inicialNombre[b]==consonante[c]){
                         primeraConsonante3 = inicialNombre[b];
                       }
                    }
                }
        }else{
            if(comparacion.equals(nombreCompuesto[0]) || comparacion2.equals(nombreCompuesto[0])){
            char[] inicialCompuesta = nombreCompuesto[1].toCharArray();
            curp += inicialCompuesta[0];
             for(int b = inicialCompuesta.length - 1; b>=1; b--){
                for(int c = consonante.length - 1; c>=0; c--){
                    if(inicialCompuesta[b]==consonante[c]){
                        primeraConsonante3 = inicialCompuesta[b];
                    }
                }
            }                       
            }else{
                 curp += inicialNombre [0];
                 for(int b = inicialNombre.length - 1; b>=1; b--){
                    for(int c = consonante.length - 1; c>=0; c--){
                       if(inicialNombre[b]==consonante[c]){
                         primeraConsonante3 = inicialNombre[b];
                       }
                    }
                }
            }                 
        }
        //Creacion de varibles y arreglo. 
        int diaInt = Integer.parseInt(dia);    
        int mesInt = Integer.parseInt(mes);
        char[] fecha = año.toCharArray();
        //Condicionales para la asignacion de fecha y agregarla
        //Cuando se cumpla la condicion.
        if(diaInt < 10 & diaInt > 0 & mesInt < 10 & mesInt > 0){   
            mes = Integer.toString(mesInt);
            dia = Integer.toString(diaInt);
            curp+= fecha[2];
            curp+= fecha[3]+"0"+mes+"0"+dia;
        }else{
            if(mesInt>0 & mesInt < 10){
                mes = Integer.toString(mesInt);
                curp+= fecha[2];
                curp += fecha[3]+"0"+mes+dia;             
            }else{
                
                if(diaInt < 10 & diaInt > 0){
                    dia = Integer.toString(diaInt);
                    curp += fecha[2];
                    curp += fecha[3]+mes+"0"+dia;
                }else{
                    curp+= fecha[2];
                    curp+= fecha[3]+mes+dia;
                }  
            }   
        }
        //Condicion para determinar el sexo de la persona.
        if(sexo.startsWith("H")){
            curp+="H";
        }else{
            curp+="M";
        }
        //Se agrega el sexo de la persona.
        curp+= estados.estadoClave(estado);
        //Ciclos for y condicional para determinar la primera consonate no inicial del primer apellido.
        for(int b = primerApe.length - 1; b>=1; b--){
           for(int c = consonante.length - 1; c>=0; c--){
               if(primerApe[b]==consonante[c]){
                   primeraConsonante = primerApe[b];
               }                
           }           
        }
        //Se agrega la primera consonate no inicial del primer apellido.
        curp += primeraConsonante;
        //Condicionales y ciclos for para determinar la primera consonante no inicial 
        //del segundo apellido, dependiendo del resultado se le asigna cierto valor.
        if(segundoApellido.replace(" ", "").equals("") ){
            curp += "X";
        }else{
           for(int x = segundoApe.length - 1; x>=1; x--){
              for(int c = consonante.length - 1; c>=0; c--){
               if(segundoApe[x]==consonante[c]){
                   primeraConsonante2 = segundoApe[x];
                }
              }
            }  
           curp += primeraConsonante2;
        }
        //Se agrega la primera consonante no inicial del nombre.
        curp += primeraConsonante3;
        //Creacion de varible y condicional para determinar en que año nacio y se le agrega.
        int añoInt = Integer.parseInt(año);
        if(añoInt >1999){
            curp += "A";          
        }else{
            curp+= "0";
        }
        //Se agrega un 1.
        curp+= "1";
        //Retorna la curp ya completa.
        return curp;
    }
    
}
