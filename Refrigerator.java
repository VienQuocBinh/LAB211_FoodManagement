package GUI;

import DTO.Food;
import MyService.Validation;
import Storage.FoodList;
import java.util.ArrayList;
import java.util.Scanner;

public class Refrigerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodList listOfFoods = new FoodList();
        int choice = 0;
        String filename = "foodList.dat";
        ArrayList<Food> foodFile = new ArrayList<>();

        boolean flag;
        do {
            System.out.println("Welcome to Food Management - @ 2021 by <SE161554 - Vien Quoc Binh>");
            System.out.println("Select a options below: ");
            System.out.println("0. Read file");
            System.out.println("1. Add a new food");
            System.out.println("2. Search a food by weight");
            System.out.println("3. Remove the food by ID");
            System.out.println("4. Print the food in the descending order of expired date");
            System.out.println("5. Quit");
            System.out.println("6. Export");
            do {
                try {
                    System.out.println("Enter your choice: ");
                    sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    if (choice < 0 || choice >= 7) {
                        throw new Exception();
                    }
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Please enter the valid number");
                    flag = true;
                }

            } while (flag);

            switch (choice) {
                case 0:
                    try {
                        // truong hop load 2 file khac nhau khong bi trung
                        listOfFoods.clear();
                        ArrayList<Food> kq = FoodList.readBinaryFile(filename);
                        for (int i = 0; i < kq.size(); i++) {
                            listOfFoods.addFood(kq.get(i));
                            System.out.println(kq.get(i));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 1:
                    String con = "n";
                    do {
                        Food f = new Food();
                        int id = listOfFoods.checkFoodId();
                        if (id > 0) {
                            f.setId(id);
                            f.inputFood();
                            if (listOfFoods.addFood(f)) {
                                System.out.println("Added success");
                                System.out.println("Do you want to continue adding (y/n)");
                                sc = new Scanner(System.in);
                                con = sc.nextLine();
                            }
                        } else {
                            System.out.println("The food already has in the list");
                            System.out.println("Do you want to continue adding (y/n)");
                            sc = new Scanner(System.in);
                            con = sc.nextLine();
                        }
                    } while (con.equalsIgnoreCase("y"));
                    break;
                case 2:
                    do {
//                        System.out.println("Enter the keyword: ");
                        System.out.println("Enter the weigth: ");
                        sc = new Scanner(System.in);
//                        String keyword = sc.nextLine();
                        int search = sc.nextInt();
                        ArrayList<Food> result = listOfFoods.searchFoodByWeigth(search);
                        if (result.isEmpty()) {
                            System.out.println("This food does not exist");
                            System.out.println("Do you want to continue searching (y/n)");
                            sc = new Scanner(System.in);
                            con = sc.nextLine();
                        } else {
                            listOfFoods.print(result);
                            System.out.println("Do you want to continue searching (y/n)");
                            sc = new Scanner(System.in);
                            con = sc.nextLine();
                        }
                    } while (con.equalsIgnoreCase("y"));

                    break;

                case 3:
                    do {
                        try {
                            System.out.println("Enter the ID to remove");
                            sc = new Scanner(System.in);
                            int id = sc.nextInt();
                            if (Validation.confirmMessage() && listOfFoods.removeFoodById(id)) {
                                System.out.println("Remove success");
                            } else {
                                System.out.println("Remove fail");
                            }
                            flag = false;
                        } catch (Exception e) {
                            System.out.println("Id is invalid");
                            System.out.println("Do you want to continue: (y/n)");
                            sc = new Scanner(System.in);
                            String ask = sc.nextLine();
                            flag = ask.equalsIgnoreCase("y");
                        }
                    } while (flag);

                    break;
                case 4:
                    listOfFoods.print();
                    break;
                case 5:
                    System.out.println("Thank you. Good bye.");
                    break;
                case 6:

                    for (int i = 0; i < listOfFoods.size(); i++) {
                        foodFile.add(listOfFoods.get(i));
                    }
                    try {
                        FoodList.writeBinaryFile(filename, foodFile);
                        ArrayList<Food> kq = FoodList.readBinaryFile(filename);
                        for (int i = 0; i < kq.size(); i++) {
                            System.out.println(kq.get(i));
                        }
                        System.out.println("success");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        } while (choice != 5);
    }
}
