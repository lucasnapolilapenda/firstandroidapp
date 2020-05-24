package com.google.codelabs.mdc.java.myatm.Controller;

public class Deposit implements Calculations {

    @Override
    public int [] transaction(int des, int src, int tran) {
        int [] arr = {des,src};
        if (src>=tran) {
            arr[0] = des + tran;
            arr[1] = src - tran;
        }
        return arr;
    }
}
