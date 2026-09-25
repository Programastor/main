import java.lang.String ;

void main() {
    //1.
    printThreeWords();
    //2.
    checkSumSign(5,-6);
    //3.
    printColor(-155);
    //4.
    compareNumbers(100,20);
    //5.
    isSumInRange(10,25);
    //6.
    isPozitive(-10);
    //7.
    isNegative(5);
    //8.
    repiter("привет",3);
    //9.
    isLeapYear(2024);
    //10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    for (int i = 0; i < array.length ; i++){
        if (array[i] == 0) array[i] = 1;
        else array[i] = 0;
    }
    //11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    int[] mas = new int[100];
    for (int i = 0 ; i < 100 ; i++){
        mas[i] = i+1;
    }
    //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    int[] massiv = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
    for (int i = 0; i < massiv.length ; i++){
        if (massiv[i] < 6) massiv[i] *=2 ;
    }
    //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    // (можно только одну из диагоналей).
    int[][] arr = new int[6][6];
    for (int i = 0; i < arr.length; i++) {
        arr[i][i] = 1;
    }
    //14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
    // каждая ячейка которого равна initialValue.
    initMas(10,10);

}
public void printThreeWords(){
    //1.
    System.out.println("Orange");
    System.out.println("Banana");
    System.out.println("Apple");

}
public void checkSumSign(int a, int b){
    int sum = a+b;
    if (sum >= 0) System.out.println("Сумма положительная");
    else System.out.println("Сумма отрицательная");
}
public void printColor(int value){
    if (value <= 0) System.out.println("Красный");
    if (value > 0 && value <= 100) System.out.println("Желтый");
    if (value > 100) System.out.println("Зеленый");
}
public void compareNumbers(int a, int b){
    if (a >= b) System.out.println("a >= b");
    if (a < b) System.out.println("a < b");
}
public boolean isSumInRange(int a,int b){
    int sum = a + b;
    return sum >= 10 && sum <= 20;
}
public void isPozitive(int num){
    if (num >= 0) System.out.println("Положительное");
    if (num < 0) System.out.println("Отрицательное");
}
public boolean isNegative(int num){
   return num < 0 ;
}
public void repiter(String str,int count){
    for (int i = 0; i < count; i++){
        System.out.println(str);
    }
}
public boolean isLeapYear(int year) {
    if (year % 400 == 0) return true;
    if (year % 100 == 0) return false;
    return year % 4 == 0;
}
public int[] initMas(int len, int initialValue){
    if (len < 0) {
        throw new IllegalArgumentException("Длина массива не может быть отрицательной");
    }
    int[] mas = new int[len];
    for (int i = 0; i < mas.length; i++) {
        mas[i] = initialValue;
    }
    return mas;
}
