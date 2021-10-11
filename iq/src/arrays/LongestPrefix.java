package arrays;

import java.util.Arrays;

// Given a set of strings, find the longest common prefix.
// Stings can't have digits or special characters.
public class LongestPrefix {
    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("Longest prifox: " + findLongestPrefix(arr));
    }

    private static String findLongestPrefix(String[] arr) {
        StringBuffer sb = new StringBuffer();

        if (arr.length == 0) sb.append("Empty array.");
        if (arr.length == 1) sb.append(arr[0]);

        // Sort array. The shortest string will be the first.
        Arrays.sort(arr);

        // Walk all arrays starting at position arr[0].length - 1. Compare chars. Once different, the longest
        // prefix is found.

        int pos = arr[0].length() - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(pos) != arr[i + 1].charAt(pos)) {
                break;
            }
        }

        return arr[0].substring(0, pos);
    }
}
