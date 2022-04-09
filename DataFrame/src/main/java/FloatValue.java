import java.util.Objects;

public class FloatValue extends Value {

    static final double THRESHOLD = .00001f;

    private FloatValue() {}

    public static Value create(String s) {
        FloatValue v = new FloatValue();
        v.val = Float.valueOf(s);
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof FloatValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((FloatValue) val);

        return FloatValue.builder()
                .setValue((float) this.val + (float) val.val)
                .build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof FloatValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((FloatValue) val);

        return FloatValue.builder()
                .setValue((float) this.val - (float) val.val)
                .build();
    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof FloatValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((FloatValue) val);

        return FloatValue.builder()
                .setValue((float) this.val * (float) val.val)
                .build();
    }

    @Override
    public Value div(Value val) {
        if (!(val instanceof FloatValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((FloatValue) val);

        return FloatValue.builder()
                .setValue((float) this.val / (float) val.val)
                .build();
    }

    @Override
    public Value pow(Value val) {
        if (!(val instanceof FloatValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.FloatValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return FloatValue.builder()
                .setValue((float)(Math.pow((float) this.val, (float) val.val)))
                .build();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        Float val1 = (Float) this.val;
        Float val2 = (Float) val.val;

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Float val1 = (Float) this.val;
        Float val2 = (Float) val.val;

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private void assertNotNull(FloatValue val) {
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
        FloatValue other1 = (FloatValue) other;

        return (Math.abs((float) this.val - (float) other1.val) <= THRESHOLD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.FloatValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(float value) {
            valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            valueToSet = create(s);
            return this;
        }

        public FloatValue build() {
            FloatValue fv = new FloatValue();
            fv.val = valueToSet;
            return fv;
        }
    }
}
