public class Main {
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Неверный размер массива: количество строк должно быть 4, а получено " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверный размер массива: количество столбцов в строке " + i + " должно быть 4, а получено " + array[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }
        return sum;
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n--- Демонстрация ArrayIndexOutOfBoundsException ---");
        int[] arr = new int[3];
        try {
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: ArrayIndexOutOfBoundsException");
            System.out.println("Сообщение: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "Ошибка", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = processArray(validArray);
            System.out.println("Сумма элементов корректного массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processArray(wrongSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("\nОшибка размера: " + e.getMessage());
        }

        try {
            processArray(wrongDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("\nОшибка данных: " + e.getMessage());
        }

        demonstrateArrayIndexOutOfBounds();
    }
}