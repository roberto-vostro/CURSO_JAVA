package com.personalUse;

import java.util.Scanner;

public class Cajero {
    private int loginAttempts = 0;
    private final Scanner inData = new Scanner(System.in);
    private final Usuario objUsuario = new Usuario();

    public Cajero(){
        System.out.println("=================================\n"+
                "======¡INICIANDO SISTEMA!========\n"+
                "=================================\n");
    }
    public void startCajero(){
        String id, name = "";
        int maxLoginAttempts = 3;
        do{
            loginAttempts++;
            System.out.println("Ingresa tu ID de Banco:");
            id = inData.next();
            if(objUsuario.userValidate(id)){
                name = objUsuario.getName();
                if(!objUsuario.isBlocked()){
                    System.out.println("Bienvenido/a " + name);
                    //mainMenu();
                }else {
                    System.out.println("¡" + name + " tu cuenta esta bloqueada!" + "\n" +
                            "Contacta a Soporte por favor");
                    //systemExit();
                }
            }else{
                System.out.println("Usuario no encontrado " + name);
                if (loginAttempts == maxLoginAttempts){
                    System.out.println("Máximo de reintentos superado ("+loginAttempts+")");
                }
            }
        }while (loginAttempts < maxLoginAttempts);
    }
}
