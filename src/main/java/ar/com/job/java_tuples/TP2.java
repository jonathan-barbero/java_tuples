package ar.com.job.java_tuples;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class TP2<C1, C2> implements TP {

    public static final int LENGTH = 2;

    public final C1 f1;

    public final C2 f2;

    public TP2(final C1 f1, final C2 f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public static <C1, C2> TP2<C1, C2> create(final C1 f1, final C2 f2) {
        return new TP2<>(f1, f2);
    }

    public C1 getF1() {
        return f1;
    }

    public C2 getF2() {
        return f2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TP2)) return false;
        TP2<?, ?> tp2 = (TP2<?, ?>) o;
        return Objects.equals(f1, tp2.f1) && Objects.equals(f2, tp2.f2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1, f2);
    }

    @Override
    protected TP2<C1, C2> clone() throws CloneNotSupportedException {
        super.clone();
        return new TP2<>(this.f1, this.f2);
    }

    @Override
    public String toString() {
        return "TP2[" + "f1=" + f1 + ", f2=" + f2 + ']';
    }

    @Override
    public int length() {
        return LENGTH;
    }

    @Override
    public List toList() {
        return Arrays.asList(f1, f2);
    }

    @Override
    public Iterator iterator() {
        return toList().iterator();
    }
}
