package com.epam.yanabogdanovich.entity;

import java.util.Objects;


public class CallPrices {

    private int callPriceInsideTheNetwork;
    private int callPriceOutsideTheNetwork;
    private int callPriceToStationaryPhone;

    public CallPrices() {}

    public CallPrices(int callPriceInsideTheNetwork, int callPriceOutsideTheNetwork, int callPriceToStationaryPhone) {
        this.callPriceInsideTheNetwork = callPriceInsideTheNetwork;
        this.callPriceOutsideTheNetwork = callPriceOutsideTheNetwork;
        this.callPriceToStationaryPhone = callPriceToStationaryPhone;
    }

    public int getCallPriceInsideTheNetwork() {
        return callPriceInsideTheNetwork;
    }

    public void setCallPriceInsideTheNetwork(int callPriceInsideTheNetwork) {
        this.callPriceInsideTheNetwork = callPriceInsideTheNetwork;
    }

    public int getCallPriceOutsideTheNetwork() {
        return callPriceOutsideTheNetwork;
    }

    public void setCallPriceOutsideTheNetwork(int callPriceOutsideTheNetwork) {
        this.callPriceOutsideTheNetwork = callPriceOutsideTheNetwork;
    }

    public int getCallPriceToStationaryPhone() {
        return callPriceToStationaryPhone;
    }

    public void setCallPriceToStationaryPhone(int callPriceToStationaryPhone) {
        this.callPriceToStationaryPhone = callPriceToStationaryPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CallPrices that = (CallPrices) o;
        return callPriceInsideTheNetwork == that.callPriceInsideTheNetwork &&
                callPriceOutsideTheNetwork == that.callPriceOutsideTheNetwork &&
                callPriceToStationaryPhone == that.callPriceToStationaryPhone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(callPriceInsideTheNetwork, callPriceOutsideTheNetwork, callPriceToStationaryPhone);
    }

    @Override
    public String toString() {
        return "CallPrices{" +
                "callPriceInsideTheNetwork=" + callPriceInsideTheNetwork +
                ", callPriceOutsideTheNetwork=" + callPriceOutsideTheNetwork +
                ", callPriceToStationaryPhone=" + callPriceToStationaryPhone +
                '}';
    }
}
