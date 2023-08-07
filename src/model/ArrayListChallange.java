package model;

import java.util.*;

public class ArrayListChallange {


    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    private static void addItems(List<String> groceryList) {
        System.out.println("Eklenecek ogeleri girin:");
        String inputToAdd = getInput();

        if (inputToAdd.contains(",")){
            String[] elements = inputToAdd.split(",");
            for (String item : elements) {
                item = item.trim();
                if (!item.isEmpty() && isItemsInList(groceryList, item)) {
                    groceryList.add(item);
                }
            }
        } else {
            groceryList.add(inputToAdd);
        }
        printSorted(groceryList);
    }
    private static void removeItem(List<String> groceryList) {
        System.out.println("Cikarilacak ogeleri girin:");
        String inputToRemove = getInput();

        if (inputToRemove.contains(",")){
            String[] elements = inputToRemove.split(",");
            for (String item : elements) {
                item = item.trim();
                if (!item.isEmpty() && isItemsInList(groceryList, item)) {
                    groceryList.remove(item);
                }
            }
        } else {
            groceryList.remove(inputToRemove);
        }
        printSorted(groceryList);
    }

    private static boolean isItemsInList(List<String> arrayList, String item) {
        return !arrayList.contains(item);
    }

    private static void printSorted(List<String> list) {
        Collections.sort(list);
        System.out.println(list);
    }


    public static void askGroceries(List<String> groceryList) {

        while (true){
            try {

                System.out.println("Commands:");
                System.out.println("0: Exit Application");
                System.out.println("1: Add to List");
                System.out.println("2: Remove from List");
                Scanner sc = new Scanner(System.in);
                int process = sc.nextInt();

                if (process < 0 || process > 2) {
                    System.out.println("Command must be between 0 to 2");
                }

                if (process == 0) System.exit(0);
                if (process == 1) addItems(groceryList);
                if (process == 2) removeItem(groceryList);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
