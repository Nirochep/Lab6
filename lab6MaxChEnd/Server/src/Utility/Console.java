package Utility;

import java.util.Scanner;

/**
 * The type Console.
 */
public class Console {
    /**
     * The In.
     */
    static Scanner in = new Scanner(System.in);

    /**
     * Read string.
     *
     * @return the string
     */
    public static String read(){
        System.out.print("~ ");
        return in.nextLine();
    }

}