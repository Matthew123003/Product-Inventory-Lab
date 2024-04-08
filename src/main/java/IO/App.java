package IO;

import Models.Sneaker;
import Services.SneakerService;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class App {
    Scanner scanner = new Scanner(in);

    private SneakerService ss = new SneakerService();

    public static void main(String... args) throws IOException {
        App application = new App();
        application.init();
    }

    public void init() throws IOException {
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
        SneakerService.loadData();
        System.out.println("What would you like to do?");
        System.out.println("1. Create new sneaker");
        System.out.println("2. See existing inventory");
        System.out.println("3. Update inventory");
        System.out.println("4. Delete inventory");
        System.out.println("5. Get Product Reports");
        System.out.println("6. Exit Program\n");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                System.out.println("Name your sneaker");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Name your brand");
                String brand = scanner.nextLine();
                System.out.println("Name your sport");
                String sport = scanner.nextLine();
                System.out.println("Choose your size");
                int size = scanner.nextInt();
                System.out.println("Choose qty to make");
                int qty = scanner.nextInt();
                System.out.println("Choose a price point");
                double price = scanner.nextDouble();
                SneakerService.create(name, brand, sport, size, qty, price);
                SneakerService.writeToCSV();
                break;
            case 2:
                Sneaker[] inventory = SneakerService.findAll();
                for (Sneaker sneaker : inventory) {
                    System.out.println("Name: " + sneaker.getName());
                    System.out.println("Brand: " + sneaker.getBrand());
                    System.out.println("Sport: " + sneaker.getSport());
                    System.out.println("Size: " + sneaker.getSize());
                    System.out.println("Quantity: " + sneaker.getQty());
                    System.out.println("Price: " + sneaker.getPrice());
                    System.out.println();
                }
                break;
            case 3:
                SneakerService.findAll();
                break;
            case 4:
                System.out.println("Choose an ID to delete, check existing inventory first");
                int id = scanner.nextInt();
                SneakerService.delete(id);
                break;
            case 5:
                System.out.println("Product report");
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
}
