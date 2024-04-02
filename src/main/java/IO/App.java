package IO;

import Services.SneakerService;

import java.util.Scanner;

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
        }
    }
}
