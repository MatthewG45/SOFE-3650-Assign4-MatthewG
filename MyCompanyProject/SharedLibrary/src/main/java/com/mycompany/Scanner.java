/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author matta
 */
public class Scanner {
    private CashRegister cashRegister = new CashRegister();

    public void scannedUPCCode(int UPCCode) {
        this.cashRegister.setCurrentProductUPC(UPCCode);
    }
}