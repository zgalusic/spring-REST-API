package com.ingemark.business.api.rest.client.hnb;

public enum QueryParameter {

    DATUM_PRIMJENE("datum-primjene"),
    VALUTA("valuta"),
    DATUM_PRIMJENE_OD("datum-primjene-od"),
    DATUM_PRIMJENE_DO("datum-primjene-do"),
    FORMAT("format");

    private final String name;

    QueryParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
