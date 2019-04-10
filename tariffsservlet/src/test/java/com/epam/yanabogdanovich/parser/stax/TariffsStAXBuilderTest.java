package com.epam.yanabogdanovich.parser.stax;

import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.parser.TariffsBuilderTestData;
import com.epam.yanabogdanovich.parser.sax.TariffsSAXBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TariffsStAXBuilderTest {

    @Test
    public void buildTariffs() {
        //given
        TariffsStAXBuilder staxParser = new TariffsStAXBuilder();
        //when
        staxParser.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = staxParser.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        //then
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}
