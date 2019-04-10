package com.epam.yanabogdanovich.parser.stax;

import com.epam.yanabogdanovich.entity.*;
import com.epam.yanabogdanovich.filter.DateParser;
import com.epam.yanabogdanovich.parser.TariffsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.Date;

public class TariffsStAXBuilder extends TariffsBuilder {

    private static Logger LOGGER = LogManager.getLogger(TariffsStAXBuilder.class);

    private XMLInputFactory inputFactory = XMLInputFactory.newInstance();


    @Override
    public void buildTariffs(String path) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            LOGGER.warn("FileNotFoundException in  buildTariffs() in StAX-parser");
        }
        String name;
        XMLStreamReader reader;
        try {
            reader = inputFactory.createXMLStreamReader(input);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if ("tariff".equals(name)) {
                        Tariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.warn("Exception while parsing(StAX)", e.getLocalizedMessage());
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
        Tariff current = new Tariff();
        current.setId(Integer.parseInt(reader.getAttributeValue(null, TariffEnum.ID.toTag())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case (XMLStreamConstants.START_ELEMENT):
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(TariffEnum.toEnumFormat(name))) {
                        case TARIFF_NAME:
                            current.setTariffName(getXMLText(reader));
                            break;
                        case OPERATOR_NAME:
                            current.setOperatorName(getXMLText(reader));
                            break;
                        case PAYROLL:
                            current.setPayroll(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CALL_PRICES:
                            current.setCallPrices(getXMLCallPrices(reader));
                            break;
                        case SMS_PRICES:
                            current.setSmsPrices(getXMLSmsPrices(reader));
                            break;
                        case PARAMETERS:
                            current.setParameters(getXMLParameters(reader));
                            break;
                        case INTRODUCTION_DATE:
                            Date date = DateParser.parseDate(getXMLText(reader));
                            current.setIntroductionDate(date);
                            break;
                    }
                    break;
                case (XMLStreamConstants.END_ELEMENT):
                    name = reader.getLocalName();
                    if ("tariff".equals(name)) {
                        return current;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag tariff");
    }

    private CallPrices getXMLCallPrices(XMLStreamReader reader) throws XMLStreamException {
        CallPrices callPrices = new CallPrices();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(TariffEnum.toEnumFormat(name))) {
                        case CALL_PRICE_INSIDE_THE_NETWORK:
                            callPrices.setCallPriceInsideTheNetwork(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CALL_PRICE_OUTSIDE_THE_NETWORK:
                            callPrices.setCallPriceOutsideTheNetwork(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CALL_PRICE_TO_STATIONARY_PHONE:
                            callPrices.setCallPriceToStationaryPhone(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(TariffEnum.toEnumFormat(name)) == TariffEnum.CALL_PRICES){
                        return callPrices;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag callPrices.");
    }


    private SmsPrices getXMLSmsPrices(XMLStreamReader reader) throws XMLStreamException {
        SmsPrices smsPrices = new SmsPrices();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(TariffEnum.toEnumFormat(name))) {
                        case SMS_PRICE_INSIDE_THE_NETWORK:
                            smsPrices.setSmsPriceInsideTheNetwork(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SMS_PRICE_OUTSIDE_THE_NETWORK:
                            smsPrices.setSmsPriceOutsideTheNetwork(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(TariffEnum.toEnumFormat(name)) == TariffEnum.SMS_PRICES){
                        return smsPrices;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag smsPrices.");
    }


    private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
        Parameters parameters = new Parameters();
        int type;
        String name;
        while (reader.hasNext()){
            type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(TariffEnum.toEnumFormat(name))) {
                        case NUMBER_OF_THE_FAVORITE_NUMBERS:
                            parameters.setNumberOfTheFavoriteNumbers(Integer.parseInt(getXMLText(reader)));
                            break;
                        case BILLING:
                            name = getXMLText(reader).toUpperCase();
                            parameters.setBilling(Billing.valueOf(name));
                            break;
                        case FEE_CONNECTION:
                            parameters.setFeeConnection(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(TariffEnum.toEnumFormat(name)) == TariffEnum.PARAMETERS){
                        return parameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag parameters.");
    }




}
