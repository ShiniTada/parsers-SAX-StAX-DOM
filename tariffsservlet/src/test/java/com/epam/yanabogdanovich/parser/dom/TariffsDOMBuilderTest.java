package com.epam.yanabogdanovich.parser.dom;

import com.epam.yanabogdanovich.entity.Tariff;
import com.epam.yanabogdanovich.parser.TariffsBuilderTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TariffsDOMBuilderTest {


    @Test
    public void buildTariffs() {
        //given
        TariffsDOMBuilder domParser = new TariffsDOMBuilder();
        //when
        domParser.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = domParser.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        //then
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}
