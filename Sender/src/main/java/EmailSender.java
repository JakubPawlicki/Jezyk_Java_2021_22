import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EmailSender implements Sender {

    @Override
    public void send(Message message, Recipient recipient) throws SenderException, NoSuchAlgorithmException {

        if (message == null || recipient == null)
            throw new SenderException("Message and recipient can not be null!");

        if(!(message instanceof EmailMessage && recipient instanceof EmailRecipient))
            throw new SenderException("Message and Recipient have to be instance of EmailMessage and EmailRecipient");

        if (message.getMessageTitle() == null || message.getMessageBody() == null)
            throw new SenderException("message title and message body can not be null!");

        if(!recipient.getRecipientAddress().matches("(.+)@(.+)"))
            throw new SenderException("Invalid recipient address!");

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(message.getMessageBody().getBytes());
        byte[] digest = md.digest();
        String md5String = new BigInteger(1, digest).toString();

        System.out.println("[Email] Message sent, title=" + message.getMessageTitle() +
                    ", bodyMD5=" + md5String + ", recipient=" +
                    "*".repeat(recipient.getRecipientAddress().indexOf("@")) +
                recipient.getRecipientAddress().substring(recipient.getRecipientAddress().indexOf("@")));
    }
}
