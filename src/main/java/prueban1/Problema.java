/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueban1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Problema {
    public double[][] Matriz(int n){
        double mat[][]=new double[n][24];
        return mat;
    }
    public double [][] llenado(double mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
              mat[i][j]=Math.random()*8.5+1;  
            }
        }
        return mat;
    }
    public double buscarMayor(double mat[][]){
        double mayor=0;
        int dias=0,hora=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
              if(mat[i][j]>mayor){
                  mayor=mat[i][j];
                  dias=i;
                  hora=j;
              } 
            }
        }
        return mayor;
    }
    public int buscarDia(double mat[][]){
        double mayor=0;
        int dias=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
              if(mat[i][j]>mayor){
                  dias=i;
              } 
            }
        }
        return dias;
    }public int buscarHora(double mat[][]){
        double mayor=0;
        int hora=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
              if(mat[i][j]>mayor){
                  hora=j;
              } 
            }
        }
        return hora;
    }
    public void mayorIntensidad(double mat[][]){
        int dia=buscarDia(mat);
        int hora=buscarHora(mat);
        double inten=buscarMayor(mat);
        System.out.println("El día "+(dia+1)+", a las "+(hora+1)+", se registra sismo más intenso, con un valor de "+inten+" en la escala de Richter");
    }
    public int[] cantidadSismo(double mat[][]){
        double mayor=0;
        int cont=0;
        int filas[]=new int[mat.length];
        for(int i=0;i<mat.length;i++){
            cont=0;
            for(int j=0;j<mat[0].length;j++){
              if(mat[i][j]>=4.0){
                  cont++;
              } 
            }
            filas[i]=cont;
        }
        return filas;
    }
    public void imprimirDias(double mat[][]){
        int filas[]=cantidadSismo(mat);
        for(int i=0;i<filas.length;i++){
            System.out.println("dia "+i+1+": "+filas[i]+" veces");
        }
    }
    public static int pedirNum() {
        int numero;
        Scanner entrada = new Scanner(System.in);
        System.out.println("introdusca un numero entero entre 1 y 3 segun la opcion que desee");
        try{
            numero = entrada.nextInt();
            if (numero <0 || numero >3) {
                numero = pedirNum();
            }
        }catch(InputMismatchException e) {
            numero=pedirNum();
        }
        return numero;
    }
    public void menu(){
        int num=pedirNum();
        double tabla[][]=llenado(Matriz(num));
        System.out.println("Ingrese el numero de la opcion que desea realizar \n 1.dia de mayor intensidad"
                + " \n 2.dias con sismos mayor a 4"
                + " \n 3.salir ");
            switch(num){
                case 1:
                   mayorIntensidad(tabla);
                case 2:
                    imprimirDias(tabla);
                case 3:
                    break;

            }
    }
    
}
