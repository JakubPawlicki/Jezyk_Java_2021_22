import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtitlesLine {

    private static final Logger logger = LoggerFactory.getLogger(SubtitlesLine.class);

    final long startFrame;
    final long stopFrame;
    final String textToPrint;

    protected SubtitlesLine(long startFrame, long stopFrame, String textToPrint) {
        this.startFrame = startFrame;
        this.stopFrame = stopFrame;
        this.textToPrint = textToPrint;
    }

    protected static SubtitlesLine parse(String line) throws SubtitlesLineMalformedException {
        try {
            boolean match = line.matches("^\\{(\\d+)\\}\\{(\\d+)\\}(?!\\{(\\d+)\\})(.*)$");

            if (!match) {
                throw new SubtitlesLineMalformedException(
                        MessageFormat.format("Line ''{0}'' does not conform to standard", line));
            }

            Pattern pattern = Pattern.compile("^\\{(\\d+)\\}\\{(\\d+)\\}(?!\\{(\\d+)\\})(.*)$");
            Matcher matcher = pattern.matcher(line);
            matcher.matches();

            SubtitlesLine subtitlesLine = new SubtitlesLine(Long.parseLong(matcher.group(1)),
                    Long.parseLong(matcher.group(2)), matcher.group(4));

            if (subtitlesLine.startFrame > subtitlesLine.stopFrame)
                throw new SubtitlesLineMalformedException(
                        MessageFormat.format("Start Frame {0} is longer than stop frame {1}", subtitlesLine.startFrame, subtitlesLine.stopFrame));

            return subtitlesLine;

        } catch (Exception e) {
            System.out.println(e);
            throw new SubtitlesLineMalformedException(
                    MessageFormat.format("Line ''{0}'' does not conform to standard", line), e);
        }
    }

    public long getStartFrame() {
        return startFrame;
    }

    public long getStopFrame() {
        return stopFrame;
    }

    public String getTextToPrint() {
        return textToPrint;
    }

    public String generateLine() {
        return "{" + startFrame + "}{" + stopFrame + "}" + textToPrint;
    }
}
