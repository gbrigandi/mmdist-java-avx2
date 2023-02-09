package mmdist;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;
import jdk.incubator.vector.VectorOperators;

public class DistanceAvx2 {

    private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    public static int fullDistance(int[] a, int[] b,int len) {
        var upperBound = SPECIES.loopBound(len);
        var i = 0;
        var e = 0;

        for (; i < upperBound; i += SPECIES.length()) {
            var va = IntVector.fromArray(SPECIES, a, i);
            var vb = IntVector.fromArray(SPECIES, b, i);
            var vc = va.sub(vb);
            var vd = vc.mul(vc);
            e = e + vd.reduceLanes(VectorOperators.ADD);
        }

        return e;
    }

}
