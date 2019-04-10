package com.epam.yanabogdanovich.parser.sax;


import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.parser.TariffsBuilderTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TariffsSAXBuilderTest {

    @Test
    public void buildTariffs() {
        //given
        TariffsSAXBuilder saxParser = new TariffsSAXBuilder();
        //when
        saxParser.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = saxParser.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        //then
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}
