package api;
import model.Customer;
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
                Collection<IRoom>rooms=new ArrayList<>();
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date checkInDate = formatter.parse(input.nextLine());
                    System.out.println("Enter the check out date ");
                    Date checkOutDate = formatter.parse(input.nextLine());


                    rooms = HotelResource.findARoom(checkInDate, checkOutDate);
                    if(rooms.isEmpty())
                    {
                        System.out.println("There is no available rooms");
                        break;
                    }
                    System.out.println("available  rooms");
                    for (IRoom room : rooms) {
                        System.out.println(room);
                    }
                    System.out.println("to make Reservation Enter room number from available rooms");
                    String roomid = input.nextLine();
                    IRoom tempRoom = HotelResource.getRoom(roomid);
                    System.out.println("enter Email");
                    String email = input.nextLine();
                    Reservation r = HotelResource.bookARoom(email, tempRoom, checkInDate, checkOutDate);
                    System.out.println("your reservation " + r);
                    break;


                }


                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                }
            case "2":
                try {
                    System.out.println("enter your email");
                     final String email = input.nextLine();
                    Customer cust=HotelResource.GetCustomer(email);
                    Collection<Reservation>temp=HotelResource.getAllReservations();
                        for(Reservation res:temp) {
                            if(res.getCustomer()==cust){
                            System.out.println("Reservation");
                            System.out.println(res);
                     }
                            break;
                        }
                        System.out.println("NO reservation to this customer");
                        break;
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
                    final String email=input.nextLine();
                    for(Customer customer:CustomerService.getAllCustomers()) {
                        if(customer.getEmail().equals(email)) {
                            System.out.println(" error: This email is already exit");
                            break;
                        }
                        }
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
                    break;


                }
                catch(Exception e) {
                    System.out.println("error is " + e.getMessage());
                    break;
                }


        }
        start();
    }
}

