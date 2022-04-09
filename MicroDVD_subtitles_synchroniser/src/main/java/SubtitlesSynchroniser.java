import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Scanner;

public class SubtitlesSynchroniser {
    private static final Logger logger = LoggerFactory.getLogger(SubtitlesSynchroniser.class);

    private SubtitlesSynchroniser() {
    }

    static void delay(String in, String out, int delay, int fps)
            throws SubtitlesLineMalformedException, SubtitlesSynchroniserException, IOException {

        if (fps <= 0) {
            throw new SubtitlesSynchroniserException(
                    MessageFormat.format("Invalid parameter fps= {0}", fps));
        }

        File inFile = new File(in);
        File outFile = new File(out);

        if (!inFile.exists()) {
            throw new SubtitlesSynchroniserException(
                    MessageFormat.format("Input file = {0} not found", in));
        }

        if (!inFile.canRead()) {
            throw new SubtitlesSynchroniserException(
                    MessageFormat.format("Input file = {0} can not read", in));
        }

        outFile.createNewFile();

        if (!outFile.canWrite()) {
            throw new SubtitlesSynchroniserException(
                    MessageFormat.format("Output file = {0} can not write", in));
        }

        Scanner scanner;

        try {
            scanner = new Scanner(inFile);
        } catch (Exception FileNotFoundException) {
            throw new SubtitlesSynchroniserException(
                    MessageFormat.format("Input file = {0} not found", in));
        }

        SubtitlesLine subtitlesLine, synchronizedSubtitlesLine;
        PrintWriter printWriter = new PrintWriter(new FileWriter(out));

        int frames = Math.round(delay / (1000 / fps));

        while (scanner.hasNext()) {
            subtitlesLine = SubtitlesLine.parse(scanner.nextLine());
            synchronizedSubtitlesLine = new SubtitlesLine(subtitlesLine.getStartFrame() + frames,
                    subtitlesLine.getStopFrame() + frames, subtitlesLine.getTextToPrint());
            printWriter.println(synchronizedSubtitlesLine.generateLine());
        }

        printWriter.close();
        scanner.close();

    }
}
