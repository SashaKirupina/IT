public class Primes {

    public static boolean isPrime(int n) {
     //метод возвращает либо true либо false, далее проверка числа, простое или нет
        for (int a = 2; a < n; a++) {
            if (n % a == 0) {
                return false; //если нашелся делитель, то число не простое
            }
        }
        return true;
    }

    public static void main(String[] args) {

        for (int a = 2; a <= 100; a++) {

            if (isPrime(a)) { //проверяем простое ли число
                System.out.println(a);
            }
        }
    }
}
