package com.ky.camibrumar.charttest2;

public class Pair {
    private final float key;
    private final float value;

    public Pair(float aKey, float aValue)
    {
        key   = aKey;
        value = aValue;
    }

    public float key()   { return key; }
    public float value() { return value; }

}
