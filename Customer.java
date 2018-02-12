/** This class creates a customer that has a numerical ID and a name. This class can be called externally for use in identifying
individuals and relating them to a BankAccount */
public class Customer{

    // Global variables set to default values.
    String name = ""Customer"";
    int customerID;

    /* This is a default constructor */
    public Customer(){}

    /* This is a constructor that can set a new name and customer ID */
    public Customer(String name, int customerID){
        this.name = name;
        this.customerID = customerID;
    }


    public Customer(Customer something){
        name = something.name;
        customerID = something.customerID;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return customerID;
    }

    public void setName(String validName){
        if (name instanceof String){
            name = validName;
        }
    }

    public void setId(int validId){
        if (customerID == (int)customerID) {
            customerID = validId;
        }
    }

    public String toString(){
        String id = Integer.toString(customerID);
        String name_id = name + " " + id;
        return name_id;
    }

}
