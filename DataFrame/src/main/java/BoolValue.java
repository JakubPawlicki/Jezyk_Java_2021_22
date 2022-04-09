import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;

public class BoolValue extends Value {

    private BoolValue() {
    }

    public static Value create(String s) {
        BoolValue v = new BoolValue();
        if ("true".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s)) {
            v.val = true;
        } else if ("false".equalsIgnoreCase(s) || "0".equalsIgnoreCase(s)) {
            v.val = false;
        } else {
            throw new IllegalArgumentException("Only 'true', 'false', '1', '0' are supported but got '" + s + "'");
        }
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof BoolValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((BoolValue) val);

        return BoolValue.builder()
                .setValue((boolean) this.val || (boolean) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        throw new NotImplementedException();
    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof BoolValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((BoolValue) val);

        return BoolValue.builder()
                .setValue((boolean) this.val && (boolean) val.val)
                .build();
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
        throw new NotImplementedException();
    }

    @Override
    public boolean gte(Value val) {
        throw new NotImplementedException();
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private void assertNotNull(BoolValue val) {
        if (val == null || val.val == null ) {
            throw new IllegalArgumentException("Should not be null, but got '" + val + "'");
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
        BoolValue other1 = (BoolValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "BooleanValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(boolean value) {
            this.valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            this.valueToSet = create(s).val;
            return this;
        }

        public BoolValue build() {
            BoolValue b = new BoolValue();
            b.val = valueToSet;
            return b;
        }
    }
}
