package com.castle.attack;

import org.junit.*;


import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TroopAllocatorTest
{

    @Before
    public void setUp() {

    }



    @Test
    public void testTroopAllocation() throws OutOfBoundException
    {
        TroopAllocator alloc = new TroopAllocator(TroopAllocator.AERIAL,100,
                0.66,0.5,0.5,9);
        alloc.calculateTroops();
        assertEquals( true,alloc.getLargeTroopCount() > 60 );
        assertEquals(true, alloc.getLast() > alloc.getNext());

        Map<String,Integer> result = alloc.getTroops();

        assertEquals(true,result.containsKey(TroopAllocator.ARCHERS));
        assertEquals(true, result.containsKey(TroopAllocator.SPEARMEN));
        assertEquals(true, result.containsKey(TroopAllocator.SWORDSMEN));

    }

    @Test(expected = OutOfBoundException.class)
    public void testInputOutOfBoundsException() throws OutOfBoundException {
        TroopAllocator alloc = new TroopAllocator(TroopAllocator.AERIAL,-1,
                0.66,0.5,0.5,9);

    }

    @Test(expected = OutOfBoundException.class)
    public void testLessInputOutOfBoundsException() throws OutOfBoundException {
        TroopAllocator alloc = new TroopAllocator(TroopAllocator.AERIAL,8,
                0.66,0.5,0.5,9);

    }

}