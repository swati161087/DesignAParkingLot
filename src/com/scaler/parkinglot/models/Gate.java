package com.scaler.parkinglot.models;

import com.scaler.parkinglot.enums.GateType;

public abstract class Gate extends BaseModel {
    private int gateNo;
    private GateType gateType;

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
