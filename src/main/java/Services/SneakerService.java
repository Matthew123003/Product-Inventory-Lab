package Services;

import Models.Sneaker;

import java.util.ArrayList;
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
        return inventory.get(id);
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
}
