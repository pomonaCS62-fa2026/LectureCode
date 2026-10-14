package sorting;

public class InsertionSort {
	public static <E extends Comparable<E>> void insertSort(E[] a) {
        for( int i = 1; i < a.length; i++ ) {
			E current = a[i];
			int j = i-1;
			while( j >= 0 && current.compareTo(a[j]) < 0 ) {
				// move element j to element j+1
				a[j+1] = a[j];
				j--;
			}

			a[j+1] = current;
		}
    }
}
