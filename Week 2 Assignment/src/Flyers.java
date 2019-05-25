import java.text.DecimalFormat;
import java.util.*;

// Class defining delivery as numerics
enum Delivery

{

       DELIVERY,

       DELIVERY_EXTRA

}

public class Flyers {
	 public static int modeMenu()

     {

           int choice;

           Scanner scan = new Scanner(System.in);

           System.out.print("Please Enter 1 for Pick-up or 2 for Delivery\n");

           choice = Integer.parseInt(scan.nextLine());

           while(choice<1 || choice>2)

           {

                  System.out.print("Invalid selection, must be 1(Pick-up) or 2(Delivery\n) : ");

                  choice = Integer.parseInt(scan.nextLine());

           }

           return choice;

     }
	
     // User menu selection

     public static float itemsMenu()

     {

          

           int choice,qty;

           float price = 0;

           Scanner scan = new Scanner(System.in);

           System.out.println(" Menu Items : ");

           System.out.println("1) Flyers' Burger: $4.50");

           System.out.println("2) Flyers' Drink: $1.50");

           System.out.println("3) Flyers' Fries: $2.50");

           System.out.println("4) Flyers' Desert: $3.00");

           System.out.print("Please enter your selection(1-4) : ");

           choice = Integer.parseInt(scan.nextLine());

           while(choice<1 || choice>4)

           {

                  System.out.print("Invalid choice .\nEnter your choice(1-4) : ");

                  choice = Integer.parseInt(scan.nextLine());

           }

          

           System.out.print("Please enter quantity desired: ");

           qty = Integer.parseInt(scan.nextLine());

           switch(choice)

           {

                  case 1: price = (float)(qty * 4.5);

                               break;

                  case 2: price = (float)(qty * 1.5);

                               break;

                  case 3:price = (float)(qty * 2.5);

                               break;

                  case 4:price = (float)(qty * 3);

                               break;

           }

          

           return price;

     }

    

     public static void main(String[] args) {

          

           int deliveryOption;

           int shopZipCode = 60446, userZipCode;

           Delivery type =null;

           String itemsChoice = "y";

           float price = 0;

           Scanner scan = new Scanner(System.in);

           System.out.println("Welcome to Flyers Restaurant ");

          

           deliveryOption = modeMenu();

           // if delivery zipcode input

           if(deliveryOption == 2 )

           {

                  System.out.print("Please enter your zip code : ");

                  userZipCode = Integer.parseInt(scan.nextLine());

                  if(Math.abs(shopZipCode - userZipCode) < 5)

                         {

                               System.out.println("Delivery charge will be $5.00." );

                               type = Delivery.DELIVERY;

                         }

                  else if( userZipCode == 60451 || userZipCode == 60441)

                         {

                               System.out.println("Delivery charge will be $7.00." );

                               type = Delivery.DELIVERY_EXTRA;

                         }

                  else

                         {

                               System.out.println("Sorry delivery not available for your area.");

                               System.exit(0);

                         }                  

           }

          

           //  order loop

           while(itemsChoice.equalsIgnoreCase("y"))

           {

                  price += itemsMenu();

                  System.out.print("Would you like to add to your order(y/n) ? ");

                  itemsChoice = scan.nextLine();

                  if(itemsChoice.equalsIgnoreCase("n"))

                         break;

           }

           // calculate tax

           price += 0.05*price;

           if(deliveryOption == 2 )

           {

                  if(type == Delivery.DELIVERY)

                         price += 5;

                  else if(type == Delivery.DELIVERY_EXTRA)

                         price += 7;

           }

           DecimalFormat df = new DecimalFormat("#.##"); 
           
           		String formattedprice = df.format(price);           
                  

           // print the total rounded to 2 decimals

           System.out.println("Your total comes to $"+formattedprice+".");

          

     }

}



