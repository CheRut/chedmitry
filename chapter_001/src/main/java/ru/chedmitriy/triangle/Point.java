package ru.chedmitriy.triangle;

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
        return  Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }
}
/**
 * Класс Triangle - определяет площадь треугольника по трем сторонам
 * */
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
     * @param: ac = a.distanceTo(c) - расстояние между точками a и c(или длина стороны ac)
     * @param: halfPer - полупериметр треугольника
     * @param: 
     * Area = Math.sqrt(halfPer * (halfPer-ab) * (halfPer-bc) * (halfPer-ac));
     * 
     * */
    public double area() {
        double area = 0;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = a.distanceTo(c);
        double halfPer = (ab + bc + ac) / 2;
            if ((ab > 0) || (bc > 0) || (ac > 0) || (ab + bc > ac) || (ab + ac > bc) || (ac + bc > ab)) {
                area = Math.sqrt(halfPer * (halfPer - ab) * (halfPer - bc) * (halfPer - ac));
                return area;
            } else {
                System.out.println(String.format("Ошибка: %s", "Треугольник построить нельзя"));
                return -1;
            }

    }
}
/**
 * Класс maxSide определяет и выводит на экран значение стороны с наибольшей длиной
 * Метод max в качестве аргументов принимает экземпляры класса Point,и определяет наибольшую длину стороны
 * треугольника
 * Метод maxFour в качестве аргументов принимает экземпляры класса Point,и определяет наибольшую длину стороны
 * четырехугольника
 * Метод maxFive в качестве аргументов принимает экземпляры класса Point,и определяет наибольшую длину стороны
 * пятиугольника
 * На основание принятых аргументов определяются значения
 * @param: maxValue - наибольшее значение
 * Для удобства сравнения вывожу значения в консоль
 * Далее использую оператор сравнения, где выбираю наибольшее значение
 * */
class MaxSide {
    public double max(Point a, Point b, Point c) {
        double maxValue = 0;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = a.distanceTo(c);
        Double[] maximSide = new Double[3];
        maximSide[0] = ab; maximSide[1] = bc;
        maximSide[2] = ac;
        System.out.println(String.format("Определим наибольшую длину стороны треугольника:"));
        for (int i = 0; i < maximSide.length; i++) {
            System.out.println(String.format("длина %s%s%s", i + 1, " - ой стороны: ", maximSide[i]));
            if (maxValue < maximSide[i]) {
                maxValue = maximSide[i];
            }
        }
        System.out.println(String.format("наибольшая длина: %s", maxValue));
        System.out.println("");
        return maxValue;
    }
    public double maxFour(Point a, Point b, Point c, Point d) {
        double maxValue = 0;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double cd = c.distanceTo(d);
        double ad = a.distanceTo(d);
        Double[] maximSide = new Double[4];
        maximSide[0] = ab; maximSide[1] = bc;
        maximSide[2] = cd; maximSide[3] = ad;
        System.out.println(String.format("Определим наибольшую длину стороны четырехугольника:"));
        for (int i = 0; i < maximSide.length; i++) {
            System.out.println(String.format("длина %s%s%s", i + 1, " - ой стороны: ", maximSide[i]));
           if (maxValue < maximSide[i]) {
               maxValue = maximSide[i];
           }
        }
        System.out.println(String.format("В четырехугольнике наибольшая длина: %s", maxValue));
        System.out.println();
        return maxValue;
    }
    public double maxFive(Point a, Point b, Point c, Point d, Point e) {
        double maxValue = 0;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double cd = c.distanceTo(d);
        double de = d.distanceTo(e);
        double ae = a.distanceTo(e);
        Double[] maximSide = new Double[5];
        maximSide[0] = ab; maximSide[1] = bc;
        maximSide[2] = cd; maximSide[3] = de;
        maximSide[4] = ae;
        System.out.println(String.format("Определим наибольшую длину стороны пятиугольника:"));
        for (int i = 0; i < maximSide.length; i++) {
            System.out.println(String.format("длина %s%s%s", i + 1, "- ой стороны: ", maximSide[i]));
            if (maxValue < maximSide[i]) {
                maxValue = maximSide[i];
            }
        }
        System.out.println(String.format("В пятиугольнике наибольшая длина: %s", maxValue));
        System.out.println();
        return maxValue;
    }

}