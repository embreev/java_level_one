package ru.breev.se;

public class Variable {
    public static void main(String[] args) {
        //примитивные типы
        final int xi = 5;
        final int yi = 7;
        final int zi = xi + yi;
        System.out.println(zi);

        final float xf = 0.5F;
        final float yf = 2.6F;
        final float zf = xf / yf;
        System.out.println(zf);

        final byte xb;
        xb = 10;
        final byte zb;
        zb = xb;
        System.out.println(zb);

        final long xl = 650000000L;
        System.out.println(xl);

        final short xs = 100;
        System.out.println("xs = " + xs);

        final double xd = 100.56D;
        System.out.println(xd);

        final char a = 'a';
        System.out.println(a);

        //ссылочные типы
        final String as = "qwery";
        final String bs = "asdf";
        System.out.println(as + bs);

        final Integer xI = 100;
        final Integer yI = 100;
        boolean res = xI.equals(yI);
        if (res) {
            System.out.println("xI = yI");
        }
        else {
            System.out.println("yI != xI");
        }

        //и т.д. для каждого примитивного типа есть ссылочный тип в виде одноименного класса
    }
}
