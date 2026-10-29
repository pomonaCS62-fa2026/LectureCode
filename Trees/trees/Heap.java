package trees;

import java.util.ArrayList;
import java.util.List;

public class Heap <E extends Comparable<E>> {
	private ArrayList<E> data = new ArrayList<E>();
	
	public Heap() {
		// first entry is blank
		data.add(null);
	}
	
	public Heap(List<E> newData) {
		data.addAll(newData);
		
		for( int i = data.size()/2; i >= 1; i-- ) {
			sink(i);
		}
	}
	
	public E extractMax() {
		E maxVal = data.get(1);
		data.set(1, data.get(data.size()-1));
		data.remove(data.size()-1);
		sink(1);
		return maxVal;
	}
	
	private void sink(int i) {
		// if we're not a leaf
		if( left(i) < data.size() ) {
			// find the largest child
			int maxIndex = maxChildIndex(i);
			
			E current = data.get(i);
			E maxChild = data.get(maxIndex);
			
			if( maxChild.compareTo(current) > 0 ) { 
				swap(i, maxIndex);
				sink(maxIndex);
			}
		}
	}
	
	private void limitedSink(int i, int limit) {
		// if we're not a leaf
		if( left(i) < limit ) {
			// find the largest child
			int maxIndex = maxChildIndex(i);
			
			E current = data.get(i);
			E maxChild = data.get(maxIndex);
			
			if( maxChild.compareTo(current) > 0 ) { 
				swap(i, maxIndex);
				sink(maxIndex);
			}
		}
	}
	
	private int maxChildIndex(int i) {
		if( right(i) < data.size() ) {
			E leftVal = data.get(left(i));
			E rightVal = data.get(right(i));
			
			return leftVal.compareTo(rightVal) > 0 ? 
					left(i) : right(i);
		} else {
			return left(i);
		}
	}
	
	public void insert(E val) {
		data.add(val);
		swim(data.size()-1);
	}
	
	private void swim(int i) {
		if( i > 1 ) {
			E value = data.get(i);
			E parentVal = data.get(parent(i));
			
			if( value.compareTo(parentVal) > 0 ) {
				swap(i, parent(i));
				swim(parent(i));
			}
		}
	}
	
	private int left(int i) {
		return 2*i;
	}
	
	private int right(int i) {
		return 2*i + 1;
	}
	
	private int parent(int i) {
		return i/2;
	}
	
	private void swap(int f, int s) {
		E temp = data.get(f);
		data.set(f,  data.get(s));
		data.set(s, temp);
	}
	
	/*
	public ArrayList<E> heapSort(ArrayList<E> sortMe) { 		
		for(E d: sortMe) {
			insert(d);
		}
		
		for( int i = data.size()-1; i >= 2; i++ ) {
			swap(1, i); // move next largest value to back
			limitedSink(1, i); // do a sink, but stop at i+1
		}
		
		return data;
	}*/
}