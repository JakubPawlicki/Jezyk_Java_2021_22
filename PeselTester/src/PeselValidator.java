public class PeselValidator {
    public static void main(String[] args) {

        Pesel pesel1 = new Pesel(args[0]);
        Pesel pesel2 = new Pesel(args[1]);
        Pesel pesel3 = new Pesel(args[2]);

        System.out.println("pesel1 = pesel2: " + pesel1.compare(pesel2));
        System.out.println("pesel2 = pesel3: " + pesel2.compare(pesel3));
        System.out.println("pesel1 = pesel3: " + pesel1.compare(pesel3));

        System.out.println("Poprawnosc pesel1: " + Pesel.check(pesel1));
        System.out.println("Poprawnosc pesel2: " + Pesel.check(pesel2));
        System.out.println("Poprawnosc pesel3: " + Pesel.check(pesel3));

    }
}
