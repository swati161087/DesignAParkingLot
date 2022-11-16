package com.scaler.parkinglot.models;

import com.scaler.parkinglot.enums.BillStatus;

public class Bill extends BaseModel {
    private Ticket ticket;
    private int amount;
    private String exitTime;
    private String invoiceNumber;
    private Payment payment;
    private BillStatus billStatus;
}
