package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
     public static List<IRoom>L=new ArrayList<>();
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

                    }
                    break;

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
                    }
                    break;


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
                String flag;
                try{


                    int x=0;
                    do {
                        System.out.println("enter Room number");
                        final String roomid = input.nextLine();
                        for (IRoom room:L) {
                            if (room.getRoomNumber().equals(roomid)) {
                                System.out.println("error:this room ID is already exit you cannot create it");
                                x=1;
                                break;
                            }
                        }
                        if (x!=1) {
                            System.out.println("enter Room Price");
                            String price = input.nextLine();
                            System.out.println("enter room type 1 for SINGEL, and 2 for DOUBLE");
                            String temp = "SINGEL";
                            String type = input.nextLine();
                            RoomType roomtype;
                            if (type.equals("1")) {
                                roomtype = RoomType.SINGEL;
                            } else {
                                roomtype = RoomType.DOUBLE;
                            }
                            IRoom room = new Room(roomid, Double.parseDouble(price), roomtype);
                            L.add(room);

                        }

                        System.out.println("enter anther room Y/N");
                        flag = input.nextLine();
                    }while ((flag.equals("Y")) || (flag.equals("y")));
                    AdminResource A=AdminResource.getInstance();
                    A.addRoom(L);
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
