package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Objects;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    protected MyFunction function;
    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        Object[] newArr = new Object[arr.length];
        for(int i =0;i<newArr.length;i++){
            newArr[i]=function.apply(arr[i]);
        }
        return newArr;
    }

    @Override
    public String operationDescription() {

        return "Represents every element of SmartArray as another object by using MyFunction";
    }

    @Override
    public int size() {
        Object[] arr = smartArray.toArray();
        return arr.length;
    }
}
