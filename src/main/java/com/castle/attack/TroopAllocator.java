package com.castle.attack;

import java.util.HashMap;
import java.util.Map;

public class TroopAllocator
{

    public static String AERIAL = "aerial";
    public static String GROUND = "ground";
    public static String ARCHERS = "Archers";
    public static String SPEARMEN = "Spearmen";
    public static String SWORDSMEN = "Swordsmen";
    private String strategy="";
    private int totalTroops=0;

    private int largeTroopCount=0;
    private int next=0;
    private int last=0;
    private double firstWeight =0.0D;
    private double secondWeight = 0.0D;
    private double thirdWeight =0.0D;

    /**
     * the constructor is initialized wth params required for troop calculation
     * @param strategy right now now two strategy that is supported ariel or ground
     * @param totalTroops the total troops is the input parameter to calculate
     * @param firstWeight the weight to decide the max troops
     * @param secondWeight the weight to decide the next troop
     * @param thirdWeight the weight to decide the last troop
     * @param minValue The minValue of troops in a castle
     * @throws OutOfBoundException
     */
    public TroopAllocator(String strategy, int totalTroops, double firstWeight,
                          double secondWeight, double thirdWeight, int minValue) throws OutOfBoundException{
       this.strategy = strategy;
       this.totalTroops = totalTroops;
       this.firstWeight = firstWeight;
       this.secondWeight = secondWeight;
       this.thirdWeight = thirdWeight;

       if (totalTroops < minValue ) {
          throw new OutOfBoundException("Troops count has to be greater than 9.");
       }

       if ( totalTroops > Integer.MAX_VALUE) {
           throw new OutOfBoundException("Please specify an integer value");
       }

       if( firstWeight < 0.4D ) {
           throw new OutOfBoundException("Please specify an first weight as more than 40 % of troops");
       }

    }

    public int getLargeTroopCount() {
        return largeTroopCount;
    }

    public int getNext()
    {
        return next;
    }

    public int getLast() {
        return last;
    }

    /**
     * The function which calculates the troops size based on the given weight and random function
     * The firstWeight will calculate the large troop based on the strategy.
     * The other two weights will decide the rest of the troop size.
     * The function run with O(1) of algorithm complexity since the Math.random runs with O(1) complexity
     * The function will return different values each time it is run
     */
    public void  calculateTroops() {


        double min = (totalTroops * firstWeight);
        double max = min + (totalTroops - min) * secondWeight;
        double range = (max - min) + 1;
        largeTroopCount = (int) (Math.random() * range) + (int)min;
        int remaining = totalTroops - largeTroopCount;
        next = (int) (Math.random() * (remaining * thirdWeight)) + 1;
        last = remaining - next;
    }

    /**
     * This returns the result which was calculated using the calculate troops
     * @return map which has string to  no of troops mapping
     */
    public Map<String,Integer> getTroops() {

        Map<String,Integer> result = new HashMap<String,Integer>();

        if(strategy.equals(AERIAL) ) {
            result.put(ARCHERS,largeTroopCount);
            result.put(SWORDSMEN,last);
            result.put(SPEARMEN,next);
       }
        else if ( strategy.equals(GROUND)) {
            result.put(SWORDSMEN,largeTroopCount);
            result.put(SPEARMEN,last);
            result.put(ARCHERS,next);
        }
        return result;
    }


}
