package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    protected MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        boolean flag = true;
        Object temp;
        int j;

        while(flag){
            flag = false;
            for(j=0;j<arr.length-1;j++){
                if(comparator.compare(arr[j],arr[j+1])>0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    flag = true;

                }
            }
        }
        return arr;
    }

    @Override
    public String operationDescription() {
        return "sorts elements of SmartArray by using MyComparator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }
}
