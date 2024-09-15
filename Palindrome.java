public class Palindrome {

    //используем метод для переворота строки
    public static String reverseString(String input){
        //хранение перевернутой строки
        String reversed = "";
        //вычисляем длину строки
        int length=input.length();
        //начинаем с последнего символа
        for (int i=length-1; i>=0; i--){
            //каждый символ добавляется к переменной
            reversed += input.charAt(i);
        }
        return reversed;
    }
    //является ли число палиндромом
    public static boolean isPalindrome(String s){
        //возвращает перевернутую строку
        String reversed = reverseString(s);
        //сравнивает с исходной
        return s.equals(reversed);

    }
    public static void main(String[] args){
        String test1 = "madam";
        String test2 = "racecar";
        String test3 = "apple";
        String test4 = "kayak";
        String test5 = "song";
        String test6 = "noon";
        System.out.println(test1 + " Является палиндромом? " + isPalindrome(test1));
        System.out.println(test2 + " Является палиндромом? " + isPalindrome(test2));
        System.out.println(test3 + " Является палиндромом? " + isPalindrome(test3));
        System.out.println(test4 + " Является палиндромом? " + isPalindrome(test4));
        System.out.println(test4 + " Является палиндромом? " + isPalindrome(test5));
        System.out.println(test4 + " Является палиндромом? " + isPalindrome(test6));

    }
}
