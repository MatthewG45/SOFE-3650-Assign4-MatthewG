/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author matta
 */
public class TicketPrinter extends Observer{

    private ProductDB productDB = new ProductDB();

    public void displayText(String text) {
        System.out.println("Ticket Printer:");
        System.out.println(text);
    }

    public TicketPrinter(CashRegister cashRegister){
        this.cashRegister = cashRegister;
        this.cashRegister.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Ticket Printer: " + this.productDB.GetProductInfo(cashRegister.getState()));
    }

}
