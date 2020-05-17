package test;

import src.Solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SolutionsTest {

    private Solutions sol;

    @BeforeEach
    public void setup() {
        System.out.println("Started testing...");
        sol = new Solutions();
    }

    @AfterAll
    public static void finish() {
        System.out.println("All tests finished.");
    }

    @Test
    public void firstUniqCharTest() {
        assertEquals(1, sol.firstUniqChar("test"));
        assertEquals(0, sol.firstUniqChar("leetcode"));
        assertEquals(-1, sol.firstUniqChar("leetcodelcdto"));
    }

    @Test
    public void twoSumTest() {
        assertArrayEquals(new int[] {0,1}, sol.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {0,3}, sol.twoSum(new int[]{2, 7, 3, 24}, 26));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, sol.lengthOfLongestSubstring(" "));
        assertEquals(2, sol.lengthOfLongestSubstring("aab"));
        assertEquals(2, sol.lengthOfLongestSubstring("abb"));
        assertEquals(2, sol.lengthOfLongestSubstring("abba"),"abba");
    }

    @Test
    public void majorityElementTest() {
        assertEquals(3, sol.majorityElement(new int[]{3,2,3}));
        assertEquals(2, sol.majorityElement(new int[]{2,2,1,1,1,2,2}));
        assertEquals(1, sol.majorityElement(new int[]{1}));
    }

    @Test
    public void isPerfectSquareTest() {
        assertEquals(true, sol.isPerfectSquare(25));
        assertEquals(true, sol.isPerfectSquare(2));
        assertEquals(true, sol.isPerfectSquare(0));
        assertEquals(true, sol.isPerfectSquare(1));
        assertEquals(false, sol.isPerfectSquare(3));
        assertEquals(true, sol.isPerfectSquare(46340*46340));
        assertEquals(false, sol.isPerfectSquare(90));
    }

    @Test
    public void findJudgeTest() {
        assertEquals(-1, sol.findJudge(4,new int[][]{}));
        assertEquals(1, sol.findJudge(1,new int[][]{}));
        assertEquals(2, sol.findJudge(2,new int[][]{{1,2}}));
        assertEquals(3, sol.findJudge(3,new int[][]{{1,3},{2,3}}));
        assertEquals(-1, sol.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        assertEquals(-1, sol.findJudge(3,new int[][]{{1,2},{2,3}}));
        assertEquals(3, sol.findJudge(4,new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
        assertEquals(-1, sol.findJudge(4,new int[][]{{1,2},{3,2},{1,3},{4,1},{2,1},{2,3},{4,2},{3,4},{2,4}}));  
    }

    @Test
    public void findAnagramsTest() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(0,1,2)), sol.findAnagrams("abab","ab"));
        assertEquals(new ArrayList<Integer>(Arrays.asList(0,6)), sol.findAnagrams("cbaebabacd","abc"));
    }

}