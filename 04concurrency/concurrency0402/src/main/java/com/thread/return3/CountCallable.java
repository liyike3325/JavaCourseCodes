package com.thread.return3;

import java.util.concurrent.Callable;

public class CountCallable implements Callable<Integer> {

    private int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    private int sum() {
        return fibo(36);
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }
}
