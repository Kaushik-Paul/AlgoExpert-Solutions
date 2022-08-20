package io.algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static String tournamentWinner(String[][] strings, int[] winner) {
        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int winnerIdx = winner[i];
            if (winnerIdx == 1) {
                if (score.containsKey(strings[i][0])) {
                    score.replace(strings[i][0], score.get(strings[i][0]) + 1);
                } else {
                    score.put(strings[i][0], 1);
                }
            } else if (winnerIdx == 0) {
                if (score.containsKey(strings[i][1])) {
                    score.replace(strings[i][1], score.get(strings[i][1]) + 1);
                } else {
                    score.put(strings[i][1], 1);
                }
            }
        }
        String bestTeam = "";
        int bestScore = 0;
        for (Map.Entry<String, Integer> mapElement : score.entrySet()) {
            String  team = mapElement.getKey();
            int teamScore = mapElement.getValue();
            if (teamScore > bestScore) {
                bestTeam = team;
            }
        }
        return bestTeam;
    }

    public static void main(String[] args) {
        String[][] competitions = new String[][]{
                {"HTML", "C#"},
                {"C#", "PYTHON"},
                {"PYTHON", "HTML"}
        };
        int[] winners = new int[]{0, 0, 1};

        System.out.println("The best team is: " + tournamentWinner(competitions, winners));
    }
}
