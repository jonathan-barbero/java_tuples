package ar.com.job.java_tuples;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class TP1<C1> implements TP {

    public static final int LENGTH = 1;

    public final C1 f1;

    public TP1(final C1 f1) {
        this.f1 = f1;
    }

    public static <C> TP1<C> create(final C f1) {
        return new TP1<>(f1);
    }

    public C1 getF1() {
        return f1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TP1)) return false;
        TP1<?> tp1 = (TP1<?>) o;
        return Objects.equals(f1, tp1.f1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f1);
    }

    @Override
    protected TP1<C1> clone() throws CloneNotSupportedException {
        super.clone();
        return new TP1<>(this.f1);
    }

    @Override
    public String toString() {
        return "TP1[" +
                "f1=" + f1 +
                ']';
    }

    @Override
    public int length() {
        return LENGTH;
    }

    @Override
    public List toList() {
        return Collections.singletonList(f1);
    }

    @Override
    public Iterator<C1> iterator() {
        return toList().iterator();
    }
}
