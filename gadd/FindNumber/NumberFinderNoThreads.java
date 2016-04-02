package gadd.FindNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class NumberFinderNoThreads {
//    private long start = 1234567890L, stop = 9876543210L;

    public NumberFinderNoThreads() {
//        go(start, stop);
    }

    protected boolean checkDifferentDigits(long numberToCheck) {
        String numberString = Long.toString(numberToCheck); // convert number to string
        char[] numberArray = numberString.toCharArray(); // convert string to array
//            Set numberSet = new HashSet<>(Arrays.asList(numberArray)); // convert array to set !!! IT IS NOT WORKING!!! (first element - is set)
        HashSet numberSet = new HashSet();
        for (char ch : numberArray) {
            numberSet.add(ch);
        }
        // all digits are differ, if lengths of array and set are equal
        return numberString.length() == numberSet.size();
    }

    protected boolean checkRule(long numberToCheck) {
        for (int i = 1; i < 10; i++) {
            if ((numberToCheck / (int) Math.pow(10, i)) % (10 - i) != 0) {
                return false;
            }
        }
        return true;
    }


    protected void go(long startNumber, long stopNumber) {
        for (long i = startNumber; i <= stopNumber; i += 10) {
            if (checkDifferentDigits(i)) {
                if (checkRule(i)) {
                    System.out.println(i);
                }

            }
        }
    }


}

