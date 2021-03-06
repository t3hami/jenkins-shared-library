package com.nisum.devops

public class Sample {
    private int x;
    private int y;

    public Sample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Continuation Passing Style (CPS)
    @NonCPS
    public String toString() {
        return "Sample{" + "x=" + x + ", y=" + y + '}';
    }
}
