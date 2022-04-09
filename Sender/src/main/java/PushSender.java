import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PushSender implements Sender {

    @Override
    public void send(Message message, Recipient recipient) throws SenderException, NoSuchAlgorithmException {

        if (message == null || recipient == null)
            throw new SenderException("Message and recipient can not be null!");

        if (!(message instanceof PushMessage && recipient instanceof PushRecipient))
            throw new SenderException("Message and Recipient have to be instance of PushMessage and PushRecipient");

        if (message.getMessageTitle() == null || message.getMessageBody() == null)
            throw new SenderException("Message title and message body can not be null!");

        if (message.getMessageBody().length() > 256)
            throw new SenderException("Message body can not be longer than 256 chars!");

        if (recipient.getRecipientAddress().length() != 32)
            throw new SenderException("Message recipient should be string of 32 chars!");

        if (!recipient.getRecipientAddress().matches("(.*)[a-zA-Z0-9]"))
            throw new SenderException("Message recipient should contain only small or large letters and numbers!");

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(message.getMessageBody().getBytes());
        byte[] digest = md.digest();
        String md5String = new BigInteger(1, digest).toString();

        System.out.println("[Push] Message sent, title=" + message.getMessageTitle() +
                ", bodyMD5=" + md5String + ", recipient=" +
                "*".repeat(recipient.getRecipientAddress().length() - 5) +
                recipient.getRecipientAddress().substring(recipient.getRecipientAddress().length() - 5));
    }
}
