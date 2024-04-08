
package IO;

import java.util.Scanner;

import static java.lang.System.in;

public class Console {

    public Scanner scanner = new Scanner(in);
    public static void printWelcome(){
        System.out.println("" +
                "**************************************************\n"+
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************");
    }
}
