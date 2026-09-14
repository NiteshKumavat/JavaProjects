package Banking_Management_System;

public class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String address;

    Customer(String name, int id, String phone, String address){
        this.name = name;
        this.customerId = id;
        this.phone = phone;
        this.address = address;
    }

    public void displayCustomer(){
        System.out.println("-------------------------------------");
        System.out.println("Information of " + this.name);
        System.out.println("-------------------------------------");
        System.out.println("Name : " + this.name);
        System.out.println("Phone number : " + this.phone);
        System.out.println("Address : " + this.address);
    }

    public int getCustomerId(){
        return this.customerId;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAddress(){
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
