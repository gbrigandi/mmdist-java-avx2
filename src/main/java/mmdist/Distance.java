package mmdist;

public class Distance {

    public static int fullDistance(int[] a, int[] b, int len) {
        int d = 0;
        for (int i = 0; i < len; i++) {
            int t = a[i] - b[i];
            d += t * t;
        }
        return d;
    }

}
