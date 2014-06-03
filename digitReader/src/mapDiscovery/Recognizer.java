package mapDiscovery;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Recognizer {
    
    private static List<Pair> samples;

    /*static Double[] s#0 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s#1 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};*/
    static Double[] s00 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d};
    static Double[] s01 = {0.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           1.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           1.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s02 = {0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s03 = {0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s04 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s05 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d};
    static Double[] s06 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d};
    static Double[] s10 = {0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d};
    static Double[] s11 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s12 = {0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s13 = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d};
    static Double[] s14 = {0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d};
    static Double[] s20 = {0.0d, 1.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 1.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s21 = {0.0d, 0.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 1.0d};
    static Double[] s30 = {0.0d, 0.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s31 = {0.0d, 1.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 0.0d, 0.0d};
    static Double[] s32 = {1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 
                           1.0d, 1.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s33 = {0.0d, 0.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s34 = {0.0d, 1.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 0.0d, 0.0d};
    static Double[] s40 = {0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           1.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d};
    static Double[] s41 = {0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d};
    static Double[] s50 = {1.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 1.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s51 = {0.0d, 0.0d, 1.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s60 = {0.0d, 0.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s61 = {0.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s70 = {0.0d, 0.0d, 1.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 0.0d};
    static Double[] s71 = {1.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 0.0d};
    static Double[] s80 = {0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d,
                           1.0d, 0.0d, 1.0d, 0.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 0.0d, 0.0d};
    static Double[] s81 = {0.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 1.0d, 1.0d, 1.0d, 0.0d};
    static Double[] s90 = {0.0d, 0.0d, 1.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 1.0d};
    static Double[] s91 = {0.0d, 0.0d, 0.0d, 1.0d, 0.0d,
                           0.0d, 0.0d, 1.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 1.0d, 1.0d,
                           0.0d, 0.0d, 0.0d, 0.0d, 1.0d,
                           0.0d, 0.0d, 1.0d, 1.0d, 1.0d};
    
    private static class Pair {
        public Double[] dims; //dimentions

        public int digit;
        
        public Pair(Double[] dimss, int digits) {
            dims = dimss;
            digit = digits;
        }
    }
    
    private static class DoublePair implements Comparable{
        public Double len; //dimentions

        public int digit;
        
        public DoublePair(double lens, int digits) {
            len = lens;
            digit = digits;
        }

        @Override
        public int compareTo(Object o) {
            final int BEFORE = -1;
            final int EQUAL = 0;
            final int AFTER = 1;
            
            DoublePair odp = (DoublePair)o;
            
            if (this.len < odp.len) return BEFORE;
            if (this.len == odp.len) return EQUAL;
            return AFTER;
        }
    }

    private static double euclid(Double[] x, Double[] y) {
        double length = 0.0d;
        for (int i = 0; i < x.length; i++) {
            length += Math.pow(Math.abs((double)x[i] - (double)y[i]), 2.0d);
        }
        return Math.sqrt(length);
    }
    
    private static void init() {
        samples = new LinkedList<>();
        samples.add(new Pair(s00, 0));
        samples.add(new Pair(s01, 0));
        samples.add(new Pair(s02, 0));
        samples.add(new Pair(s03, 0));
        samples.add(new Pair(s04, 0));
        samples.add(new Pair(s05, 0));
        samples.add(new Pair(s06, 0));
        
        samples.add(new Pair(s10, 1));
        samples.add(new Pair(s11, 1));
        samples.add(new Pair(s12, 1));
        samples.add(new Pair(s13, 1));
        samples.add(new Pair(s14, 1));
        
        samples.add(new Pair(s20, 2));
        samples.add(new Pair(s21, 2));
        
        samples.add(new Pair(s30, 3));
        samples.add(new Pair(s31, 3));
        samples.add(new Pair(s32, 3));
        samples.add(new Pair(s33, 3));
        samples.add(new Pair(s34, 3));
        
        samples.add(new Pair(s40, 4));
        samples.add(new Pair(s41, 4));
        
        samples.add(new Pair(s50, 5));
        samples.add(new Pair(s51, 5));
        
        samples.add(new Pair(s60, 6));
        samples.add(new Pair(s61, 6));
        
        samples.add(new Pair(s70, 7));
        samples.add(new Pair(s71, 7));
        
        samples.add(new Pair(s80, 8));
        samples.add(new Pair(s81, 8));
        
        samples.add(new Pair(s90, 9));
        samples.add(new Pair(s91, 9));
    }
    
    static int recognize(Double[] image) {
        init();
        List<DoublePair> lengths = new LinkedList<>();
        for (int i=0; i<samples.size(); i++) {
            lengths.add(new DoublePair(euclid(image, samples.get(i).dims), samples.get(i).digit));
        }
        Collections.sort(lengths);
        int[] digits = {0,0,0,0,0,0,0,0,0,0};
        if (lengths.get(0).len == 0.0d) return lengths.get(0).digit;
        for (int i=0; i<lengths.size(); i++) {
            int ndig = lengths.get(i).digit;
            digits[ndig]++;
            if (digits[ndig] == 2) return ndig;
        }
        return 3;
    }
}
