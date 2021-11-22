/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.awt.HeadlessException;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

/**
 *
 * @author matta
 */
public class DesktopApp extends JPanel implements ActionListener {
    
    /*static String appName = CommonUtility.getAppName();
    
    public DesktopApp() throws HeadlessException {
        super(appName);
        init();
        
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopApp().setVisible(true);
                
            }
        });
    }*/
    
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
    
    CashRegister cashRegister = new CashRegister();
 
    public DesktopApp() {
        super(new GridBagLayout());
        
        new Display(cashRegister);
        new TicketPrinter(cashRegister);
 
        textField = new JTextField(20);
        textField.addActionListener(this);
 
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }
    
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        
        
        cashRegister.setState(Integer.parseInt(text));
        
        textArea.append(text + newline);
        textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("DesktopApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new DesktopApp());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /*private void init() {
        setLayout (new FlowLayout(FlowLayout.LEFT));
        
        add(new JLabel("Welcome to " + appName));
        
        JPanel UPC1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        UPC1.add(new JLabel("UPCCode: 4321"));
        
        JPanel UPC2 = new JPanel(new FlowLayout());
        UPC2.add(new JLabel("UPCCode: 9876"));
        
        JPanel Border = new JPanel(new BorderLayout());
        Border.add(UPC1, BorderLayout.NORTH);
        Border.add(UPC2, BorderLayout.SOUTH);
        
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.add(Border);
        
        getContentPane().add(container);
        setSize(640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
    }*/
}

