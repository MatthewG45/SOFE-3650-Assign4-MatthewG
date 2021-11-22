/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author matta
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ProductDB {
    Product product = null;

    //gets product information with code


    //read from file
    public Product GetProductInfo(int UPCCode){
        try {

            //youll have to rename the path, usually "src//ProductDatabase.txt" works, but not for me sometimes
            File productDatabase = new File("C://Users//matta//OneDrive//Documents//NetBeansProjects//MyCompanyProject//SharedLibrary//src//main//java//com//mycompany//ProductDatabase.txt");
            Scanner myReader = new Scanner(productDatabase);


            //reads next line and splits the values at the comma
            while (myReader.hasNextLine()){
                String[] product = myReader.nextLine().split(",");
                int UPC = Integer.parseInt(product[0]);
                String name = product[1];
                double price = Double.parseDouble(product[2]);

                //check if the grabbed code is equal to code passed through, verification
                if (UPCCode == UPC) {
                    this.product = new Product(UPC,name,price);
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) { //handling errors
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
        return product;
    }
}
