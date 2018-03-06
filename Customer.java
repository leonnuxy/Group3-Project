/** This class creates a customer that has a numerical ID and a name. This class can be called externally for use in identifying
individuals and relating them to a BankAccount */
public class Customer{

  //public Customer(){}
  // Global variables set to default values.
  String name;
  int id;

  /* This is a constructor that can set a new name and customer ID */
  public Customer(String name, int id){
    this.name = name;
    this.id = id;
  }

  public Customer(Customer oldCustomer){
    name = oldCustomer.name;
    id = oldCustomer.id;
  }

  public String getName(){
    return name;
  }

  public int getID(){
    return id;
  }

  public void setName(String newName){
    if (name instanceof String){
      name = newName;
    }
  }

  public void setId(int iD){
    if (id == (int)id) {
      id = iD;
    }
  }

  public String toString(){
    String iD = Integer.toString(id);
    String name_id = name + " " + iD;
    return name_id;
  }

}
