package ru.chedmitriy.dataTypes;

/**
 * Class Point определяет расстояние между точками - длину будущих сторон
 * @author dimCher
 * @since 22.05.2016.
 */
public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
/**
 * Метод distanceTo -  определяет расстояние между точками
 * расстояние между двумя точками есть корень квадратный из суммы квадратов разности координат.
 * @param: Math.sqrt(Math.pow(выражение, степень) + Math.pow(выражение, степень))
 * */

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow((this.x - point.x),2) + Math.pow((this.y - point.y),2));
    }
}

 class Triangle {
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
     /**
      * Метод area сначала реализует метод distanceTo,для определения длин сторон треугольника
      * @param: ab = a.distanceTo(b) - расстояние между точками a и b(или длина стороны ab)
      * @param: bc = b.distanceTo(c) - расстояние между точками b и c(или длина стороны bc)
	   @param: ac = a.distanceTo(c) - расстояние между точками a и c(или длина стороны ac)
       @param: halfPer - полупериметр треугольника
       
       @param: Area = Math.sqrt(halfPer * (halfPer-ab) * (halfPer-bc) * (halfPer-ac));
      * 
      * */
     public double area() {
            double ab = a.distanceTo(b);
            double bc = b.distanceTo(c);
            double ac = a.distanceTo(c);
            double halfPer = (ab + bc + ac) / 2;
            return Math.sqrt(halfPer * (halfPer-ab) * (halfPer-bc) * (halfPer-ac));
    }
}
/**
 * Класс maxSide определяет и выводит на экран значение стороны с наибольшей длиной
 * Метод max в качестве аргументов принимает экземпляры объекта Point
 * На основание принятых аргументов определяются значения
 * @param: ab - длина стороны ab
 * @param: bc - длина стороны bc
 * @param: ac - длина стороны ac
 * @param: maxValue - наибольшее значение
 * Для удобства сравнения вывожу значения в консоль
 * Далее использую оператор сравнения, где выбираю наибольшее значение
 * */
class MaxSide{
   public double max(Point a,Point b,Point c) {
       double maxValue = 0;
       double ab = a.distanceTo(b);
       double bc = b.distanceTo(c);
       double ac = a.distanceTo(c);
       System.out.println(String.format("ab: %s",ab));
       System.out.println(String.format("bc: %s",bc));
       System.out.println(String.format("ac: %s",ac));

       if ((ab > bc) && (ab > ac)) {
               maxValue = ab;
               System.out.println(String.format("ab имеет наибольшую длину: %s", maxValue));
           } else if ((ac > bc) && (ac > ab)) {
               maxValue = ac;
               System.out.println(String.format("ac имеет наибольшую длину: %s", maxValue));
           } else if ((bc > ac) && (bc > ab)) {
               maxValue = ac;
               System.out.println(String.format("bc имеет наибольшую длину: %s", maxValue));
           }
           return maxValue;
       }
   }


