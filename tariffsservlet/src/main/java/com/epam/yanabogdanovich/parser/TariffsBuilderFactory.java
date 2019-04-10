package com.epam.yanabogdanovich.parser;

import com.epam.yanabogdanovich.parser.dom.TariffsDOMBuilder;
import com.epam.yanabogdanovich.parser.sax.TariffsSAXBuilder;
import com.epam.yanabogdanovich.parser.stax.TariffsStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffsBuilderFactory {

    private static final Logger LOGGER = LogManager.getLogger(TariffsBuilderFactory.class);

    public TariffsBuilder createTariffsBuilder(String typeParser) {
        String type = typeParser.toUpperCase();

        LOGGER.info("Preparing parser " + type + ".");

        switch (type) {
            case "DOM":
                return new TariffsDOMBuilder();
            case "SAX":
                return new TariffsSAXBuilder();
            case "STAX":
                return new TariffsStAXBuilder();
            default:
                return new TariffsStAXBuilder();
        }
    }

}
