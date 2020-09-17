package com.mavenmodak.coronatracker.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationStat {

    private String State;
    private String Country;
    private int latestTotalCases;
    private int diffFromPrevDay;



}

