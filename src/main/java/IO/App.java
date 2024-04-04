package IO;

import Services.SneakerService;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class App {
    Scanner scanner = new Scanner(in);

    private SneakerService ss = new SneakerService();

    public static void main(String... args) {
        App application = new App();
        application.init();
    }

    public void init(){
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
        System.out.println("What would you like to do?");
        System.out.println("1. Create new sneaker");
        System.out.println("2. See existing inventory");
        System.out.println("3. Update inventory");
        System.out.println("4. Delete inventory");
        System.out.println("5. Get Product Reports");
        System.out.println("6. Exit Program");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                SneakerService ss = new SneakerService();
                System.out.println("Name your sneaker");
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
                ss.create(name, brand, sport, size, qty, price);
            case 2:
                SneakerService.findAll();
            case 3:
                SneakerService.findAll();
            case 4:
                System.out.println("Choose an ID to delete, check existing inventory first");
                int id = scanner.nextInt();
                SneakerService.delete(id);
            case 5:
                System.out.println("Product report");
            case 6:
                System.exit(0);
        }
    }
}
