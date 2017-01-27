package ua.edu.ucu.smartarr;

import java.util.Objects;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        int count = size();

        count = 0;

        for(int i =0;i<count;i++){
            for(int j = i+1;j<count;j++){
                if(arr[i].equals(arr[j])){
                    int shiftLeft = j;
                    for(int k = j+1;k<count;k++,shiftLeft++){
                        arr[shiftLeft] = arr[k];
                    }
                    count--;
                    j--;
                }
            }
        }
        Object[] newArr = new Object[count];
        for(int i = 0;i<count;i++){
            newArr[i] = arr[i];
        }


        return newArr;
    }

    @Override
    public String operationDescription() {

        return "Deleting elements duplicates";
    }

    @Override
    public int size() {
        Object[] arr = smartArray.toArray();
        int length = arr.length;
        System.out.println(length);
        for(int i = 0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(j!=i){
                    if(arr[i].equals(arr[j])){
                        length = length-1;
                    }
                }
            }
        }
        System.out.println(length);
        return length;
    }
}
