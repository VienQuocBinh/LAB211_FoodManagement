
package DTO;

import MyService.Validation;
import java.io.Serializable;
import java.util.Scanner;

public class Food implements Serializable, iFood {

    private int id;
    private String name;
    private int weight;
    private String type;
    private String place;
    private String expiredDate;

    public Food() {
        id = 0;
        name = "";
        weight = 0;
        type = "";
        place = "";
        expiredDate = "";
    }

    public Food(int id, String name, int weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public void inputFood() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter the food name: ");
                sc = new Scanner(System.in);
                name = sc.nextLine();
                if (Validation.isCharOnlyString(name) == false) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Food name is invalid");
                flag = true;
            }
        } while (flag);
        do {
            try {
                System.out.println("Enter the food weight: ");
                sc = new Scanner(System.in);
                weight = sc.nextInt();
                if (weight <= 0) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Food weight is invalid");
                flag = true;
            }
        } while (flag);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the food type: ");
                type = sc.nextLine();
                if (Validation.isCharOnlyString(type) == false) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Food type is invalid");
                flag = true;
            }
        } while (flag);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the food place: ");
                place = sc.nextLine();
                if (Validation.isCharOnlyString(place) == false) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("The place is invalid");
                flag = true;
            }
        } while (flag);
        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter the expired date (dd-MM-yyyy): ");
                expiredDate = sc.nextLine();
                if (!Validation.isDateValid(expiredDate)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Please enter in right format and valid date");
                flag = true;
            }
        } while (flag);
    }

    @Override
    public void outputFood() {
        System.out.println("***Food Information***");
        System.out.println("Food ID: " + id);
        System.out.println("Food name: " + name);
        System.out.println("Weight: " + weight);
        System.out.println("Type: " + type);
        System.out.println("Place in refrigerator: " + place);
        System.out.println("Expired date: " + expiredDate);
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", type=" + type + ", place=" + place + ", expiredDate=" + expiredDate + '}';
    }

}
