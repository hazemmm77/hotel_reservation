package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void start(){
        Scanner input = new Scanner(System.in);
        System.out.println("**********************************************************************************");
        System.out.println("1. See All Customers");
        System.out.println("2. See All Rooms ");
        System.out.println("3. See All Reservations");
        System.out.println("4. Add a  Room");
        System.out.println("5. Back to main menu");
        System.out.println("**********************************************************************************");
        System.out.println("Please select a number for a menu option");
        String option = input.nextLine();
        startAction(option);
    }
    public  static void startAction(String option){
        Scanner input = new Scanner(System.in);

        switch (option) {
            case "1":
                try{
                    for(Customer temp: AdminResource.getALLCustomers())
                    {
                        System.out.println(temp);
                        break;
                    }

                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                    break;
                }
            case "2":
                try{
                    for(IRoom room: AdminResource.getALLRooms())
                    {
                        System.out.println(room);
                        break;
                    }


                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                    break;
                }
            case "3":
                try{
                    AdminResource.displayALLReservations();
                    break;


                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                    break;
                }
            case "4":
                try{
                    System.out.println("enter Room number");
                    String roomid = input.nextLine();
                    System.out.println("enter Room Price");
                    String price=input.nextLine();
                    Room room=new Room(roomid,Double.parseDouble(price));
                    List<IRoom> L=new ArrayList<IRoom>();
                    L.add(room);
                    System.out.println("enter anther room Y/N");
                    String flag=input.nextLine();
                    while (flag=="Y" || flag=="y"){
                        System.out.println("enter Room number");
                        roomid = input.nextLine();
                        System.out.println("enter Room Price");
                        price=input.nextLine();
                        room=new Room(roomid,Double.parseDouble(price));

                        L.add(room);
                        System.out.println("enter anther room Y/N");
                        flag=input.nextLine();

                    }
                    AdminResource.addRoom(L);
                    break;
                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                    break;
                }
            case "5":
                try{
                    MainMenu.main(null);

                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }


        }

    }
}
