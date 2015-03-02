package org.uva.student.calinwouter.qlqls.qls.model.helper;

public class Tuple<T, U> {
    private final T lTuple;
    private final U rTuple;

    public final T getLeftTuple() {
        return lTuple;
    }

    public final U getRightTuple() {
        return rTuple;
    }

    public Tuple(T lTuple, U rTuple) {
        this.lTuple = lTuple;
        this.rTuple = rTuple;
    }

}
