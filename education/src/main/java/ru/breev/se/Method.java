package ru.breev.se;

public class Method {
    private float res;

    //3
    private float calcExpression(float a, float b, float c, float d) {
        if (d != 0) res = a * (b + (c / d));
        return res;
    }

    //4
    private boolean sumExpression(int a, int b) {
        return ((a + b) > 10 && (a + b) <= 20);
    }

    //5
    public String isPositiveStr(int a) {
        if (a <= 0) return "Posivive";
        else return "Negative";
    }

    //6
    public boolean isPositiveBool(int a) {
        return (a < 0);
    }

    //7
    private void sayHello(String name) {
        System.out.printf("Hello, %s!\n", name);
    }

    //8
    private String isLeapYear(int date) {
        final boolean check = (date % 4 == 0) && (date % 100 != 0) || (date % 400 == 0);
        return check ? "Year Leap" : "Year Not Leap";
    }

    public static void main(String[] args) {

        Method res = new Method();
        //3
        System.out.println(res.calcExpression(5, 7, 9, 3));
        //4
        System.out.println(res.sumExpression(5, 7));
        //5
        System.out.println(res.isPositiveStr(3));
        //6
        System.out.println(res.isPositiveBool(-2));
        //7
        res.sayHello("Евгений");
        //8
        System.out.println(res.isLeapYear(2018));
//        for (int i=1600; i<=2018; i+=1){
//            System.out.println("Год " + i + " " + res.isLeapYear(i));
//        }
    }
}
