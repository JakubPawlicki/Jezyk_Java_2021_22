import java.util.Objects;

public class LongValue extends Value {

    private LongValue() {}

    public static Value create(String s) {
        LongValue v = new LongValue();
        v.val = Long.valueOf(s);
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof LongValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((LongValue) val);

        return LongValue.builder()
                .setValue((long) this.val + (long) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof LongValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((LongValue) val);

        return LongValue.builder()
                .setValue((long) this.val - (long) val.val)
                .build();
    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof LongValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((LongValue) val);

        return LongValue.builder()
                .setValue((long) this.val * (long) val.val)
                .build();
    }

    @Override
    public Value div(Value val) {
        if (!(val instanceof LongValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((LongValue) val);

        return LongValue.builder()
                .setValue((long) this.val / (long) val.val)
                .build();
    }

    @Override
    public Value pow(Value val) {
        if (!(val instanceof LongValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.LongValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return LongValue.builder()
                .setValue((long)(Math.pow((long) this.val, (long) val.val)))
                .build();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        Long val1 = (Long) this.val;
        Long val2 = (Long) val.val;

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Long val1 = (Long) this.val;
        Long val2 = (Long) val.val;

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private void assertNotNull(LongValue val) {
        if(val == null || val.val == null)
            throw new IllegalArgumentException("Should not be null, but got '" + val + "'");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        LongValue other1 = (LongValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.LongValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(long value) {
            valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            valueToSet = create(s);
            return this;
        }

        public LongValue build() {
            LongValue lv = new LongValue();
            lv.val = valueToSet;
            return lv;
        }
    }
}
