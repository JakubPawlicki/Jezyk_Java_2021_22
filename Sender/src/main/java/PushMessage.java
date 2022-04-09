public class PushMessage extends Message{

    public PushMessage(String messageTitle, String messageBody){
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
