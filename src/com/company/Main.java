package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * метод, который возвращает массив с простыми числами от 1 до 100.
 * метод, который печатает этот массив
 * создать массив со временами заполнения числами от 2 до 1000, 2 до 2000...2 до 10000.
 * сохранить его в csv файл, выгрузть его  в эксель, и построить график зависимости времени от количества простых чисел
 * создать массив с -1, заполнить его временами работы 2 до 1000, 2 до 2000...2 до 10000. создать новый массив из не -1.
 * вынести это в метод (метод, который возвращает массив с временами) и распечатать в мэйне.
 * сохранять шаги в гите.
 * придумать задачу с десятью простыми шагами и соxранить каждый шаг в гит.
 * 01/09 объединить метод эратосфена и метод brut force в одном проекте, выгрузить их в эксель и построить два графика.
 * паспортный стол - заполнить эксель паспортными данными сотрудников (фио, серия, номер).
 * сначала сделать по аналогии с PrimeTime для одного человека, потом сделать массив
 * добавить настройки, какие колонки нужно добавлять в csv. сначала написать метод, который принимает массив строк и строку.
 * если в массиве есть эта строка, то он возвращает тру, если нет, то фолс.
 * метод, который принимает массив служащих, имя файла (строка с названием файла, например emploee.csv) и целое число, и печатает
 * файл служащих, у которых зарплата выше этой цифры
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        printMassivProstyhChisel(10000);
//        PrintStream printer = System.out;
        PrintStream printer = new PrintStream(new File("timings.csv"));
//        printer.println();
//        timeFoundProstyhChisel(1000, 200);
        int chislo = 10_000;
        int step = 500;
//        printer.println("Массив с временем нахождения простых чисел от 1 до " + chislo + " с шагом " + step);
        long [] newTimeFoundProstyhChisel = timeFoundProstyhChisel(10_000,500);
        printer.println("число" + ";" + "время");
        for (int i = 0; i < newTimeFoundProstyhChisel.length; i ++) {
//            printer.println(( i * step) + 2 + ";" + newTimeFoundProstyhChisel[i] + " ");
//            writeLine(( i * step) + 2, newTimeFoundProstyhChisel[i], printer);
//            PrimeTime timeFound = new PrimeTime();
            PrimeTime timeFound = new PrimeTime(( i * step) + 2, newTimeFoundProstyhChisel[i]);
//            timeFound.number = ( i * step) + 2;
//            timeFound.time = newTimeFoundProstyhChisel[i];
            writeLine(timeFound, printer);
        }
        printer.println();
    }
    public static void writeLine (PrimeTime timeFound, PrintStream printer) {
       printer.println(timeFound.number + ";" + timeFound.time);
    }

    public static void writeLine (int time, long chislo, PrintStream printer)
    {
        printer.println(time + ";" + chislo);
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
