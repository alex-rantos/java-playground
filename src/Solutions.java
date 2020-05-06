package src;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solutions {

    public static void main(String[] args) {
        
    }
    /* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1. */
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len <= 0) return -1;
        LinkedHashMap<Character, Integer> hMap = new LinkedHashMap<Character, Integer>((int) Math.round(len/1.5));
        char c;
        for (int i = 0; i < len; i++ ){
            c = s.charAt(i);
            if (hMap.containsKey(c)) {
                hMap.put(c, -1);
            } else {
                hMap.put(c, i);
            }
        }
        for (int v: hMap.values()) {
            if ( v != -1) {
                return v;
            }
        }
        return -1;
    }
    public int firstUniqCharOptimal(String s){
        int res = Integer.MAX_VALUE;
        
        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);
            
            if(index != -1 && index == s.lastIndexOf(c))
                res = Math.min(res, index);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.*/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[]{map.get(remaining),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};        
    }

    /* Given a string, find the length of the longest substring without repeating characters. */
    public int lengthOfLongestSubstring(String s) {
        int max = 0, begin = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for (int i = 1; i <= s.length(); i++) {
            if (map.containsKey(s.charAt(i - 1))) {
                begin = Math.max(map.get(s.charAt(i - 1)),begin);
            }
            max = max >= (i - begin) ? max : (i - begin);
            map.put(s.charAt(i - 1), i);
        }
        return max;
        
    }

    /*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.*/
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0, ans = 0;
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.merge(num, 1, Integer::sum);
                if (map.get(num) > max) {
                    ans = num;
                    max = map.get(num);
                }
            } else {
                map.put(num,1);
                if (max == 0) {
                    max = 1;
                    ans = num;
                }
            }
        }
       return ans; 
    }
}