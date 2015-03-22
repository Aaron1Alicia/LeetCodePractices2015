package edu.nyu.yaowang.leetcode.ood;

import java.util.Iterator;

/**
 * Created by Yao on 3/9/15.
 * 这道是Cracking the coding interview Java 那章的最后一道题, 典型的OOD，很有意思
 *
 */
public class CircularArray<T> implements Iterable<T> {

    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[])new Object[size];
    }

    private int convert(int index) {
        index = index>=0 ? index: index+items.length;
        return (head+index)%items.length;
    }


    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int index) {
        if(index<0 || index>items.length) {
            throw new java.lang.IndexOutOfBoundsException(String.valueOf(index));
        }

        return items[convert(index)];
    }

    public void set(int index, T item) {
        if(index<0 || index>items.length) {
            throw new java.lang.IndexOutOfBoundsException(String.valueOf(index));
        }

        items[convert(index)] = item;
    }


    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<T> implements Iterator<T> {
        int current = -1;
        private T[] _items;


        public CircularArrayIterator(CircularArray<T> array) {
            this._items = array.items;
        }

        @Override
        public boolean hasNext() {
            return current< items.length -1;
        }

        @Override
        public T next() {
            current++;

            return _items[convert(current)];

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }
    }


    public static void main(String[] args) {
       CircularArray<String> test = new CircularArray<String>(2);
        test.set(0, "0");
        test.set(1, "1");

        for(String s: test) {
            System.out.println(s);
        }

        test.rotate(1);

        for(String s: test) {
            System.out.println(s);
        }
    }
}
