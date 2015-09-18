var client = require('swagger-client');

// Create a new client object to talk to the customer API.
var swagger = new client.SwaggerClient({
  url: 'http://localhost:7800/customerdb/v1/swagger.json',
  success: function() {
    
    // Get and print all customers from the deployed customer API.
    swagger.apis.customers.getAllCustomers({}, function(response) {
      console.log('Printing all customers:');
      response.obj.forEach(function(customer){
        console.log('ID = ' + customer.id + ', first name = ' + customer.firstname + ', last name = ' + customer.lastname + ', address = ' + customer.address);
      });
      console.log('');
      
      // Get and print the customer with ID #3 from the deployed customer API.
      swagger.apis.customers.getCustomer({customerId: 3}, function(response) {
        console.log('Printing customer with ID #3:');
        console.log('ID = ' + response.obj.id + ', first name = ' + response.obj.firstname + ', last name = ' + response.obj.lastname + ', address = ' + response.obj.address);
      });
    });
  }
});