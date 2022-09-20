
import java.util.Scanner;


public class CalcArabRym {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение в римской или арабосткой системе счисления(от 1 до 10) без пробелов + Enter ");
        String expr = scan.nextLine();
        //Определяем арифметическое действие
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (expr.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("Строка не является мат. операцией");
            return;
        }
        //Делим строку по найденному знаку
        String[] strOper = expr.split(regexActions[actionIndex]);
        // Определяем находятся ли числа в одной системе счисления
        if (converter.isRoman(strOper[0]) == converter.isRoman(strOper[1])) {
            int oper1, oper2;
            // Определяем римские ли это числа
            boolean isRoman = converter.isRoman(strOper[0]);
            if (isRoman) {
                //конвертируем  римские в арабские числа
                oper1 = converter.romanToInt(strOper[0]);
                oper2 = converter.romanToInt(strOper[1]);
            } else {
                //конвертируем  арабские числа из строки в число
                oper1 = Integer.parseInt(strOper[0]);
                oper2 = Integer.parseInt(strOper[1]);
            }

            // Выполняем вычисление
            int result = 0;

            switch (actions[actionIndex]) {
                case "+":
                    result = oper1 + oper2;
                    break;
                case "-":
                    result = oper1 - oper2;
                    break;
                case "*":
                    result = oper1 * oper2;
                    break;
                case "/":
                    result = oper1 / oper2;
                    break;
                default:
                    System.out.println("Неккоректный ввод данных");
            }
            if (isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else
            System.out.println(result);
        } else
            System.out.println("Числа в разном формате считления");

    }

}