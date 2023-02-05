package com.heaven.mockitodemo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int values:data){
            if(values>greatestValue)
                greatestValue=values;
        }
        return greatestValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}
