package ru.breev.se.homework8;

public class Operation {
    protected float add(float a, float b) { return a + b; }
    protected float substract(float a, float b) { return a - b; }
    protected float multiply(float a, float b) { return a * b; }
    protected float devide(float a, float b) { return (b != 0) ? a / b : b; }
}
