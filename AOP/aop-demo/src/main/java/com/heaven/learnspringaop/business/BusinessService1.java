package com.heaven.learnspringaop.business;

import com.heaven.learnspringaop.annotations.TrackTime;
import com.heaven.learnspringaop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {
    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() throws InterruptedException {
        int[] data = dataService1.retrieveData();
        Thread.sleep(30);

//        throw new RuntimeException("Something Went Wrong!");
        return Arrays.stream(data).max().orElse(0);
    }
}
