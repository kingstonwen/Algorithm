package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClothingBudget {
    public static void main(String[] args) {
        int[][] clothingPacks = {{1,2,3}, {2}, {3}, {2,3}};
        int budget = 10;
        List<List<Integer>> combinations = findCombination(clothingPacks, budget);
        for(List<Integer> combin : combinations) {
            for(Integer cloth : combin) {
                System.out.print(cloth.toString() + ',');
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> findCombination(int[][] allPacks, int budget) {
        List<List<Integer>> res = new ArrayList<>();
        help(allPacks, 0, budget, res, new ArrayList<>());
        return res;
    }

    public static void help(int[][] allPacks, int packIndex, int budget, List<List<Integer>> res, List<Integer> temp) {
        if (packIndex == allPacks.length) {
            if (budget < 0) {
                return;
            } else {
                res.add(new ArrayList<Integer>(temp));
            }
        } else {
            for(int i = 0; i < allPacks[packIndex].length; i++) {
                int cost = allPacks[packIndex][i];
                temp.add(cost);
                help(allPacks, packIndex+1, budget-cost, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
