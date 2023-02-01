package com.heaven.mockitodemo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void simpleTest() {
        List listMocks = mock(List.class);
        when(listMocks.size()).thenReturn(3);
        assertEquals(3,listMocks.size());
    }

    @Test
    void multipleReturns() {
        List listMocks = mock(List.class);
        when(listMocks.size()).thenReturn(1).thenReturn(2);
        assertEquals(1,listMocks.size());
        assertEquals(2,listMocks.size());
    }
    @Test
    void parameters(){
        List listMocks = mock(List.class);
        when(listMocks.get(0)).thenReturn("Some string");
        assertEquals("Some string",listMocks.get(0));
        assertEquals(null,listMocks.get(2));
    }

    @Test
    void genericParameters(){
        List listMocks = mock(List.class);
        when(listMocks.get(Mockito.anyInt())).thenReturn("Some other string");
        assertEquals("Some other string",listMocks.get(0));
        assertEquals("Some other string",listMocks.get(2));
    }
}
