public class PushRecipient extends Recipient{

    public PushRecipient(String recipientAddress){
        this.recipientAddress = recipientAddress;
    }

    @Override
    String getRecipientAddress() {
        return this.recipientAddress;
    }
}
