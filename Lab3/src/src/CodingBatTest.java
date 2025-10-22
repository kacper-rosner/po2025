package src;

import org.junit.Test;

import static org.junit.Assert.*;


public class CodingBatTest{
    @Test
    public void firstHalf(){
        assertEquals("Woo",CodingBat.firstHalf("WooHoo"));
        assertEquals("Hello",CodingBat.firstHalf("Hello There"));
        assertEquals("abc",CodingBat.firstHalf("abcdef"));

    }
    @Test
    public void monkeyTrouble(){
        assertTrue(CodingBat.monkeyTrouble(false,false));
        assertFalse(CodingBat.monkeyTrouble(true,false));
        assertFalse(CodingBat.monkeyTrouble(false,true));
        assertTrue(CodingBat.monkeyTrouble(true,true));
    }
    @Test
    public void sleepIn(){
        assertTrue(CodingBat.sleepIn(false,false));
        assertFalse(CodingBat.sleepIn(true,false));
        assertTrue(CodingBat.sleepIn(false,true));
        assertTrue(CodingBat.sleepIn(true,true));
    }
    @Test
    public void firstLast6(){
        assertEquals(true,CodingBat.firstLast6(new int[]{1, 2, 6}));
        assertTrue(CodingBat.firstLast6(new int[]{6, 1, 2, 3}));
        assertFalse(CodingBat.firstLast6(new int[]{13, 6, 1, 2, 3}));
    }

}