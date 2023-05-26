package org.example;

import org.example.Services.CashierServices;
import org.example.Services.CustomerServiceImp;
import org.example.Services.ManagerServiceImp;
import org.example.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.loadProductsFromFile("products.csv");
        //store.displayProducts();


        Manager manager = new Manager("Wajiu", "ID344", "09039156872", "ETP", "Manager");



        Cashier cashier1 = new Cashier("Bello", "eehgg","ETP","ETP","Cashier",5);
        Cashier cashier2 = new Cashier("omolola", "eehgg","ETP","ETP","Cashier",2);
        Cashier cashier3 = new Cashier("Wale","ht687","ETP","Lagos","Cashier",3);
        Cashier cashier4 = new Cashier("Eben","ht687","ETP","Abuja","cashier",4);

        ManagerServiceImp managerServiceImp = new ManagerServiceImp();
        managerServiceImp.hireCashier(cashier1,manager);
        managerServiceImp.hireCashier(cashier2,manager);
        managerServiceImp.hireCashier(cashier3,manager);
        managerServiceImp.hireCashier(cashier4,manager);



// Customer buy product base on their wallet if it's sufficient with total price of product in their cart
        Customer customer = new Customer("Omolola", "ID443", "855748734",10000000);
        Product product1 = store.products.get(2);
        Product product2 = store.products.get(1);



        Customer customer11 = new Customer("Ebenezer","455TT","090567463332",155000);
        Product product3 = store.products.get(5);
        Product product4 = store.products.get(1);

        CustomerServiceImp customerServiceImp = new CustomerServiceImp();
        customerServiceImp.addToCart(product1, customer);
        customerServiceImp.addToCart(product2, customer);
        customerServiceImp.addToCart(product3,customer11);
        customerServiceImp.addToCart(product4,customer11);


        // Creating object for receipt generating for each customer
        CashierServices cashierServices = new CashierServices();
        cashierServices.generateReceipt(customer, (ArrayList<Product>) customer.getCart());
        cashierServices.generateReceipt(customer11,(ArrayList<Product>) customer11.getCart());



    }
}