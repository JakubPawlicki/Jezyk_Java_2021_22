public abstract class Message {

    protected String messageTitle;
    protected String messageBody;

    abstract String getMessageTitle();
    abstract String getMessageBody();
}
