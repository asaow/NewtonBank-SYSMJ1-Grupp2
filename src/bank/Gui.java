package bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui implements ItemListener {
    JPanel card; //a panel that uses CardLayout
    final static String SEEKCUSTOMER = "Sök kund";
    final static String NEWCUSTOMER = "Lägg till ny kund";
    final static String SHOWCUSTOMERINFO = "Visa kund info";
    final static String CHANGECUSTOMERNAME = "Ändra kundens namn";
    final static String DELETECUSTOMER = "Ta bort kund";
    final static String SEEKACCOUNT = "Sök konto";
    final static String SEEKTRANSACTION = "Sök transaktion";
    final static String ADDSAVINGSACCOUNT = "Lägg till sparkonto";
    final static String ADDCREDITACCOUNT = "Lägg till kreditkonto";
    final static String DELETEACCOUNT = "Ta bort konto";
    final static String DEPOSIT ="Insättning";
    final static String WITHDRAWL ="Uttag";
    final static String SHOWCUSTOMERLIST = "Visa kundlista";
    final static String EXPORTTOFILE = "Exportera till fil";

    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[]= { SEEKCUSTOMER, NEWCUSTOMER, SHOWCUSTOMERINFO,  CHANGECUSTOMERNAME, DELETECUSTOMER, SEEKACCOUNT,
        		SEEKTRANSACTION, ADDSAVINGSACCOUNT, ADDCREDITACCOUNT, DELETEACCOUNT, DEPOSIT, WITHDRAWL, SHOWCUSTOMERLIST, 
        		EXPORTTOFILE};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);


        JPanel seekCustomer = new JPanel();
        seekCustomer.add(new JTextField("Personnummer", 15));
        seekCustomer.add(new JButton("OK"));
       
        JPanel newCustomer = new JPanel();
        newCustomer.add(new JTextField("Personnummer", 15));
        newCustomer.add(new JTextField("Namn", 15));
        newCustomer.add(new JButton("OK"));
       
        JPanel showCustomerInfo = new JPanel();
        showCustomerInfo.add(new JTextField("Konto ID", 15));
        showCustomerInfo.add(new JButton("OK"));
        
        JPanel changeCustomerName = new JPanel();
        changeCustomerName.add(new JTextField("Konto ID", 15));
        changeCustomerName.add(new JTextField("Ändra namnet", 15));
        changeCustomerName.add(new JButton("Ändra namn"));
        
        JPanel deleteCustomer = new JPanel();
        deleteCustomer.add(new JTextField("Konto ID", 15));
        deleteCustomer.add(new JTextField("Personnummer", 15));
        deleteCustomer.add(new JButton("Ta bort kund"));
        
        JPanel seekAccount = new JPanel();
        seekAccount.add(new JTextField("Konto id",15) );
        seekAccount.add(new JButton("Sök konto"));
        
        JPanel seekTransaction = new JPanel();
        seekTransaction.add(new JTextField("Konto ID", 15));
        seekTransaction.add(new JButton("Sök transaktion"));
        
        JPanel addSavingsAccount = new JPanel();
        addSavingsAccount.add(new JTextField("Konto id", 15));
        addSavingsAccount.add(new JButton("Lägg till sparkonto"));
        
        JPanel addCreditAccount = new JPanel();
        addCreditAccount.add(new JTextField("Konto ID", 15));
        addCreditAccount.add(new JButton("Lägg till Kreditkonto"));
        
        JPanel deleteAccount = new JPanel();
        deleteAccount.add(new JTextField("Konto ID", 15));
        deleteAccount.add(new JButton("Ta bort konto"));
        
        JPanel deposit = new JPanel();
        deposit.add(new JTextField("Konto ID", 15));
        deposit.add(new JTextField("Belopp", 15));
        deposit.add(new JButton("Sätt in pengar"));
        
        JPanel withdrawl = new JPanel();
        withdrawl.add(new JTextField("Konto ID", 15));
        withdrawl.add(new JTextField("Belopp", 15));
        withdrawl.add(new JButton("Ta ut pengar"));
        
        JPanel showCustomerList = new JPanel();
        showCustomerList.add(new JButton("Visa listan över kunder"));
        
        JPanel exportToFile = new JPanel();
        exportToFile.add(new JButton("Exporter till fil"));
        
        
        
        
       
       
        //Create the panel that contains the "cards".
        card = new JPanel(new CardLayout());
        card.add(seekCustomer, SEEKCUSTOMER);
        card.add(newCustomer, NEWCUSTOMER);
        card.add(showCustomerInfo, SHOWCUSTOMERINFO);
        card.add(changeCustomerName, CHANGECUSTOMERNAME);
        card.add(deleteCustomer, DELETECUSTOMER);
        card.add(seekAccount, SEEKACCOUNT);
        card.add(seekTransaction, SEEKTRANSACTION);
        card.add(addSavingsAccount, ADDSAVINGSACCOUNT);
        card.add(addCreditAccount, ADDCREDITACCOUNT);
        card.add(deleteAccount, DELETEACCOUNT);
        card.add(deposit, DEPOSIT);
        card.add(withdrawl, WITHDRAWL);
        card.add(showCustomerList, SHOWCUSTOMERLIST);
        card.add(exportToFile, EXPORTTOFILE);
        
        

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(card, BorderLayout.CENTER);
    }
    
    

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(card.getLayout());
        cl.show(card, (String)evt.getItem());
    }

  
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Bohlin Banking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Gui demo = new Gui();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
