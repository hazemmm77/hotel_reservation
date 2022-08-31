package service;

import model.Customer;
import model.Reservation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public  class CustomerService {
   private static  List<Customer> customers = new LinkedList<Customer>();
    private static CustomerService customerService=null;
    private CustomerService(){}
    public static CustomerService getInstance(){
        if (customerService==null){
            customerService=new CustomerService();
        }
        return customerService;
    }
    public static void  addCustomer(String email,String firstName,String lastName){
        Customer temp=new Customer(firstName,lastName,email);
        customers.add(temp);

    }
    public static Customer getCustomer(String customerEmail)
    {    Customer temp=null;
        for(Customer cust :customers)
        {
            if (customerEmail==cust.getEmail())
            { temp= cust;

            }
        }
        return temp;
    }
    public static Collection<Customer>getAllCustomers()
    {
        return customers;
    }
}
