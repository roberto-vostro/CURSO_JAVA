package com.personalUse;

import java.util.Scanner;

public class Cajero {
    //Comenzar con la modificación
    private final int maxMenuAttempts = 3;
    private int menuAttempts = 0, newBalance = 0, balance = 0, cash = 0;
    private final Scanner inData = new Scanner(System.in);
    private final Usuario objUsuario = new Usuario();

    void mainMenu(){
        try {
            do{
                menuAttempts++;
                System.out.println("Elige una opción:" + "\n" +
                        "     1.- Consultar Saldo" + "\n" +
                        "     2.- Retirar Efectivo" + "\n" +
                        "     3.- Depositar" + "\n" +
                        "     4.- Salir");

                int selectedOption = inData.nextInt();
                switch (selectedOption){
                    case 1 -> checkBalance();
                    case 2 -> withdrawCash();
                    case 3 -> cashDeposit();
                    case 4 -> systemExit();
                    default -> System.out.println("Opción incorrecta");
                }
            }while (menuAttempts < maxMenuAttempts);
        }catch(Exception e){
            System.out.println("Dato ingresado incorrecto\n" +
                    "Error: " + e);
        }
    }

    void transactionManage(){
        if (menuAttempts == maxMenuAttempts){
            System.out.println("Transacciones Máximas Superadas");
            systemExit();
        }else {
            String strContinue;
            System.out.println("¿Realizar otra operación? SI / NO");
            strContinue = inData.next();
            if (!strContinue.equalsIgnoreCase("SI")) {
                systemExit();
            }
        }
    }

    void checkBalance(){
        balance = objUsuario.getBalance();
        System.out.println("Saldo actual " + balance);
        transactionManage();
    }

    void withdrawCash(){
        System.out.println("Indica la cantidad a retirar:" + "\n" +
                "(Solo multiplos de 100)");
        cash = inData.nextInt();
        if(cashValidate(cash)) {
            balance = objUsuario.getBalance();
            newBalance = balance - cash;
            if (newBalance >= 0) {
                if (objUsuario.uptBalance(newBalance)) {
                    System.out.println("¡Retiro exitoso!");
                } else {
                    System.out.println("Error al retirar efectivo" + "\n" +
                            "Contacta a Soporte por favor");
                }
            } else {
                System.out.println("Saldo insuficiente: " + balance);
            }
        }
        transactionManage();
    }

    void cashDeposit(){
        System.out.println("Indica la cantidad a depositar:" + "\n" +
                "(Solo multiplos de 100)");
        cash = inData.nextInt();
        if (cashValidate(cash)) {
            balance = objUsuario.getBalance();
            newBalance = balance + cash;
            if (objUsuario.uptBalance(newBalance)) {
                System.out.println("¡Deposito Exitoso!");
            } else {
                System.out.println("Error al depositar efectivo" + "\n" +
                        "Contacta a Soporte por favor");
            }
        }
        transactionManage();
    }

    void systemExit(){
        System.out.println("Cerrando sesión....." + "\n" +
                "¡Vuelva Pronto!");
        System.exit(0);
    }

    boolean cashValidate(int cash){
        boolean isValid = false;
        if (cash != 0){
            if ((cash % 100)==0){
                isValid = true;
            }else {
                System.out.println("La cantidad debe ser multiplos de 100");
            }
        }else{
            System.out.println("La cantidad no puede ser 0");
        }
        return isValid;
    }
}
