import java.util.Arrays;
import java.util.List;

public class MyList<T> {
    private T[] dB;
    private int size = 0;
    private int capacity;
    public MyList(){
        capacity = 10;
        dB = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity){
        this.capacity = capacity;
        dB = (T[]) new Object[capacity];
    }

    public int size(){
        return this.size;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(T data){
        if(size == capacity){
            int newCapacity = this.capacity * 2;
            dB = Arrays.copyOf(dB, newCapacity);
            this.capacity = newCapacity;
        }
        dB[(size++)] = data;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return dB[index];
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            return null;
        }
        T removedItem = dB[index];
        dB[index] = null;
        for(;index <= size; index++){
            set(index, dB[index + 1]);
        }
        size--;
        return removedItem;
    }

    public T set(int index, T data){
        if(index < 0 || index >= size){
            return null;
        }
        return dB[index] = data;
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            str.append(dB[i].toString());
            if(i != size - 1){
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if(data.equals(dB[i])){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if(data.equals(dB[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T[] toArray() {
        return (T[]) Arrays.copyOf(dB, size);
    }

    public void clear() {
        Arrays.fill(dB,null);
        size = 0;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            throw new IndexOutOfBoundsException();
        }
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(get(i));
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if(data.equals(dB[i])) return true;
        }
        return false;
    }
}
