package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa.toArray();
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                if (t instanceof Student) {
                    return ((Student) t).getYear() == 2;
                } else {
                    return true;
                }
            }
        };
        MyPredicate pr2 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                if (t instanceof Student) {
                    return ((Student) t).getGPA() >= 4;
                } else {
                    return true;
                }
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    return ((Student) o1).getSurname().charAt(0) -
                            ((Student) o2).getSurname().codePointAt(0);
                }
                return 0;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                if(t instanceof Student){
                    return ((Student) t).getSurname() + " " +((Student) t).getName();
                }
                return 2 * ((Integer) t);
            }
        };




        SmartArray sa = new BaseArray(students);
        sa = new DistinctDecorator(sa);
        sa = new FilterDecorator(sa,pr);
        sa = new FilterDecorator(sa,pr2);
        sa = new SortDecorator(sa,cmp);
        sa = new MapDecorator(sa,func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
