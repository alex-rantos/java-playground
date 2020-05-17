package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import src.dataStructures.TreeNode;

public class Solutions {

    public static void main(String[] args) {
        
    }
    /** Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1. */
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

    /** Given an array of integers, return indices of the two numbers such that they add up to a specific target.
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

    /** Given a string, find the length of the longest substring without repeating characters. */
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

    /**Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

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

    /**
    In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
    Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
    We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
    Return true if and only if the nodes corresponding to the values x and y are cousins
    */

    private int depth = -1;
    private boolean ans = false;
    private TreeNode parent = null;
    
    public void validateNode(TreeNode parent,int depth) {
        if (this.depth == depth && parent != this.parent) {
            ans = true;
            return;
        }else if (this.depth == -1) {
            this.depth = depth;
            this.parent = parent;
        } 
    }
    
    public void searchTree(TreeNode parent, TreeNode node, int x, int y, int depth) {
        if (node.getVal() == x) {
            validateNode(parent,depth);
            return;
        } else if (node.getVal() == y) {
            validateNode(parent,depth);
            return;
        }
        
        if (node.getLeft() != null) {
            searchTree(node,node.getLeft(),x,y,depth+1);
        }
        if (node.getRight() != null) {
            searchTree(node,node.getRight(),x,y,depth+1);
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        if (root.getVal() == x || root.getVal() == y) return false;
        searchTree(null,root,x,y,0);
        return this.ans;
    }

    /** 
    Given a positive integer num, write a function which returns True if num is a perfect square else False.
    
    Note: Do not use any built-in library function such as sqrt.
    */
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1 || num == 2) return true;
        int low, high = (int) num/2;
        while (high > num / high) high = (int) high/2;
        low = high;
        high = high*high;
        for (int i=low; i<high; i++) {
            if (num == i*i) return true;
            else if (i*i > num) return false;
        }
        return false;
    }

    /**
     * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
        If the town judge exists, then:
        The town judge trusts nobody.
        Everybody (except for the town judge) trusts the town judge.
        There is exactly one person that satisfies properties 1 and 2.
        You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

        If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
     */ 
    public int findJudge(int N, int[][] trust) {
        System.out.println(trust.length);
        if (trust.length == 0) {
            if (N == 1) return 1;
            else return -1;
        }

        int judge = -1, maxVotes = 0;
        int[] a = new int[N];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            if (map.containsKey(trust[i][1])) {
                int votes = map.get(trust[i][1]) + 1;
                map.put(trust[i][1], votes);
                if (votes > maxVotes) {
                    judge = trust[i][1];
                    maxVotes = votes;
                }
            } else {
                map.put(trust[i][1], 1);
                if (1 > maxVotes) {
                    judge = trust[i][1];
                    maxVotes = Math.max(1, maxVotes);
                }
            }
            a[trust[i][0]-1] = -1; // has voted
        }
        System.out.println(judge);
        for (int i = 0; i < N; i++) {
                System.out.println(i + " : " + a[i]);
            }
        System.out.println(map);
        if (a[judge-1] == 0 && map.get(judge) == N - 1) return judge;
        else return -1;
    }   
    
    /*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s == null) return res;
        HashMap<Character,Integer> orig = new HashMap<>();
        for (char c: p.toCharArray()){
            if (orig.containsKey(c)) {
                orig.put(c, orig.get(c)+1);
            } else {
                orig.put(c, 1);
            }
        }
        HashMap<Character,Integer> temp = new HashMap<>();
        System.out.println(orig.toString());
        MyInteger added = new MyInteger(0);
        MyBoolean add = new MyBoolean(false);
        int i = 0;
        while (i < s.length()) {
            if (!orig.containsKey(s.charAt(i))) {
                this.findAnagramsHelper(temp, res, added, add, true);
                i++;
                continue;
            } else {
                if (add.getVal() == false) {
                    res.add(i);
                    add.setVal(true);
                }
                if (temp.containsKey(s.charAt(i))) {
                    int occ = temp.get(s.charAt(i)) + 1;
                    temp.put(s.charAt(i),occ);
                    if (occ > orig.get(s.charAt(i))) {
                        if (res.size() > 0) {
                            i = res.get(res.size()-1) + 1;
                        }
                        this.findAnagramsHelper(temp, res, added, add, true);
                        continue;
                    }
                } else {
                    temp.put(s.charAt(i), 1);
                }
                added.increment();
            }
            if (added.getVal() == p.length()) {
                if (orig.equals(temp)) {
                    i = res.get(res.size()-1) + 1;                        
                    this.findAnagramsHelper(temp, res, added, add, false);
                    continue;
                }
            }
            i+=1;
        }
        if (add.getVal() == true && !temp.equals(orig)) {
            res.remove(res.size() - 1);
        }
        return res;
    }

    public void findAnagramsHelper(HashMap<Character,Integer> temp,List<Integer> ans, MyInteger added, MyBoolean add, Boolean everything) {
        if (everything){
            if (add.getVal()) {
                ans.remove(ans.size() - 1);
            }
        }
        add.setVal(false);;
        temp.clear();
        added.setVal(0);
    }
}