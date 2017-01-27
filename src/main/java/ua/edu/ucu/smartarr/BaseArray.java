package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    Object[] intArr;
    public BaseArray(Object[] intArr){
        this.intArr = Arrays.copyOf(intArr, intArr.length);
    }

    @Override
    public Object[] toArray() {
        return intArr;
    }

    @Override
    public String operationDescription() {
        return "No operations are made";
    }

    @Override
    public int size() {
        return intArr.length;
    }
}

