package Services;

import Models.Sneaker;
import Utils.CSVUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {
    private static int nextId = 1;

    private static ArrayList<Sneaker> inventory = new ArrayList<>();


    public static Sneaker create(String name, String brand, String sport, int size, int quantity, double price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId, name, brand, sport, size, quantity, price);
        nextId++;
        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        if (inventory.contains(id)) {
            return inventory.get(id);
        } else {
            System.out.println("ID does not exist");
            return null;
        }
    }

    //read all
    public static Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
        return inventory.toArray(new Sneaker[0]);
    }

    //delete
    public static boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        for(Sneaker sneaks : inventory){
            if(sneaks.getId() == id){
                inventory.remove(id);
                return true;
            }
        }

        return false;
    }

    public static void writeToCSV() throws IOException {
        String csvFile = "/Users/matthew/Projects/Product-Inventory-Lab/src/main/SneakerList.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Sneaker s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(s.getSport());
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

        // (5)
        writer.flush();
        writer.close();
    }
}
