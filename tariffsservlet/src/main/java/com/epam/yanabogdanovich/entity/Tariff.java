package com.epam.yanabogdanovich.entity;


import java.util.Date;
import java.util.Objects;

public class Tariff {

    private int id;
    private String tariffName;
    private String operatorName;
    private int payroll;
    private CallPrices callPrices;
    private SmsPrices smsPrices;
    private Parameters parameters;
    private Date introductionDate;

    public Tariff(int id, String tariffName, String operatorName, int payroll,
                  CallPrices callPrices, SmsPrices smsPrices, Parameters parameters, Date introductionDate) {
        this.id = id;
        this.tariffName = tariffName;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrices = callPrices;
        this.smsPrices = smsPrices;
        this.parameters = parameters;
        this.introductionDate = introductionDate;

    }

    public Tariff() {
        callPrices = new CallPrices();
        smsPrices = new SmsPrices();
        parameters = new Parameters();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public SmsPrices getSmsPrices() {
        return smsPrices;
    }

    public void setSmsPrices(SmsPrices smsPrices) {
        this.smsPrices = smsPrices;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Date getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate = introductionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tariff tariff = (Tariff) o;
        return id == tariff.id &&
                payroll == tariff.payroll &&
                Objects.equals(tariffName, tariff.tariffName) &&
                Objects.equals(operatorName, tariff.operatorName) &&
                Objects.equals(callPrices, tariff.callPrices) &&
                Objects.equals(smsPrices, tariff.smsPrices) &&
                Objects.equals(parameters, tariff.parameters) &&
                Objects.equals(introductionDate, tariff.introductionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tariffName, operatorName, payroll, callPrices, smsPrices, parameters, introductionDate);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", tariffName='" + tariffName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrices=" + callPrices +
                ", smsPrices=" + smsPrices +
                ", parameters=" + parameters +
                ", introductionDate=" + introductionDate +
                '}';
    }
}
