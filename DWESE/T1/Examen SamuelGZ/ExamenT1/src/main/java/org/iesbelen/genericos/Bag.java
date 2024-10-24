package org.iesbelen.genericos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Bag<T> {
    private List<T> bolsa;

    public Bag() {
        this.bolsa = new ArrayList<>();
    }

    public boolean add(T e) {
        return this.bolsa.add(e);
    }

    public boolean add(T e, int n) {
        boolean added = false;

        for (int i = 0; i < n; i++) {
            added = this.bolsa.add(e);
        }
        return added;
    }

    public int getCount(T e) {
        int counter = 0;

        for (T t : this.bolsa) {
            if (e.equals(t)) {
                counter++;
            }
        }
        return counter;
    }

    public boolean remove(T e) {
        return this.bolsa.remove(e);
    }

    public boolean remove(T e, int n) {
        boolean removed = false;

        for (int i = 0; i < n; i++) {
            removed = this.bolsa.remove(e);
        }
        return removed;
    }

    public int size() {
        return this.bolsa.size();
    }

    public HashSet<T> uniqueSet() {
        return new HashSet<>(bolsa);
    }

    @Override
    public String toString() {
        String res = "\t";

        for (T e : bolsa) {
            res += e.toString() + "\n\t";
        }
        return res;
    }
}
