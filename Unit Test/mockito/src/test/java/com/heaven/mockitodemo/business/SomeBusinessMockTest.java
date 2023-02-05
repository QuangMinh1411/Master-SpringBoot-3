package com.heaven.mockitodemo.business;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl businessImpl;
    @Test
    void findTheGreatestFromAllData_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,18});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
}


