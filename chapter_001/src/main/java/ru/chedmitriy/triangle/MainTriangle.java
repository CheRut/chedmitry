package ru.chedmitriy.triangle;

/**
 * Class Point определяет расстояние между точками - длину будущих сторон
 * @author dimCher
 * @since 22.05.2016.
 * Метод coordinats - метод,который принимает значения координат
 */
public class MainTriangle {
    private static Point coordinats(double x, double y) {
        return new Point(x, y);
    }
    /**
     * Метод main посредством выполнения метода coordinats
     * получает вершины треугольника a,b,c
     * @param: double area - площадь треугольника с вершинами a,b,c
     * @param: triangle - экземпляр объекта Triangle с аргументами a,b,c
     * @param: maxSide - экземпляр объекта MaxSide
     * Можно также записать:double area = new Triangle(a,b,c).area();
     * условие if(area!=-1) используется потому,что при расчете площади в классе Triangle
     * при равенстве одной из сторон "0", выводится ошибка,возврашается "-1" дальнейшие вычисления не имеют смысла
     * */
    public static void main(String[] args) {
        Point a = coordinats(1, 1);
        Point b = coordinats(7, 8);
        Point c = coordinats(6, 3);
        Point d = coordinats(2, 4);
        Point e = coordinats(3, 6);
        Triangle triangle = new Triangle(a, b, c);
        double area = triangle.area();
        MaxSide maxSide = new MaxSide();
        maxSide.max(a, b, c);
        maxSide.maxFour(a, b, c, d);
        maxSide.maxFive(a, b, c, d, e);
        if (area != -1) {
            System.out.println(String.format("Площадь треугольника равна: %s", area));
        }
    }
}