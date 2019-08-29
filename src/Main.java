package com.company;
/**
 * метод, который возвращает массив с простыми числами от 1 до 100.
 * метод, который печатает этот массив
 * создать массив со временами заполнения числами от 2 до 1000, 2 до 2000...2 до 10000.
 * сохранить его в csv файл, выгрузть его  в эксель, и построить график зависимости времени от количества простых чисел
 * создать массив с -1, заполнить его временами работы 2 до 1000, 2 до 2000...2 до 10000. создать новый массив из не -1.
 * вынести это в метод (метод, который возвращает массив с временами) и распечатать в мэйне.
 * сохранять шаги в гите.
 * придумать задачу с десятью простыми шагами и соxранить каждый шаг в гит.
 */
public class Main {

    public static void main(String[] args) {
        printMassivProstyhChisel(10000);
        System.out.println();
//        timeFoundProstyhChisel(1000, 200);
        int chislo = 1000;
        int step = 50;
        System.out.println("Массив с временем нахождения простых чисел от 1 до " + chislo + " с шагом " + step);
        long [] newTimeFoundProstyhChisel = timeFoundProstyhChisel(1000,50);
        for (int i = 0; i < newTimeFoundProstyhChisel.length; i ++) {
            System.out.print(newTimeFoundProstyhChisel[i] + " ");
        }
        System.out.println();
        }
        public static long[] timeFoundProstyhChisel (int chislo, int step) {
        int count = 0;
        long[] massivTime = new long[chislo];
        for (int i = 0; i < massivTime.length; i++) {
            massivTime[i] = -1;
        }
        for (int i = 0; i < chislo; i += step) {
            long timeStart = System.currentTimeMillis();
            massivProstyhChisel(i);
            long timeFinish = System.currentTimeMillis();
            System.out.println("Время работы программы " + (timeFinish - timeStart));
            massivTime[i] = timeFinish - timeStart;
            count = count + 1;
        }
            long[] newMassiveTime = new long[count];
            int b = 0;
            for (int i = 0; i < chislo; i++) {
                if (massivTime[i] != -1) {
                    newMassiveTime[b] = massivTime[i];
                    b = b + 1;
                }
            }

        return newMassiveTime;
        }
    public static void printMassivProstyhChisel(int chislo) {
        int [] a = massivProstyhChisel(chislo);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] massivProstyhChisel(int chislo) {
        int count = 0;
        int[] massiv = new int[chislo];
        for (int i = 2; i < chislo; i++) {
            int b = 0;
            for (int a = 2; a < i; a++) {
                if (i % a == 0) {
                    b = b + 1;
                }
            }
            if (b == 0) {
                massiv[i] = i;
//                System.out.print(i + " ");
                count = count + 1;
            }
//            System.out.println(massiv[i]);
        }
        System.out.println("количество простых чисел от 1 до " + chislo + " равно " + count);
        int[] massivProstyh = new int[count];
        int b = 0;
        for (int i = 0; i < chislo; i++) {
            if (massiv[i] > 0) {
                massivProstyh[b] = massiv[i];
//                System.out.print(massivProstyh[b] + " ");
                b = b + 1;
            }
        }
//        for (int i = 0; i < count; i++) {
//            System.out.print(massivProstyh[i] + " ");
//        }
        System.out.println();
        return massivProstyh;
    }
}
