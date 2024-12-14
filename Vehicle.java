public class Vehicle {

    private String vehicleID;
    private String status;
    private float rentalPrice;

    public Vehicle(String vehicleID, String status, float rentalPrice) {
        this.vehicleID = vehicleID;
        this.status = status;
        this.rentalPrice = rentalPrice;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
