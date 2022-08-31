package api;
import model.IRoom;
import model.Reservation;
import service.CustomerService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static api.HotelResource.findARoom;
import static api.HotelResource.getAllReservations;
import static javafx.application.Platform.exit;

public class MainMenu {
    public static void main(String[] args){

    start();
    }
    public static void start()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("**********************************************************************************");
        System.out.println("1. Find and reserve a room ");
        System.out.println("2. See My reservations ");
        System.out.println("3. Create An account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("**********************************************************************************");
        System.out.println("Please select a number for a menu option");
        String option = input.nextLine();
        startAction(option);

    }
    public  static void startAction(String option){
        Scanner input = new Scanner(System.in);

        switch (option) {
            case "1":
                System.out.println("Enter the check in date ");
                try{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy" );
                    Date checkInDate  = formatter.parse(input.nextLine());
                    System.out.println("Enter the check out date ");
                    Date checkOutDate  = formatter.parse(input.nextLine());
                    Collection<IRoom> temp=HotelResource.findARoom(checkInDate,checkOutDate);
                    for(IRoom room:temp) {
                        System.out.println(room);
                    }
                    System.out.println("to make Reservation Enter room number");
                    String roomid = input.nextLine();
                    IRoom room=HotelResource.getRoom(roomid);
                    System.out.println("Enter Email");
                    String Email=input.nextLine();
                    HotelResource.bookARoom(Email,room,checkInDate,checkOutDate);
                    System.out.println("Reservation is done");
                    break;




                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }
            case "2":
                try {
                    Collection<Reservation>temp=HotelResource.getAllReservations();
                        for(Reservation res:temp) {
                            System.out.println(res);
                     }

                    }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }
            case "3":
                try{
                    System.out.println("Enter First Name");
                    String firstName=input.nextLine();
                    System.out.println("Enter last Name");
                    String lastName=input.nextLine();
                    System.out.println("Enter Email");
                    String email=input.nextLine();
                    CustomerService.addCustomer(email,firstName,lastName);
                    break;




                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }
            case "4":
                try{
                    AdminMenu.start();


                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }
            case "5":
                try{
                    exit();


                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }


        }
        start();
    }
}

