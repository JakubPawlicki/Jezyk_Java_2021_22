public class EmailMessage extends Message{

    public EmailMessage(String messageTitle, String messageBody){
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
    }

    @Override
    String getMessageTitle() {
        return this.messageTitle;
    }

    @Override
    String getMessageBody() {
        return this.messageBody;
    }
}
