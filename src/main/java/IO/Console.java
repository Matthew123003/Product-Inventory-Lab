
package IO;

import java.util.Scanner;

import static java.lang.System.in;

public class Console {

    public Scanner scanner = new Scanner(in);

    public static void printWelcome(){
        System.out.println("" +
                "**************************************************" +
                "***           Welcome and Bienvenue            ***" +
                "***                    to                      ***" +
                "***          ZipCo Inventory Manager           ***" +
                "**************************************************");
    }
}
