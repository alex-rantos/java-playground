package test;
import src.Solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SolutionsTest {

    private Solutions sol;

    @BeforeEach
    public void setup() {
        System.out.println("initialized".indexOf("i"));
        sol = new Solutions();
    }

    @Test
    public void firstUniqCharTest() {
        assertEquals(1, sol.firstUniqChar("test"));
        assertEquals(0, sol.firstUniqChar("leetcode"));
        assertEquals(-1, sol.firstUniqChar("leetcodelcdto"));
    }

    @Test
    public void twoSum() {
        assertArrayEquals(new int[] {0,1}, sol.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {0,3}, sol.twoSum(new int[]{2, 7, 3, 24}, 26));
    }


}