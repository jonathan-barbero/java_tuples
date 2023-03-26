package ar.com.job.java_tuples.comparator;

import ar.com.job.java_tuples.TP1;

import java.util.Comparator;

public class TP1Comparator<C1 extends Comparable<C1>> implements Comparator<TP1<C1>> {
    public static <C1 extends Comparable<C1>> int compareTP1(TP1<C1> o1, TP1<C1> o2) {
        if (null == o1 || null == o2) throw new NullPointerException("Unsupported comparation to null for TP1");
        if (o1 == o2) return 0;
        return null != o1.f1 ? o1.f1.compareTo(o2.f1) : o2.f1.compareTo(o1.f1);
    }

    @Override
    public int compare(TP1<C1> o1, TP1<C1> o2) {
        return TP1Comparator.compareTP1(o1, o2);
    }
}
