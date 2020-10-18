package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    public static void main(String[] args) {
        /* LC1197. Minimum Knight Moves
        System.out.println(minimumKnightMoves(0, 0, 5, 5));
         */
    }

    // LC1197. Minimum Knight Moves, bfs
    public static int minimumKnightMoves(int x1, int y1, int x2, int y2) {
        int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        x1 = Math.abs(x1);
        x2 = Math.abs(x2);
        y1 = Math.abs(y1);
        y2 = Math.abs(y2);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});
        Set<String> visited = new HashSet<>();
        visited.add(x1+ "," + y1);
        int minimumSteps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] currentPosition = queue.remove();
                int currentX = currentPosition[0];
                int currentY = currentPosition[1];
                if (currentX == x2 && currentY == y2) {
                    return minimumSteps;
                }
                for (int[] d: DIRECTIONS) {
                    int newX = currentX + d[0];
                    int newY = currentY + d[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        queue.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            minimumSteps++;
        }
        return minimumSteps;
    }
}
