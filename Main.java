import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char operation = 0;
        int num1, num2;
        int result;
        System.out.println("Введите выражение из двух чисел арабской или римской системы счисления. Числа должны быть в диапазоне от 1 до 10!");
//      Считываем строку которую ввёл пользователь
        String input = scanner.nextLine();
//      Создаём пустой символьный массив длиной 11 символов(т.к самый большой решаемый пример длинной 11 символов)
        char[] underChar = new char[11];
//      Заполняем массив строкой которую ввел пользователь и ловим знак операции
        for (int i = 0; i < input.length(); i++) {
            underChar[i] = input.charAt(i);
            if (underChar[i] == '+') {
                operation = '+';
            }
            if (underChar[i] == '-') {
                operation = '-';
            }
            if (underChar[i] == '*') {
                operation = '*';
            }
            if (underChar[i] == '/') {
                operation = '/';
            }
        }
//      Переводим строку для дальнейших преобразований
        String underCharString = String.valueOf(underChar);
//      Убираем пробелы для правильного считывания
        underCharString = underCharString.replaceAll("\\s","");
//      Делим элементы на числа (Оператор является делителем)
        String[] blacks = underCharString.split("[+-/*]");
        String st0 = blacks[0];
        String st1 = blacks[1];
//      Проверка на количество эллементов, выбрасываем исключение
        for (int i =0; i<blacks.length; i++){
          if (i >= 2 ){
         throw new Exception("Вы ввели больше 2-х чисел");
         }}
//      Убираем пробелы у str1 в начале и конце
        String string3 = st1.trim();
//      Проверка на систему счисления
        if ((st0.contains("V") || st0.contains("I") || st0.contains("X")) && (string3.contains("V")|| string3.contains("I") || string3.contains("X")))
        {
//      Преобразуем римскую СС на арабскую
        num1 = romanToNum(st0);
        num2 = romanToNum(string3);
//      Проверка. Числа не должны быть меньше 0
            if (num1 < 0 && num2 < 0) {
                throw new Exception("Числа меньше 0");
            } else {
//      Считаем результат и выводим результат на римской СС
                result = calculated(num1, num2, operation);
                System.out.println("Результат на Римской системе счисления");
                String resultRoman = convertToRoman(result);
                System.out.println(st0 + " " + operation + " " + string3 + " = " + resultRoman);
            }} else {
//      Иначе считаем и выводим результат на арабской СС
            num1 = Integer.parseInt(st0);
            num2 = Integer.parseInt(string3);
            result = calculated(num1, num2, operation);
            System.out.println("Результат на Арабской системе счисления ");
            System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }}
//      Метод для конвертирования в Римскую СС
    private static String convertToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
//      Метод для конвертирования из римской в арабсую СС
    private static int romanToNum (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
//      Метод "Калькулятор"
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        if (num1<11 && num2<11){

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }}
        return result;
    }
}