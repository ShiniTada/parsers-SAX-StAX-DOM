package com.epam.yanabogdanovich.parser.dom;

import com.epam.yanabogdanovich.entity.Billing;
import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.entity.TariffEnum;
import com.epam.yanabogdanovich.filter.DateParser;
import com.epam.yanabogdanovich.parser.TariffsBuilder;
import com.epam.yanabogdanovich.parser.stax.TariffsStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Date;

public class TariffsDOMBuilder extends TariffsBuilder {
    private static final Logger LOGGER = LogManager.getLogger(TariffsStAXBuilder.class);

    private DocumentBuilder documentBuilder;

    public TariffsDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Exception while creating DOMBuilder.", e.getLocalizedMessage());
        }
    }

    @Override
    public void buildTariffs(String path) {
        Document doc;
        try {
            doc = documentBuilder.parse(path);
            Element root = doc.getDocumentElement();

            NodeList tariffsList = root.getElementsByTagName("tariff");
            for (int i = 0; i < tariffsList.getLength(); i++) {
                Element tariffElement = (Element) tariffsList.item(i);
                Tariff tariff = buildTariff(tariffElement);
                tariffs.add(tariff);
            }
        } catch (IOException e) {
            LOGGER.error("Missing resource.", e.getLocalizedMessage());
        } catch (SAXException e) {
            LOGGER.error("Exception in buildTariffs() in parse().", e.getLocalizedMessage());
        }
    }


    private static String getElementTextContext(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }


    private Tariff buildTariff(Element tariffElement) {
        Tariff current = new Tariff();
        int id = Integer.parseInt(tariffElement.getAttribute(TariffEnum.ID.toTag()));
        String tariffName = getElementTextContext(tariffElement, TariffEnum.TARIFF_NAME.toTag());
        String operatorName = getElementTextContext(tariffElement, TariffEnum.OPERATOR_NAME.toTag());
        int payroll = Integer.parseInt(getElementTextContext(tariffElement, TariffEnum.PAYROLL.toTag()));

        Element callPricesElement = (Element) tariffElement.getElementsByTagName(TariffEnum.CALL_PRICES.toTag()).item(0);
        int callInTheNet = Integer.parseInt(getElementTextContext(callPricesElement, TariffEnum.CALL_PRICE_INSIDE_THE_NETWORK.toTag()));
        int callOutTheNet = Integer.parseInt(getElementTextContext(callPricesElement, TariffEnum.CALL_PRICE_OUTSIDE_THE_NETWORK.toTag()));
        int callToStationary = Integer.parseInt(getElementTextContext(callPricesElement, TariffEnum.CALL_PRICE_TO_STATIONARY_PHONE.toTag()));

        Element smsPricesElement = (Element) tariffElement.getElementsByTagName(TariffEnum.SMS_PRICES.toTag()).item(0);
        int smsInTheNet = Integer.parseInt(getElementTextContext(smsPricesElement, TariffEnum.SMS_PRICE_INSIDE_THE_NETWORK.toTag()));
        int smsOutTheNet = Integer.parseInt(getElementTextContext(smsPricesElement, TariffEnum.SMS_PRICE_OUTSIDE_THE_NETWORK.toTag()));

        Element parametersElement = (Element) tariffElement.getElementsByTagName(TariffEnum.PARAMETERS.toTag()).item(0);
        int favoriteNum = Integer.parseInt(getElementTextContext(parametersElement, TariffEnum.NUMBER_OF_THE_FAVORITE_NUMBERS.toTag()));
        Billing billing = Billing.valueOf(
                getElementTextContext(parametersElement, TariffEnum.BILLING.toTag())
                        .toUpperCase());
        int feeConnection = Integer.parseInt(getElementTextContext(parametersElement, TariffEnum.FEE_CONNECTION.toTag()));

        String dateString = getElementTextContext(tariffElement, TariffEnum.INTRODUCTION_DATE.toTag());
        Date date = DateParser.parseDate(dateString);


        current.setId(id);
        current.setTariffName(tariffName);
        current.setOperatorName(operatorName);
        current.setPayroll(payroll);
        current.getCallPrices().setCallPriceInsideTheNetwork(callInTheNet);
        current.getCallPrices().setCallPriceOutsideTheNetwork(callOutTheNet);
        current.getCallPrices().setCallPriceToStationaryPhone(callToStationary);
        current.getSmsPrices().setSmsPriceInsideTheNetwork(smsInTheNet);
        current.getSmsPrices().setSmsPriceOutsideTheNetwork(smsOutTheNet);
        current.getParameters().setNumberOfTheFavoriteNumbers(favoriteNum);
        current.getParameters().setBilling(billing);
        current.getParameters().setFeeConnection(feeConnection);
        current.setIntroductionDate(date);
        return current;
    }
}
