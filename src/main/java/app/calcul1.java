package app;

import java.io.InputStream;
import java.util.Scanner;

public class calcul1 {
    public static void main(String[] args) {
        System.out.println("Input first number: ");
        InputStream in = System.in;
        Scanner scanner = new Scanner(in);
        String num1 = scanner.nextLine();
        int a = Integer.parseInt(num1);
        System.out.println("Input second number: ");
        String num2 = scanner.nextLine();
        int b = Integer.parseInt(num2);
        System.out.println("Input operation: ");
        String op = scanner.nextLine();
        System.out.println("Result: ");
        switch (op) {
            case "+":
                System.out.println(a + b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a / b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            default:
                System.out.println("Wrong operation");
        }
    }}

