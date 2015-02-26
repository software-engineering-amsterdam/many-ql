package com.klq.logic.expression.util;

/**
 * Created by Timon on 24.02.2015.
 */
public class Pair<R> {
    private final R left;
    private final R r;

    public Pair(R left, R r){
        this.left = left;
        this.r = r;
    }

    public R getLeft() {
        return left;
    }

    public R getRight() {
        return r;
    }
}
