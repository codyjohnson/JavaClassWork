package Sep_26_2025_2;

import java.util.Comparator;

public class Helper<T> implements Comparator<T> {


    public void bubbleSort(T[] array) {

        if  (array == null || array.length == 0) {
            return;
        }

        T temp;

        boolean sorted = false;
        int swaps = 0;

        do {

            for (int i = 0; i < array.length - 1; i++) {
                if (compare(array[i], array[i + 1]) > 0) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swaps++;
                }
            }
            if (swaps == 0) {
                sorted = true;
            }
            swaps = 0;

        } while (!sorted);
    }

    @Override
    public int compare(T o1, T o2) {
        if (o1.getClass().equals(Integer.class)) {
            return (Integer)o1 - (Integer)o2;
        } else if (o1.getClass().equals(String.class)) {
            return ((String) o1).compareTo((String)o2);
        } else if (o1.getClass().equals(Double.class)) {
            if ((Double) o1 > (Double) o2) {
                return 1;
            } else {
                return -1;
            }
        } else if (o1.getClass().equals(Employee.class)) {
            return ((Employee) o1).getAge() - ((Employee) o2).getAge();
        }

        return 0;
    }

}
