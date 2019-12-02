package Lab_1;

import java.util.Scanner;

public class Quadratic_Equation {

//    private double a;
//    private double b;
//    private double c;

//    public void enterValue () {
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Enter а: ");
//        a = in.nextDouble();
//        System.out.println("Enter b: ");
//        b = in.nextDouble();
//        System.out.println("Enter c: ");
//        c = in.nextDouble();
//    }

    public String solution (double a, double b, double c) {
        double Disc;
        double x1;
        double x2;
        String result;
        if (a == 0) {
            x1 = (-1) * c / b;
            result = "You have the linear equation: x = " + x1;
        } else {
            Disc = Math.pow(b, 2) - (4 * a * c);
            if (Disc > 0) {
                x1 = ((-1) * b + Math.sqrt(Disc)) / 2 * a;
                x2 = ((-1) * b - Math.sqrt(Disc)) / 2 * a;
                result = "x1 = " + x1 + " x2 = " + x2;
            } else if (Disc == 0) {
                x1 = ((-1) * b) / (2 * a);
                result = "x1, x2 = " + x1;
            } else result = "Error. Discriminant < 0";
        }
        return result;
    }
}