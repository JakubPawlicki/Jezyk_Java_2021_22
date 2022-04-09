package db;
import sender.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class EmailMessageMapper implements SenderMapper<EmailMessage> {

    public Optional<EmailMessage> get(ResultSet rs) throws SQLException {
        if (rs.next()) {
            long emailMessageId = rs.getLong("email_message_id");
            Timestamp creationDate = rs.getTimestamp("creation_date");
            String messageTitle = rs.getString("message_title");
            String messageBody = rs.getString("message_body");
            return Optional.of(new EmailMessage(emailMessageId, creationDate, messageTitle, messageBody));
        }
        return Optional.empty();
    }
}
