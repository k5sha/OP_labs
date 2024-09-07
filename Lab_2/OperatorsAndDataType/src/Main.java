public class Main {

    //    Math.pow() - Степінь
    //    Math.E - Експонента
    //    Math.log10() - Десятковий логарифм
    //    Math.sqrt() - Корінь квадратний
    //    Math.abs() - Модуль
    //    Math.atan() - Арктангенс

    public static double task_2(double a, double b, double c, double d) {
        return  (((Math.pow(Math.E,a) + (3 * Math.log10(c))) / (Math.sqrt(Math.pow(b,c)))) * Math.abs(Math.atan(d)));
    }

    //   Math.cosh() -  Гіперболічний косинус
    public  static  double task_12(double a, double b, double c, double d) {
        return  (6 * (Math.pow(Math.sin(Math.abs(2 * a)), Math.log10(b)))) + Math.sqrt((c * Math.cosh(-d)));
    }

    //    Math.sinh() -  Гіперболічний синус
    public  static  double task_22(double a, double b, double c, double d) {
        return Math.pow((4 * Math.sinh(Math.sqrt(Math.abs((a / b)))) + (3 * Math.asin(c))), d);
    }

    public static void main(String[] args) {
        //  Task 2
        System.out.println(task_2(2.34, 0.756, 2.23, -1.653));
        //  Task 12
        System.out.println(task_12(1.478, 9.26, 0.68, 2.24));
        //  Task 22
        System.out.println(task_22(1.23, -0.34, 0.707, 2.312));
    }
}
