package com.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {

    public static void main(String[] args) {

      ArrayList<Product> inventory = new ArrayList<>();
      ArrayList<Product> cart = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("Store Home Screen");
            System.out.println("------------------");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showProducts(getInventory(), scanner);
                    break;

                case 2:

                    showCart(cart);

                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<>();
        String storeInventory = "inventory.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(storeInventory));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                String name = parts[1];
                Double price = Double.parseDouble(parts[2]);
                inventory.add(new Product(id, name, price));
            }
            br.close();

        }catch (Exception e ) {

        }
        return inventory;
    }

    public static void showProducts(ArrayList<Product> inventory, Scanner scanner){
        for (Product p : inventory) {
            System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice());
        }
        System.out.println("-----------------");
        String itemID;
        do {
            System.out.println("Please Enter Item ID You Wish To Add To Your Cart (Or Enter X to Exit)");
            itemID = scanner.nextLine();


            if (itemID.equalsIgnoreCase("x")) {
                break;
            }



        } while (true);
    }

    public static void showCart(ArrayList<Product> cart) {
        System.out.println("Your Cart:");
        double totalAmount = 0;
        for (Product p : cart) {
            System.out.println(p.getName() + " - $" + p.getPrice());
            totalAmount += p.getPrice();
        }
        System.out.println("Total Amount: $" + totalAmount);
    }








    }



