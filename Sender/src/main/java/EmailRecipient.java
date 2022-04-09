public class EmailRecipient extends Recipient{

    public EmailRecipient(String recipientAddress){
        this.recipientAddress = recipientAddress;
    }

    @Override
    String getRecipientAddress() {
        return this.recipientAddress;
    }
}
