package com.epam.yanabogdanovich.parser.sax;

import com.epam.yanabogdanovich.entity.Billing;
import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.entity.TariffEnum;
import com.epam.yanabogdanovich.filter.DateParser;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TariffsHandler extends DefaultHandler {

    private Set<Tariff> tariffs = new HashSet<>();
    private Tariff current = null;
    private TariffEnum currentEnum = null;

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("tariff".equals(qName)) {
            current = new Tariff();
            current.setId(Integer.parseInt(attrs.getValue(0)));
        } else {
            String enumName = TariffEnum.toEnumFormat(qName);
            currentEnum = TariffEnum.valueOf(enumName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("tariff".equals(qName)) {
            tariffs.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
            String s = new String(ch, start, length).trim();
            if (currentEnum != null) {
                switch (currentEnum) {
                    case TARIFF_NAME:
                        current.setTariffName(s);
                        break;
                    case OPERATOR_NAME:
                        current.setOperatorName(s);
                        break;
                    case PAYROLL:
                        current.setPayroll(Integer.parseInt(s));
                        break;
                    case CALL_PRICE_INSIDE_THE_NETWORK:
                        current.getCallPrices().setCallPriceInsideTheNetwork(Integer.parseInt(s));
                        break;
                    case CALL_PRICE_OUTSIDE_THE_NETWORK:
                        current.getCallPrices().setCallPriceOutsideTheNetwork(Integer.parseInt(s));
                        break;
                    case CALL_PRICE_TO_STATIONARY_PHONE:
                        current.getCallPrices().setCallPriceToStationaryPhone(Integer.parseInt(s));
                        break;
                    case SMS_PRICE_INSIDE_THE_NETWORK:
                        current.getSmsPrices().setSmsPriceInsideTheNetwork(Integer.parseInt(s));
                        break;
                    case SMS_PRICE_OUTSIDE_THE_NETWORK:
                        current.getSmsPrices().setSmsPriceOutsideTheNetwork(Integer.parseInt(s));
                        break;
                    case NUMBER_OF_THE_FAVORITE_NUMBERS:
                        current.getParameters().setNumberOfTheFavoriteNumbers(Integer.parseInt(s));
                        break;
                    case BILLING:
                        current.getParameters().setBilling(Billing.valueOf(s.toUpperCase()));
                        break;
                    case FEE_CONNECTION:
                        current.getParameters().setFeeConnection(Integer.parseInt(s));
                        break;
                    case INTRODUCTION_DATE:
                        Date date = DateParser.parseDate(s);
                        current.setIntroductionDate(date);
                        break;
                }
            }
        currentEnum = null;
    }

}
