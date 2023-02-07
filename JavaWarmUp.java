package assn02;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
public class JavaWarmUp {
    public static void main(String[] args) {
        // Basic setup
        ArrayList<Item> items = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int number_of_items = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < number_of_items; i++) {
            String item = scan.nextLine();
            Item newItem = new Item(item);
            items.add(newItem);
        }

        //Highest per unit assembling fee
        System.out.println("Highest per unit assembling fee:");
        Item mostFee = getHighAssemblingFee(items);
        System.out.println("\tWhen: " + mostFee.getDate() + " " + mostFee.getAssemblyTime());
        System.out.println("\tCategory: " + mostFee.getCategory());
        System.out.println("\tPrice: " + mostFee.getFee());

        //Lowest per unit assembling fee:
        System.out.println("Lowest per unit assembling fee:");
        Item leastFee = getLeastAssemblingFee(items);
        System.out.println("\tWhen: " + leastFee.getDate() + " " + leastFee.getAssemblyTime());
        System.out.println("\tCategory: " + leastFee.getCategory());
        System.out.println("\tPrice: " + leastFee.getFee());

        //Phone statistics
        System.out.println("Statistic of phone");
        ArrayList<Item> phones = getPhones(items);
        System.out.println("\tQuantity: " + getTotalQuantity(phones));
        System.out.printf("\tAverage Assembling fee: %.2f", + getAvgAssemblingFee(phones));
        System.out.println();
        System.out.printf("\tAverage Net Profit: %.2f", + getAvgNetProfit(phones));
        System.out.println();

        //Laptop statistics
        System.out.println("Statistic of laptop");
        ArrayList<Item> laptops = getLaptops(items);
        System.out.println("\tQuantity: " + getTotalQuantity(laptops));
        System.out.printf("\tAverage Assembling fee: %.2f", + getAvgAssemblingFee(laptops));
        System.out.println();
        System.out.printf("\tAverage Net Profit: %.2f", + getAvgNetProfit(laptops));
        System.out.println();

        //Smart_watch statistics
        System.out.println("Statistic of smart_watch");
        ArrayList<Item> smart_watch = getSmart_Watch(items);
        System.out.println("\tQuantity: " + getTotalQuantity(smart_watch));
        System.out.printf("\tAverage Assembling fee: %.2f", + getAvgAssemblingFee(smart_watch));
        System.out.println();
        System.out.printf("\tAverage Net Profit: %.2f", + (getAvgNetProfit(smart_watch)));
    }



    public static Item getHighAssemblingFee(ArrayList<Item> items) {
        double i = 0;
        Item chosen = new Item();
        for(Item anItem: items) {
            if(anItem.getFee() > i) {
                i = anItem.getFee();
                chosen = anItem;
            }
        }
        return chosen;
    }

    public static Item getLeastAssemblingFee(ArrayList<Item> items) {
        double i = items.get(0).getFee();
        Item choose = new Item();
        for(Item anItem: items) {
            if(anItem.getFee() <= i) {
                i = anItem.getFee();
                choose = anItem;
            }
        }
        return choose;
    }

    public static ArrayList<Item> getPhones(ArrayList<Item> items) {
        ArrayList<Item> phones = new ArrayList<>();
        for(Item item: items) {
            String category = item.getCategory();
            if(category.equals("phone")) {
                phones.add(item);
            }
        }
        return phones;
    }

    public static ArrayList<Item> getLaptops(ArrayList<Item> items) {
        ArrayList<Item> laptops = new ArrayList<>();
        for(Item item: items) {
            String category = item.getCategory();
            if(category.equals("laptop")) {
                laptops.add(item);
            }
        }
        return laptops;
    }

    public static ArrayList<Item> getSmart_Watch(ArrayList<Item> items) {
        ArrayList<Item> smart_watches = new ArrayList<>();
        for(Item item: items) {
            String category = item.getCategory();
            if(category.equals("smart_watch")) {
                smart_watches.add(item);
            }
        }
        return smart_watches;
    }

    public static int getTotalQuantity(ArrayList<Item> items) {
        int totalQuantity = 0;
        for(Item item: items) {
            int aQuantity = item.getQuantity();
            totalQuantity += aQuantity;
        }
        return totalQuantity;
    }

    public static double getAvgAssemblingFee(ArrayList<Item> items) {
        double totalAssemblingFee = 0;
        double totalQuantity = 0;
        for(Item item: items) {
            double itemFee = item.getFee();
            double quantity = item.getQuantity();
            double totalFee = quantity * itemFee;
            totalAssemblingFee += totalFee;
        }
        for(Item item: items) {
            double aQuantity = item.getQuantity();
            totalQuantity += aQuantity;
        }
        double finalValue = (totalAssemblingFee/totalQuantity);
        return finalValue;
    }

    public static double getAvgNetProfit(ArrayList<Item> items) {
        double avgAssemblingFee = getAvgAssemblingFee(items);
        double totalQuantity = getTotalQuantity(items);
        double netIncome = avgAssemblingFee * totalQuantity;
        double totalCosts = 0;
        for(Item item: items) {
            double itemCost = (item.getTotalTime() * 16.0);
            itemCost += item.getCost();
            totalCosts += itemCost;
        }
        double avgNetProfit = (netIncome - totalCosts)/totalQuantity;
        double finalValue = (avgNetProfit);
        return finalValue;
    }


}
