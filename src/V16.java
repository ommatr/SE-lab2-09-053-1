import java.util.Scanner;

public class V16{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Значение a:");
        double a = scanner.nextDouble();
        System.out.println("Значение b:");
        double b = scanner.nextDouble();
        System.out.println("Значение c:");
        double c = scanner.nextDouble();
        System.out.println("Значение n:");
        double n = scanner.nextDouble();
        System.out.println("Значение x:");
        double x = scanner.nextDouble();

        double s = (Math.pow(5*a,n*x)/b+c)-(Math.sqrt(Math.abs(Math.cos(Math.pow(x,3)))));

        System.out.println("Ответ :"+ s);

    }

}