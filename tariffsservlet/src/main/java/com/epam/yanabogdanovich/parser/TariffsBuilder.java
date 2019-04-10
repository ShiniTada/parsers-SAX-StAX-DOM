package com.epam.yanabogdanovich.parser;

import com.epam.yanabogdanovich.entity.Tariff;

import java.util.HashSet;
import java.util.Set;

public abstract class TariffsBuilder {

    protected Set<Tariff> tariffs;

    public TariffsBuilder(){
        tariffs = new HashSet<>();
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    abstract public void buildTariffs(String path);
}