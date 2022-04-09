import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;

public class StringValue extends Value {

    private StringValue() {}

    public static Value create(String s) {
        assertNotEmptyOrBlank(s);
        StringValue v = new StringValue();
        v.val = s;
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof StringValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotEmptyOrBlank(val.val.toString());

        return StringValue.builder()
                .setValue(this.val + (String) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        throw new NotImplementedException();
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

        Integer val1 = this.val.toString().length();
        Integer val2 = val.val.toString().length();

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Integer val1 = this.val.toString().length();
        Integer val2 = val.val.toString().length();

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private static void assertNotEmptyOrBlank(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Should not be blank, but got '" + s + "'");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        StringValue other1 = (StringValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.StringValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(String value) {
            assertNotEmptyOrBlank(value);
            valueToSet = create(value);
            return this;
            // - remember of validation of value
        }

        public StringValue build() {
            return (StringValue) valueToSet;
        }
    }
}
