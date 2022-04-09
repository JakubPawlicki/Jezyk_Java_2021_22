package db;

import sender.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class EmailQueueMapper implements SenderMapper<EmailQueue> {

    public Optional<EmailQueue> get(ResultSet rs) throws SQLException {
        if (rs.next()) {
            long emailQueueId = rs.getLong("email_queue_id");
            Timestamp creationDate = rs.getTimestamp("creation_date");
            Timestamp modificationDate = rs.getTimestamp("modification_date");
            long statusId = rs.getLong("status_id");
            long emailMessageId = rs.getLong("email_message_id");
            long emailRecipientId = rs.getLong("email_recipient_id");
            return Optional.of(new EmailQueue(emailQueueId, creationDate, modificationDate, statusId, emailMessageId, emailRecipientId));
        }
        return Optional.empty();
    }
}
