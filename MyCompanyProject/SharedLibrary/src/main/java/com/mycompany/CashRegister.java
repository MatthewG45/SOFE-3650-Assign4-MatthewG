/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author matta
 */
import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    //private Display display = new Display();
    //private TicketPrinter ticketPrinter = new TicketPrinter();

    private Product currentProduct;
    private ProductDB productDB = new ProductDB();
    private int UPCCode;

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;


    //for grabbing state (UPCCode)

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        Scanner scanner = new Scanner();
        scanner.scannedUPCCode(state);
        Keyboard keyboard = new Keyboard();
        keyboard.setUPCCode(state);
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        //Cycles through observers to update
        observers.forEach(observer -> observer.update());
    }

    //set UPC code for current scanned product

    public void setCurrentProductUPC(int UPCCode) {
        this.UPCCode = UPCCode;
        this.currentProduct = this.getCurrentProductInfo();
        //print view if object is defined // this is moot for question 3

        if(this.currentProduct != null){
            //this.display.displayText(this.currentProduct.toString());
            //this.ticketPrinter.displayText(this.currentProduct.toString());
            //notifyAllObservers(this.currentProduct.toString());
        }
    }

    //gets product information for the latest scanned product

    public Product getCurrentProductInfo() {
        currentProduct = this.productDB.GetProductInfo(this.UPCCode);
        return currentProduct;
    }
}
