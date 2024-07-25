package com.multi;
public class CityVO {
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;

    @Override
    public String toString() {
        Name = Name.length() >= 4 ? Name.substring(0,4) : Name;
        return
                "아이디>> " + ID +
                ",\t국가코드>> " + CountryCode +
                ",\t지역명>> " + Name +
                ",\t인구수>> " + Population ;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }
//문제 4-1. 각 필드에 대한 GET/SET/toString메서드를 구현하시오.
    //          단, toString()메서드는 오버라이드하여 구현하고,
    //          모든 필드의 값이 "하나의 String타입"으로 반환되어야 함.

        /***********************************************
     * 구현 코드
     *
     *
     *
     */
}