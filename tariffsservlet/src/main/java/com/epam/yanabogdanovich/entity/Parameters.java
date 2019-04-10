package com.epam.yanabogdanovich.entity;

import java.util.Objects;


public class Parameters {

    private int numberOfTheFavoriteNumbers;
    private Billing billing;
    private int feeConnection;

    public Parameters() {}

    public Parameters(int numberOfTheFavoriteNumbers, Billing billing, int feeConnection) {
        this.numberOfTheFavoriteNumbers = numberOfTheFavoriteNumbers;
        this.billing = billing;
        this.feeConnection = feeConnection;
    }

    public int getNumberOfTheFavoriteNumbers() {
        return numberOfTheFavoriteNumbers;
    }

    public void setNumberOfTheFavoriteNumbers(int numberOfTheFavoriteNumbers) {
        this.numberOfTheFavoriteNumbers = numberOfTheFavoriteNumbers;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public int getFeeConnection() {
        return feeConnection;
    }

    public void setFeeConnection(int feeConnection) {
        this.feeConnection = feeConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parameters that = (Parameters) o;
        return numberOfTheFavoriteNumbers == that.numberOfTheFavoriteNumbers &&
                feeConnection == that.feeConnection &&
                billing == that.billing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTheFavoriteNumbers, billing, feeConnection);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "numberOfTheFavoriteNumbers=" + numberOfTheFavoriteNumbers +
                ", billing=" + billing +
                ", feeConnection=" + feeConnection +
                '}';
    }
}