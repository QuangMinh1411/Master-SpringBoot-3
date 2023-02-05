package com.heaven.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {
    @Test
    void findTheGreatestFromAllData_basic() {
        DataServiceStub1 dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }

    @Test
    void findTheGreatesFromAllData_oneValue(){
        DataServiceStub2 dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(18,result);
    }

}

class DataServiceStub1 implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,15,5};
    }
}
class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {18};
    }
}