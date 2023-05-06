package com.CarRental.Car.Rental.Project.DTO;

public class AtmPagePayloadDTO {

    private String driverID;

    private String cardNo;

    //================================CONSTRUCTORS AND GETTER SETTERS==========================================//


    public AtmPagePayloadDTO() {
    }

    public AtmPagePayloadDTO(String driverID, String cardNo) {
        this.driverID = driverID;
        this.cardNo = cardNo;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
