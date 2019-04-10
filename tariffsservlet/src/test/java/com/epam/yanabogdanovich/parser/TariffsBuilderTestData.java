package com.epam.yanabogdanovich.parser;

import com.epam.yanabogdanovich.entity.*;
import com.epam.yanabogdanovich.filter.DateParser;

public class TariffsBuilderTestData {

    public static final String FILE_NAME = "src/test/java/resources/simpleTariffs.xml";
    public static final Tariff TARIFF = new Tariff(
            100, "SmartMini", "Beeline", 4470,
            new CallPrices(0, 11, 17),
            new SmsPrices(7, 13),
            new Parameters(3, Billing.MINUTE, 120),

            DateParser.parseDate("2016-01-04"));

}
