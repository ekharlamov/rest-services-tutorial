package com.ibm.iib;

import io.swagger.client.ApiException;
import io.swagger.client.api.CustomersApi;
import io.swagger.client.model.Customer;

import java.util.List;

public class Customers {

  public static void main(String[] args) {
    try {
      
      // Create a new client object to talk to the customer API.
      CustomersApi customersApi = new CustomersApi();
      
      // Set the base path to point at our deployed customer API.
      customersApi.setBasePath("http://localhost:7800/customerdb/v1");
      
      // Get and print all customers from the deployed customer API.
      System.out.println("Printing all customers:");
      List<Customer> customers = customersApi.getAllCustomers(5);
      for (Customer customer : customers) {
        printCustomer(customer);
      }
      System.out.println("");
      
      // Get and print the customer with ID #3 from the deployed customer API.
      System.out.println("Printing customer with ID #3:");
      Customer customer = customersApi.getCustomer(3);
      printCustomer(customer);
      
    } catch (ApiException e) {
      e.printStackTrace();
    }
  }

  private static void printCustomer(Customer customer) {
    System.out.printf("ID = %d, first name = %s, last name = %s, address = %s\n",
                      customer.getId(),
                      customer.getFirstname(),
                      customer.getLastname(),
                      customer.getAddress());
  }

}
