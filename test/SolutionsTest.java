package test;
import src.Solutions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SolutionsTest {

    private Solutions sol;

    @BeforeEach
    public void setup() {
        //System.out.println("initialized");
        sol = new Solutions();
    }

    @Test
    public void firstUniqCharTest() {
        assertEquals(1, sol.firstUniqChar("test"));
        assertEquals(0, sol.firstUniqChar("leetcode"));
        assertEquals(-1, sol.firstUniqChar("leetcodelcdto"));
    }


}