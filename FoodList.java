
package Storage;

import DTO.Food;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FoodList{

    ArrayList<Food> listOfFoods;

    public FoodList() {
        listOfFoods = new ArrayList<>();
    }

   
    public boolean addFood(Food f) {
       
        for (int i = 0; i < listOfFoods.size(); i++) {
            if (listOfFoods.get(i).getId() == f.getId()) {
                return false;
            }
        }
        listOfFoods.add(f);
        return true;
    }

    public int checkFoodId() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int id = -1;
        do {
            try {
                System.out.println("Enter food Id: ");
                sc = new Scanner(System.in);
                id = sc.nextInt();
                if (id <= 0) {
                    throw new Exception();
                }
                flag = false;

            } catch (Exception e) {
                System.out.println("ID is invalid");
                flag = true;
            }
        } while (flag);
        for (int i = 0; i < listOfFoods.size(); i++) {
            if (listOfFoods.get(i).getId() == id) {
                return -1;
            }
        }
        return id;
    }

    
    public boolean removeFoodById(int id) {
        for (int i = 0; i < listOfFoods.size(); i++) {
            if (listOfFoods.get(i).getId() == id) {
                listOfFoods.remove(listOfFoods.get(i));
                return true;
            }
        }
        return false;
    }
    
    public void clear(){
        for (int i = 0; i < listOfFoods.size(); i++) {
            listOfFoods.remove(listOfFoods.get(i));
        }
    }

    
    public ArrayList<Food> searchFoodByName(String keyword) {
        ArrayList<Food> result = new ArrayList<>();
        for (int i = 0; i < listOfFoods.size(); i++) {
            if (listOfFoods.get(i).getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(listOfFoods.get(i));
            }
        }
        return result;
    }
    public ArrayList<Food> searchFoodByWeigth(int weight) {
        ArrayList<Food> result = new ArrayList<>();
        for (int i = 0; i < listOfFoods.size(); i++) {
            if (listOfFoods.get(i).getWeight() >= weight) {
                result.add(listOfFoods.get(i));
            }
        }
        return result;
    }

    public void sortByExpriredDate(ArrayList<Food> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (list != null) {
            // sort 2 tham so de k phai implement Comparable trong class Food
            Collections.sort(listOfFoods, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    try {
                        return sdf.parse(o1.getExpiredDate()).compareTo(sdf.parse(o2.getExpiredDate()));
                    } catch (ParseException e) {
                        return 0;
                    }
                }
            });
        }
    }


   
    public void print() {
        sortByExpriredDate(listOfFoods);
        if (listOfFoods.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (int i = 0; i < listOfFoods.size(); i++) {
                listOfFoods.get(i).outputFood();
            }
        }

    }

   
    public void print(ArrayList<Food> list) {
        sortByExpriredDate(listOfFoods);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).outputFood();
        }
    }

    public int size() {
        return listOfFoods.size();
    }

    public Food get(int i) {
        return listOfFoods.get(i);
    }

    public static void writeBinaryFile(String fileName, ArrayList<Food> data) throws Exception {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data);
        fos.close();
        oos.close();
    }

    public static ArrayList<Food> readBinaryFile(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Food> list = (ArrayList<Food>) ois.readObject();
        fis.close();
        ois.close();
        return list;
    }
    
    
}
