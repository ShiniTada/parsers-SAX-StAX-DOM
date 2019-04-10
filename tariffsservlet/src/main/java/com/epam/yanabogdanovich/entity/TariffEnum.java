package com.epam.yanabogdanovich.entity;

public enum TariffEnum {

    TARIFFS("tariffs"),
    TARIFF("tariff"),
    ID("id"),
    TARIFF_NAME("tariffName"),
    OPERATOR_NAME("operatorName"),
    PAYROLL("payroll"),
    CALL_PRICES("callPrices"),
    CALL_PRICE_INSIDE_THE_NETWORK("callPriceInsideTheNetwork"),
    CALL_PRICE_OUTSIDE_THE_NETWORK("callPriceOutsideTheNetwork"),
    CALL_PRICE_TO_STATIONARY_PHONE("callPriceToStationaryPhone"),
    SMS_PRICES("smsPrices"),
    SMS_PRICE_INSIDE_THE_NETWORK("smsPriceInsideTheNetwork"),
    SMS_PRICE_OUTSIDE_THE_NETWORK("smsPriceOutsideTheNetwork"),
    PARAMETERS("parameters"),
    NUMBER_OF_THE_FAVORITE_NUMBERS("numberOfTheFavoriteNumbers"),
    BILLING("billing"),
    FEE_CONNECTION("feeConnection"),
    INTRODUCTION_DATE("introductionDate");

    private String value;
    private static final String UNDERSCORE = "_";
    private static final String DASH = "-";

    private TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String toEnumFormat(String name){
        return name.replaceAll(DASH, UNDERSCORE).toUpperCase();
    }

    public String toTag(){
        return name().replaceAll(UNDERSCORE, DASH).toLowerCase();
    }


}
