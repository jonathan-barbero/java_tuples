package ar.com.job.java_tuples;

import java.io.Serializable;
import java.util.List;

public interface TP extends Iterable, Serializable, Cloneable {

    int length();

    List toList();
}
