package java;
import java.util.Scanner;
/**
 * Created by Aser on 16.05.2016.
 */
public class Menu {

    public static void allMenu(){

        while (true) {
            System.out.println("1. Your first wish");
            System.out.println("2. Your second wish");
            System.out.println("3. Your third wish");
            System.out.println("0. cancel");
            System.out.print("Input number of wish:");

            String b = inputString();

            if ("1".equals(b)) {
                function1();
            }
            else if ("2".equals(b)) {
                function2();
            }
            else if ("3".equals(b)) {
                function3();
            }
            else if ("0".equals(b)) {
                break;
            }
            else {
                System.out.println("not found this number of wish");
            }
        }
    }

    public static void function1() {
        System.out.println("You have choose first wish");
        exit();
    }

    public static void function2() {
        System.out.println("You have choose second wish");
        exit();
    }

    public static void function3() {
        System.out.println("You have choose third wish");
        exit();
    }

    public static String inputString() {
        Scanner vv = new Scanner(System.in);
        return vv.next();
    }

    public static void exit(){
        System.out.println("0. return");
        String b = inputString();
        if ("0".equals(b)) {
            allMenu();
        }
    }
}

