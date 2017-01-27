package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    protected MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray,MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        int count = size();
        Object[] newArr = new Object[count];
        count = 0;
        for(int i= 0; i < arr.length; i++){
            if(predicate.test(arr[i])){
                newArr[count] = arr[i];
                count++;
            }
        }

        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Deleting elements that do not satisfy predicate";
    }

    @Override
    public int size() {
        Object[] arr = smartArray.toArray();
        int length = 0;
        for(int i= 0; i < arr.length; i++){
            if(predicate.test(arr[i])){
                length ++;
            }
        }
        return length;
    }
}
