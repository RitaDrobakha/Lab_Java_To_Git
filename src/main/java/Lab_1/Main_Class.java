package Lab_1;

import java.util.Scanner;

public class Main_Class {

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            Quadratic_Equation equation = new Quadratic_Equation();
            //equation.enterValue();
            System.out.println("Enter а: ");
            double a = in.nextDouble();
            System.out.println("Enter b: ");
            double b = in.nextDouble();
            System.out.println("Enter c: ");
            double c = in.nextDouble();
            System.out.println(equation.solution(a, b, c));
            System.out.println("\nIf you want to continue - enter 1: ");
            if (in.nextInt() != 1) {
                break;
            }
        }
    }
}
