package io.algoexpert.medium;

public class ValidStartingCity {

    // O(n) time and O(1) space
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = fuel.length;
        int milesRemaining = 0;
        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCityCandidate = 0;
        for (int i = 1; i < distances.length; i++) {
            milesRemaining += fuel[i - 1] * mpg - distances[i - 1];

            if (milesRemaining < milesRemainingAtStartingCityCandidate) {
                indexOfStartingCityCandidate = i;
                milesRemainingAtStartingCityCandidate = milesRemaining;
            }
        }
        return indexOfStartingCityCandidate;
    }

    public static void main(String[] args) {
        int[] distances = new int[]{5, 25, 15, 10, 15};
        int[] fuels = new int[]{1, 2, 1, 0, 3};
        int mpg = 10;

        System.out.println("The Valid Starting City is: " + validStartingCity(distances, fuels, mpg));
    }
}
