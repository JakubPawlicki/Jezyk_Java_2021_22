import java.util.Objects;

public class DoubleValue extends Value {

    static final double THRESHOLD = .00001f;

    private DoubleValue() {}

    public static Value create(String s) {
        DoubleValue v = new DoubleValue();
        v.val = Double.valueOf(s);
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof DoubleValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((DoubleValue) val);

        return DoubleValue.builder()
                .setValue((double) this.val + (double) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof DoubleValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((DoubleValue) val);

        return DoubleValue.builder()
                .setValue((double) this.val - (double) val.val)
                .build();
    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof DoubleValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((DoubleValue) val);

        return DoubleValue.builder()
                .setValue((double) this.val * (double) val.val)
                .build();
    }

    @Override
    public Value div(Value val) {
        if (!(val instanceof DoubleValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((DoubleValue) val);

        return DoubleValue.builder()
                .setValue((double) this.val / (double) val.val)
                .build();
    }

    @Override
    public Value pow(Value val) {
        if (!(val instanceof DoubleValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.DoubleValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return DoubleValue.builder()
                .setValue(Math.pow((double) this.val, (double) val.val))
                .build();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        Double val1 = (Double) this.val;
        Double val2 = (Double) val.val;

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Double val1 = (Double) this.val;
        Double val2 = (Double) val.val;

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {return this == val;}

    private void assertNotNull(DoubleValue val) {
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
        DoubleValue other1 = (DoubleValue) other;

        return Math.abs((double) this.val - (double) other1.val) <= THRESHOLD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.DoubleValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(double value) {
            this.valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            this.valueToSet = create(s);
            return this;
        }

        public DoubleValue build() {
            DoubleValue dv = new DoubleValue();
            dv.val = valueToSet;
            return dv;
        }
    }
}
