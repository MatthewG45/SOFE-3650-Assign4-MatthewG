/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author matta
 */
public class Keyboard {
    private CashRegister cashRegister = new CashRegister();
    public void setUPCCode(int UPCCode){
        this.cashRegister.setCurrentProductUPC(UPCCode);
    }
}

