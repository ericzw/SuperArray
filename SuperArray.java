public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        this(10);
    }

    public SuperArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity of " + initialCapacity + " cannot be negative");
        }

        data = new String[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(String element) {
        if (size >= data.length) {
            resize();
        }
        data[size] = element;
        size++;
        return true;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index of " + index + " is not in range of the SuperArray");
        }

        String prev = element;
        String tmp;
        size++;
        for (int i = index; i < size; i++) {
            tmp = data[i];
            data[i] = prev;
            prev = tmp;
        }
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index of " + index + " is not in range of the SuperArray");
        }

        String toRemove = data[index];
        for (int i = index; i < size; i++) {
            System.out.println(data[i]);
            data[i] = data[i + 1];
        }
        size--;
        return toRemove;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index of " + index + " is not in range of the SuperArray");
        }

        return data[index];
    }

    public String set(int index, String element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index of " + index + " is not in range of the SuperArray");
        }

        String replaced = data[index];
        data[index] = element;
        return replaced;
    }

    public void resize() {
        String[] original = data;
        data = new String[original.length * 2 + 1];
        for (int i = 0; i < original.length; i++) {
            data[i] = original[i];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        data = new String[10];
        size = 0;
    }

    public String toString() {
        if (size == 0)
            return "[]";
        String result = "[" + data[0];
        for (int i = 1; i < size; i++) {
            result += ", " + data[i];
        }
        return result + "]";
    }

    public boolean contains(String s) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(s))
                return i;
        }
        return -1;
    }

    public String[] toArray() {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = data[i];
        }
        return arr;
    }

    public int lastIndexOf(String value) {
        for (int i = size - 1; i > 0; i--) {
            if (data[i].equals(value))
                return i;
        }
        return -1;
    }

    public boolean equals(SuperArray other) {
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }
}