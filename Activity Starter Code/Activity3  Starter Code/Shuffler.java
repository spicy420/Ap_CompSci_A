/**
 * This class provides a convenient way to test shuffling methods.
 */

import java.util.*;
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 1; //Number of shuffles to be implemented
    private static final int VALUE_COUNT = 4; //number of values needed to shuffle

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int shuffled[] = new int[values.length];
        int halfStack = ((values.length) + 1) / (2);
        int[] half1 = new int[halfStack];
        int[] half2 = new int[((values.length) / 2)];
        
        int currPos = 0; 
        int k = 0;
        for (k = 0; k<halfStack ;k++){
            shuffled[currPos] = values[k];
            currPos += 2;
        }
        currPos = 1;
        for (; k < values.length; k++){
            shuffled[currPos] = values[k];
            currPos += 2;
        }       
        
        for ( k=0; k<values.length; k++){
          values[k] = shuffled[k];
        }
        
    }

    public static void selectionShuffle(int[] values) {
        Random random = new Random(); 
        for(int j = values.length-1; j>0; j--){
            int x = (int)(Math.random() * (1+j));
            //set the random value from 0 to the value of j to determine the position
            int curr = values[x]; 
            //saves current value of x
            values[x] = values[j];
            values[j] = curr; 
        }
    }
}
