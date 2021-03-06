package com.leetcode.string;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by perl on 2019/7/30.
 *
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:   "tree"
 * Output:  "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 *
 * Input:   "cccaaa"
 * Output:  "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 *
 * Input:   "Aabb"
 * Output:  "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()){
            char cur = heap.remove();
            for (int i = 0 ; i < map.get(cur); i++){
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(SortCharactersByFrequency.frequencySort("tree"));
        System.out.println(SortCharactersByFrequency.frequencySort("cccaaa"));
        System.out.println(SortCharactersByFrequency.frequencySort("Aabb"));
    }
}
