package com.epam.yanabogdanovich.entity;

import java.util.Objects;

public class SmsPrices {

    private int smsPriceInsideTheNetwork;
    private int smsPriceOutsideTheNetwork;

    public SmsPrices() {}

    public SmsPrices(int smsPriceInsideTheNetwork, int smsPriceOutsideTheNetwork) {
        this.smsPriceInsideTheNetwork = smsPriceInsideTheNetwork;
        this.smsPriceOutsideTheNetwork = smsPriceOutsideTheNetwork;
    }

    public int getSmsPriceInsideTheNetwork() {
        return smsPriceInsideTheNetwork;
    }

    public void setSmsPriceInsideTheNetwork(int smsPriceInsideTheNetwork) {
        this.smsPriceInsideTheNetwork = smsPriceInsideTheNetwork;
    }

    public int getSmsPriceOutsideTheNetwork() {
        return smsPriceOutsideTheNetwork;
    }

    public void setSmsPriceOutsideTheNetwork(int smsPriceOutsideTheNetwork) {
        this.smsPriceOutsideTheNetwork = smsPriceOutsideTheNetwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SmsPrices smsPrices = (SmsPrices) o;
        return smsPriceInsideTheNetwork == smsPrices.smsPriceInsideTheNetwork &&
                smsPriceOutsideTheNetwork == smsPrices.smsPriceOutsideTheNetwork;
    }

    @Override
    public int hashCode() {
        return Objects.hash(smsPriceInsideTheNetwork, smsPriceOutsideTheNetwork);
    }

    @Override
    public String toString() {
        return "SmsPrices{" +
                "smsPriceInsideTheNetwork=" + smsPriceInsideTheNetwork +
                ", smsPriceOutsideTheNetwork=" + smsPriceOutsideTheNetwork +
                '}';
    }
}