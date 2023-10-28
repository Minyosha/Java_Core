package HW_2;

public class Main {
    public static void main(String[] args) {
        ArrayModel firstArray = new ArrayModel(10);
        ArrayWorker.printArray(firstArray.arrayList);
        ArrayWorker.findEven(firstArray.arrayList);
        ArrayWorker.findDifferenceBetweenSmallestAndBiggest(firstArray.arrayList);
        System.out.println();
        System.out.println("Провека на нахождение двух нулей рядом:");
        System.out.println(ArrayWorker.isDoubleZerosTogether(firstArray.arrayList));
    }


}
