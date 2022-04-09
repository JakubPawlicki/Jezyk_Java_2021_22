import java.util.Objects;

public class IntValue extends Value {

    private IntValue() {
    }

    public static Value create(String s) {
        IntValue v = new IntValue();
        v.val = Integer.valueOf(s);
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof IntValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.IntValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return IntValue.builder()
                .setValue((int) this.val + (int) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof IntValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.IntValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return IntValue.builder()
                .setValue((int) this.val - (int) val.val)
                .build();
    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof IntValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.IntValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return IntValue.builder()
                .setValue((int) this.val * (int) val.val)
                .build();
    }

    @Override
    public Value div(Value val) {
        if (!(val instanceof IntValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.IntValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return IntValue.builder()
                .setValue((int) this.val / (int) val.val)
                .build();
    }

    @Override
    public Value pow(Value val) {
        if (!(val instanceof IntValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.IntValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return IntValue.builder()
                .setValue((int) (Math.pow((int) this.val, (int) val.val)))
                .build();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        Integer val1 = (Integer) this.val;
        Integer val2 = (Integer) val.val;

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Integer val1 = (Integer) this.val;
        Integer val2 = (Integer) val.val;

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private void assertNotNull(IntValue val) {
        if (val == null || val.val == null) {
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
        IntValue other1 = (IntValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.IntValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(int value) {
            valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            valueToSet = create(s);
            return this;
        }

        public IntValue build() {
            IntValue v = new IntValue();
            v.val = this.valueToSet;
            return v;
        }
    }
}
