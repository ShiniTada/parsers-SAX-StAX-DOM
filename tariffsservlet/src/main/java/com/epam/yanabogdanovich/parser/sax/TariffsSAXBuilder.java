package com.epam.yanabogdanovich.parser.sax;

import com.epam.yanabogdanovich.parser.TariffsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TariffsSAXBuilder extends TariffsBuilder {

    private TariffsHandler handler = new TariffsHandler();
    private XMLReader reader;

    private static final Logger LOGGER = LogManager.getLogger(TariffsSAXBuilder.class);

    public TariffsSAXBuilder() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException | ParserConfigurationException e) {
            LOGGER.error("Exception with SAX-parser. " + e.getLocalizedMessage());
        }
    }


    @Override
    public void buildTariffs(String path) {
        try{
            reader.parse(path);
        } catch (SAXException e) {
            LOGGER.error("Exception with SAX-parser. " + e.getLocalizedMessage());
        } catch (IOException e) {
            LOGGER.error("Exception while working with the resource." + e.getLocalizedMessage());
        }
        tariffs = handler.getTariffs();
    }

}
