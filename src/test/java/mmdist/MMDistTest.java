package mmdist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MMDistTest {

    static int[] a = new int[8 * 18];
    static int[] b = new int[8 * 18];

    static {
        for (int i = 0; i < a.length; i++) {
            // fill the first 144 bytes with the index value
            if (i < 144) {
                a[i] = (int) (i & 0xff);
                b[i] = (int) ((i + 1) & 0xff);
            } else {
                // fill the rest with 0
                a[i] = (int) 0;
                b[i] = (int) 0;
            }
        }
    }

    static int[] a_rnd = new int[8 * 18];
    static int[] b_rnd = new int[8 * 18];

    static {
        for (int i = 0; i < a.length; i++) {
            // fill the first 144 bytes with a random value between 0 and 255
            if (i < 144) {     
                a_rnd[i] = (int) Math.abs(Math.random() * 255);
                b_rnd[i] = (int) Math.abs(Math.random() * 255);
            } else {
                // fill the rest with 0
                a_rnd[i] = (int) 0;
                b_rnd[i] = (int) 0;
            }
        }
    }

    @Test
    public void testMMDist() {
        assertEquals(144, Distance.fullDistance(a, b, a.length));
        assertEquals(144, DistanceAvx2.fullDistance(a, b, a.length));
        assertEquals(DistanceAvx2.fullDistance(a_rnd, b_rnd, a.length), Distance.fullDistance(a_rnd, b_rnd, a.length));
    }

}
