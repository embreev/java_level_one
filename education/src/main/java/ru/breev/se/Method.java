package ru.breev.se;

public class Method {
    private float res;

    public static void main(String[] args) {

        Methods res = new Methods();
        //3
        System.out.println(res.expr(5, 7, 9, 3));
        //4
        System.out.println(res.sumexpr(5, 7));
        //5
        System.out.println(res.isPositiveStr(3));
        //6
        System.out.println(res.isPositiveBool(-2));
        //7
        res.hello("Евгений");
        //8
        System.out.println(res.isLeapYear(2018));
//        for (int i=1600; i<=2018; i+=1){
//            System.out.println("Год " + i + " " + res.isLeapYear(i));
//        }
    }

    //3
    private float expr(float a, float b, float c, float d) {
        if (d != 0) res = a * (b + (c / d));
        return res;
    }

    //4
    private boolean sumexpr(int a, int b) {
        return ((a + b) > 10 && (a + b) <= 20);
    }

    //5
    public String isPositiveStr(int a) {
        if (a <= 0) return "Отрицательное";
        else return "Положительное";
    }

    //6
    public boolean isPositiveBool(int a) {
        return (a < 0);
    }

    //7
    private void hello(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    //8
    private String isLeapYear(int date) {
        if ((date % 4 == 0) && (date % 100 != 0) || (date % 400 == 0)) return "Високосный";
        else return "Не високосный";
    }
}
