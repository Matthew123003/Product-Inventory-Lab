package Services;

import Models.Sneaker;
import Utils.CSVUtils;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import jdk.internal.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {
    private static int nextId = 1;

    private static List<Sneaker> inventory = new ArrayList<>();


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

    public static void loadData(){
        // (1)
        String csvFile = "/Users/matthew/Projects/Product-Inventory-Lab/src/main/SneakerList.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                String sport = beer[3];
                int qty = Integer.parseInt(beer[4]);
                double price = Double.parseDouble(beer[5]);

                // (5)
                inventory.add(new Sneaker(id, name, brand, sport, 12, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadJSONData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Sneaker.class);
        inventory = objectMapper.readValue(new File("sneaker.json"), type);//different than readme because of missing sneaker type
                                                                                              //ReadMe had this.inventory which was a new instance of inventory
                                                                                              //Instead just created new list of Sneakers
    }

    public void writeJSONData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("sneaker.json"), inventory);
    }
}
