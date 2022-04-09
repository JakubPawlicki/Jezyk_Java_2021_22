import java.io.*;

public class Cryptographer {

    private Cryptographer() {
    }

    public static void cryptfile(String pathToFileIn, String pathToFileOut, Algorithm algorithm)
            throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(pathToFileIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathToFileOut));

        String l;
        while ((l = in.readLine()) != null) {
            out.println(algorithm.crypt(l));
        }
        in.close();
        out.close();
    }

    public static void decryptfile(String pathToFileIn, String pathToFileOut, Algorithm algorithm)
            throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(pathToFileIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathToFileOut));

        String l;
        while ((l = in.readLine()) != null) {
            out.println(algorithm.decrypt(l));
        }
        in.close();
        out.close();
    }
}
