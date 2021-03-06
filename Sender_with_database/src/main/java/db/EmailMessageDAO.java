package db;
import sender.*;
import java.util.Optional;

public class EmailMessageDAO implements SenderDAO<EmailMessage> {
    SenderConnection dbConnection;
    EmailMessageMapper messageMapper;

    public EmailMessageDAO(SenderConnection dbConnection, EmailMessageMapper messageMapper) {
        this.dbConnection = dbConnection;
        this.messageMapper = messageMapper;
    }

    @Override
    public Optional<EmailMessage> get(long id) throws DatabaseException {
        return dbConnection.executeQuery(("SELECT * FROM uj_sender.email_message WHERE email_message_id=%d;").formatted(id), messageMapper);
    }

    @Override
    public Optional<EmailMessage> get(int statusId) throws DatabaseException {
        throw new DatabaseException(NOT_IMPLEMENTED);
    }

    @Override
    public Optional<EmailMessage> get(String id) throws DatabaseException {
        throw new DatabaseException(NOT_IMPLEMENTED);
    }

    @Override
    public Long save(EmailMessage emailMessage) throws DatabaseException {
        final String statement = ("INSERT INTO uj_sender.email_message (message_title,message_body,creation_date) VALUES ('%s','%s','%s');").formatted(
                emailMessage.getMessageTitle(),
                emailMessage.getMessageBody(), emailMessage.getCreationDate().toString());
        return dbConnection.executeUpdate(statement, true);
    }

    @Override
    public long update(EmailMessage newEmailMessage, EmailMessage expectedEmailMessage) throws DatabaseException {
        throw new DatabaseException(NOT_IMPLEMENTED);
    }

    @Override
    public void delete(EmailMessage emailMessage) throws DatabaseException {
        throw new DatabaseException(NOT_IMPLEMENTED);
    }
}
