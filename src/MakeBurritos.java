import java.util.ArrayList;
import java.util.Random;

public class MakeBurritos {

    public static final int ingredientsPerBurrito = 7;  // Change this value to adjust ingredients per burrito
    public static final int numberOfBurrito = 25;
    public static final int maxNumberOfIngredients = 9;

    public static void main(String[]args){

        for (int i=0; i<numberOfBurrito; i++){       // 25 burritos
            String ingredients = "";            // Reset String ingredients
            Random rnd = new Random();
            ArrayList<Integer> randomPicks = new ArrayList<>();
            randomPicks = chooseRandomNoDuplicate(maxNumberOfIngredients, rnd);


            for (int j=0; j<ingredientsPerBurrito; j++){    // 5 ingredients
                // generate random #
                int randomNum = randomPicks.get(j); // Ensures that no random number is chosen twice per burrito

                if (j<ingredientsPerBurrito-1){
                    ingredients += whichIngredient(randomNum) + ", ";
                } else {
                    ingredients += " and " + whichIngredient(randomNum) + ".";
                }

            }
            System.out.println("Burrito #" + (i+1) + ": " + ingredients);

        }
        calculatePrice();
    }

    /*Display a price for each burrito. Pricing will be $3.00 plus .50 for each ingredient.*/
    public static void calculatePrice(){
        double basePrice = 3.00;
        double pricePerIngredient = 0.50;
        double pricePerBurrito = basePrice + pricePerIngredient * ingredientsPerBurrito;
        double totalOrderPrice = pricePerBurrito * numberOfBurrito;
        System.out.println();
        System.out.printf("The price per burrito is $ %.2f%n", pricePerBurrito);
        System.out.printf("The total price for your entire order is $ %.2f%n", totalOrderPrice);
    }

    public static ArrayList<Integer> chooseRandomNoDuplicate(int limit, Random rnd){
        ArrayList<Integer> randomPicks = new ArrayList<>();

        while (randomPicks.size()<ingredientsPerBurrito){
            int n = rnd.nextInt(limit);
            if (!randomPicks.contains(n)){
                randomPicks.add(n);
            }
        }
        return randomPicks;
    }

    public static int chooseRandom(int a){
        Random rnd = new Random();
        int n = rnd.nextInt(a);
        return n;
    }

    // Select the type of ingredients you want in burrito
    public static String whichIngredient(int randomNum){
        String ingredient = "";
        switch (randomNum){
            case 0:
                ingredient = chooseIngredient(0);
                break;
            case 1:
                ingredient = chooseIngredient(1);
                break;
            case 2:
                ingredient = chooseIngredient(2);
                break;
            case 3:
                ingredient = chooseIngredient(3);
                break;
            case 4:
                ingredient = chooseIngredient(4);
                break;
            case 5:
                ingredient = chooseIngredient(5);
                break;
            case 6:
                ingredient = chooseIngredient(6);
                break;
            case 7:
                ingredient = chooseIngredient(7);
                break;
            case 8:
                ingredient = chooseIngredient(8);
            default:
                break;
        }
        return ingredient;
    }

    // Select the option you want in each ingredient category
    public static String chooseIngredient(int ingredientNum){
        String Rice = "white, brown, no"; // + "rice"
        String Meat = "chicken, steak, carnidas, chorizo, sofritas, veggies";
        String Beans = "pinto, black, no"; // + "beans"
        String Salsa = "mild, medium, hot, no, all"; // + "salsa"
        String Veggies = "lettuce, fajita, no, all"; // + "veggies" unless it's lettuce
        String Cheese = "cheese, no cheese";
        String Guac = "guac, no guac";
        String Queso = "queso, no queso";
        String SourCream = "sour cream, no sour cream";

        String[] rice = Rice.split(", ");
        String[] meat = Meat.split(", ");
        String[] beans = Beans.split(", ");
        String[] salsa = Salsa.split(", ");
        String[] veggies = Veggies.split(", ");
        String[] cheese = Cheese.split(", ");
        String[] guac = Guac.split(", ");
        String[] queso = Queso.split(", ");
        String[] sourCream = SourCream.split(", ");

        String result = "";

        switch (ingredientNum){
            case 0:
                result = rice[chooseRandom(rice.length)] + " rice";
                break;
            case 1:
                result = meat[chooseRandom(meat.length)];
                break;
            case 2:
                result = beans[chooseRandom(beans.length)] + " beans";
                break;
            case 3:
                // String Salsa = "mild, medium, hot, no, all"; // + "salsa"
                result = includeAllOption(salsa, "salsa");
                break;
            case 4:
                // String Veggies = "lettuce, fajita, no, all"; //
                result = includeAllOption(veggies, "veggies");
                break;
            case 5:
                result = cheese[chooseRandom(cheese.length)];
                break;
            case 6:
                result = guac[chooseRandom(guac.length)];
                break;
            case 7:
                result = queso[chooseRandom(queso.length)];
                break;
            case 8:
                result = sourCream[chooseRandom(sourCream.length)];
                break;
            default:
                break;
        }
        return result;

    }


    public static String includeAllOption(String[] arr, String arrName){
        int n = chooseRandom(arr.length);
        String result = "";
        if (arr[n].equalsIgnoreCase("all")){    // all option
            for (int i=0; i<n-2; i++){
                if (i==n-3){
                    result += arr[i];
                } else {
                    result += arr[i] + " and ";
                }
            }
            result += " " + arrName;
        } else {
            result = arr[n] + " " +arrName;
        }
        return result;
    }

}
