package com.google.codelabs.mdc.java.myatm.Controller;

public class Withdrawal implements Calculations {

    @Override
    public int [] transaction(int des, int src, int tran) {
        int [] arr = {des,src};
        if (src>=tran && src>1000) {
            arr[0] = des + tran;
            arr[1] = src - tran;
        }
        return arr;
    }
}
