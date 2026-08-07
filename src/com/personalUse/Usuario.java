package com.personalUse;

public class Usuario {
    private final String[][] arrUsuarios = {{"Roberto","123abc","5000","1"},
            {"Liz","abc123","12000","0"}};
    private String name;
    private int balance, indexUser = -1;
    private boolean blocked = false;

    public boolean userValidate(String id){
        boolean existUser = false;
        for (String[] arrUsuario : arrUsuarios) {
            indexUser++;
            if (id.equals(arrUsuario[1])) {
                existUser = true;
                name = arrUsuario[0];
                balance = Integer.parseInt(arrUsuario[2]);
                if(!arrUsuario[3].equals("0")){
                    blocked = true;
                }
                break;
            }
        }
        return existUser;
    }

    public boolean uptBalance(int newBalance){
        boolean updatedBalance = false;
        if(indexUser>=0){
            this.balance = newBalance;
            arrUsuarios[indexUser][2] = String.valueOf(newBalance);
            updatedBalance = true;
        }
        return updatedBalance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
