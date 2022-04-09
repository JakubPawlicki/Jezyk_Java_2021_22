import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateTimeValue extends Value {

    private DateTimeValue() {
    }

    public static Value create(String s) {
        DateTimeValue dateTimeValue = new DateTimeValue();
        dateTimeValue.val = LocalDateTime.parse(s);
        return dateTimeValue;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof DateTimeValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.DateTimeValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        LocalDateTime localDateTime = (LocalDateTime) this.val;
        LocalDateTime localDateTime2 = (LocalDateTime) val.val;

        LocalDateTime localDateTime3;
        localDateTime3 = localDateTime.plusYears(localDateTime2.getYear());
        localDateTime3 = localDateTime3.plusMonths(localDateTime2.getMonthValue());
        localDateTime3 = localDateTime3.plusDays(localDateTime2.getDayOfMonth());
        localDateTime3 = localDateTime3.plusHours(localDateTime2.getHour());
        localDateTime3 = localDateTime3.plusMinutes(localDateTime2.getMinute());

        return DateTimeValue.builder().setValue(localDateTime3.toString()).build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof DateTimeValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.DateTimeValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        LocalDateTime localDateTime = (LocalDateTime) this.val;
        LocalDateTime localDateTime2 = (LocalDateTime) val.val;

        LocalDateTime localDateTime3;
        localDateTime3 = localDateTime.minusYears(localDateTime2.getYear());
        localDateTime3 = localDateTime3.minusMonths(localDateTime2.getMonthValue());
        localDateTime3 = localDateTime3.minusDays(localDateTime2.getDayOfMonth());
        localDateTime3 = localDateTime3.minusHours(localDateTime2.getHour());
        localDateTime3 = localDateTime3.minusMinutes(localDateTime2.getMinute());

        return DateTimeValue.builder().setValue(localDateTime3.toString()).build();
    }

    @Override
    public Value mul(Value val) {
        throw new NotImplementedException();
    }

    @Override
    public Value div(Value val) {
        throw new NotImplementedException();
    }

    @Override
    public Value pow(Value val) {
        throw new NotImplementedException();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        LocalDateTime localDateTime = (LocalDateTime) this.val;
        LocalDateTime localDateTime2 = (LocalDateTime) val.val;

        return (localDateTime.isBefore(localDateTime2) || localDateTime.isEqual(localDateTime2));
    }

    @Override
    public boolean gte(Value val) {

        LocalDateTime localDateTime = (LocalDateTime) this.val;
        LocalDateTime localDateTime2 = (LocalDateTime) val.val;

        return (localDateTime.isAfter(localDateTime2) || localDateTime.isEqual(localDateTime2));
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        DateTimeValue other1 = (DateTimeValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.DateTimeValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        int year;
        int month;
        int dayOfMonth;
        int hour;
        int minute;
        Object dateTimeValueToSet;

        public Builder setValue(String s) {
            this.dateTimeValueToSet = DateTimeValue.create(s);
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setMonth(int month) {
            if (month <= 0 || month > 12)
                throw new IllegalArgumentException();
            this.month = month;
            return this;
        }

        public Builder setDay(int day) {
            if (day <= 0 || day > 31)
                throw new IllegalArgumentException();
            this.dayOfMonth = day;
            return this;
        }

        public Builder setHour(int hour) {
            if (hour <= 0 || hour > 24)
                throw new IllegalArgumentException();
            this.hour = hour;
            return this;
        }

        public Builder setMinute(int minute) {
            if (minute < 0 || minute > 59)
                throw new IllegalArgumentException();
            this.minute = minute;
            return this;
        }

        public DateTimeValue build() {
            DateTimeValue dateTimeValue = new DateTimeValue();
            if (dateTimeValueToSet == null) {
                dateTimeValue.val = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
            } else {
                dateTimeValue = (DateTimeValue) dateTimeValueToSet;
            }
            return dateTimeValue;

        }


    }
}
