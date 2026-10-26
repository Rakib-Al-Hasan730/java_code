//2. Write a JAVA Program for generating Restaurant Bill

import java.util.Scanner;

public class RestaurantBill {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Food prices
        double burgerPrice = 150;
        double pizzaPrice = 300;
        double coffeePrice = 100;

        // Take quantity from user
        System.out.print("Enter quantity of Burger: ");
        int burgerQty = input.nextInt();

        System.out.print("Enter quantity of Pizza: ");
        int pizzaQty = input.nextInt();

        System.out.print("Enter quantity of Coffee: ");
        int coffeeQty = input.nextInt();

        // Calculate cost
        double burgerTotal = burgerPrice * burgerQty;
        double pizzaTotal = pizzaPrice * pizzaQty;
        double coffeeTotal = coffeePrice * coffeeQty;

        double totalBill = burgerTotal + pizzaTotal + coffeeTotal;

        // Display bill
        System.out.println("\n----- RESTAURANT BILL -----");
        System.out.println("Burger  : " + burgerQty + " x " + burgerPrice
                + " = " + burgerTotal);
        System.out.println("Pizza   : " + pizzaQty + " x " + pizzaPrice
                + " = " + pizzaTotal);
        System.out.println("Coffee  : " + coffeeQty + " x " + coffeePrice
                + " = " + coffeeTotal);

        System.out.println("---------------------------");
        System.out.println("Total Bill = " + totalBill);

        input.close();
    }
}
