package com.manoj.unittesting.unittesting;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);
    @Test
    public void test(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void testReturnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void argumentCapturing(){

        mock.add("someString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("someString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){

        mock.add("someString1");
        mock.add("someString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> values = captor.getAllValues();

        assertEquals("someString1", values.get(0));
        assertEquals("someString2", values.get(1));

    }


}
