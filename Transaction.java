import java.util.Date;

public class Transaction {
    private String transactionID;
    private Date borrowDate;
    private float totalPrice;
    private Customer customer;
    private Vehicle vehicle;

    public Transaction(String transactionID, Date borrowDate, float totalPrice, Customer customer, Vehicle vehicle) {
        this.transactionID = transactionID;
        this.borrowDate = borrowDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
