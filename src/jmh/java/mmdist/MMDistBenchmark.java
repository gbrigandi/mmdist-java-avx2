package mmdist;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class MMDistBenchmark {

     static int[] a = new int[8 * 18];
     static int[] b = new int[8 * 18];
 
    static {
        for (int i = 0; i < a.length; i++) {
            // fill the first 144 bytes with a random value between 0 and 255
            if (i < 144) {
                a[i] = (int) (Math.random() * 255);
                b[i] = (int) (Math.random() * 255);
            } else {
                // fill the rest with 0
                a[i] = (int) 0;
                b[i] = (int) 0;
            }
            
        }
    }

    @Benchmark
    public void mmdistNoSimd(Blackhole bh) {
        bh.consume(Distance.fullDistance(MMDistBenchmark.a, MMDistBenchmark.b, MMDistBenchmark.a.length));
    }

    @Benchmark
    public void mmdistWithSimd(Blackhole bh) {
        bh.consume(DistanceAvx2.fullDistance(MMDistBenchmark.a, MMDistBenchmark.b, MMDistBenchmark.a.length));
    }

}