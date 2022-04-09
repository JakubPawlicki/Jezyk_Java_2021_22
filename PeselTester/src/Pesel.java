public class Pesel {

    private String numerPesel;

    private final static int[] WEIGHT_FUNCTION = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

    public Pesel(String pesel) {

        this.numerPesel = pesel;
    }

    public boolean compare(Pesel pesel_2) {

        return this.numerPesel.equals(pesel_2.numerPesel);
    }

    public static boolean check(Pesel pesel) {

        int result = 0, number;

        for (int i = 0; i <= 9; i++) {

            number = pesel.numerPesel.charAt(i) - 48;
            result += (number * WEIGHT_FUNCTION[i]);
        }

        //System.out.println("Suma = " + result);

        result %= 10;

        //System.out.println("M = " + result);

        if (result > 0)
            result = 10 - result;
        else
            result = 0;

        number = pesel.numerPesel.charAt(10) - 48;

        /*
        System.out.println("Cyfra kontrolna z numeru PESEL = " + number);
        System.out.println("Wyliczona cyfra kontrolna = " + result);
        System.out.println(number + " = " + result);
        */

        return result == number;
    }
}
