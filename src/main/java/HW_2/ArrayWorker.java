package HW_2;

public class ArrayWorker {
    public static int[] generateArray(Integer i) {
        int[] list = new int[i];
        for (int j = 0; j < i; j++) {
            list[j] = ((int) Math.round(Math.random() * 100));
        }
        return list;
    }

    public static void printArray(int[] arrayList) {
        System.out.println("Сгенерирован массив: ");
        for (int i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void findEven(int[] arrayList) {
        System.out.println("Массив с четными значениями: ");
        int count = 0;
        for (int i : arrayList) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("Количество четных значений: " + count);
        System.out.println();
    }

    public static void findDifferenceBetweenSmallestAndBiggest(int[] arrayList) {
        int min = arrayList[0];
        int max = arrayList[0];
        for (int i : arrayList) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        System.out.println("Разница между максимальным и минимальным значениями: " + (max - min));
    }

    public static boolean isDoubleZerosTogether(int[] arrayList) {
        for (int i = 0; i < arrayList.length - 1; i++) {
            if (arrayList[i] == 0 && arrayList[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
