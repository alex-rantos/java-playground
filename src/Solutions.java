package src;

import java.util.LinkedHashMap;

public class Solutions {

    public static void main(String[] args) {
        
    }
    
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
}