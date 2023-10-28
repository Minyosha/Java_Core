package HW_2;

public class ArrayModel {
    public int [] arrayList;
    int arraySize;

    public ArrayModel(int arraySize) {
        this.arraySize = arraySize;
        this.arrayList = ArrayWorker.generateArray(arraySize);
    }
}