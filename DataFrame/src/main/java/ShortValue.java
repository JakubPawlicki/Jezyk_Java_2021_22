import java.util.Objects;

public class ShortValue extends Value {

    private ShortValue() {}

    public static Value create(String s) {
        ShortValue v = new ShortValue();
        v.val = Short.valueOf(s);
        return v;
    }

    @Override
    public Value add(Value val) {
        if (!(val instanceof ShortValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((ShortValue) val);

        return ShortValue.builder()
                .setValue((short) ((short) this.val + (short) val.val))
                .build();
    }

    @Override
    public Value sub(Value val) {
        if (!(val instanceof ShortValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((ShortValue) val);

        return ShortValue.builder()
                .setValue((short) ((short) this.val - (short) val.val))
                .build();    }

    @Override
    public Value mul(Value val) {
        if (!(val instanceof ShortValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((ShortValue) val);

        return ShortValue.builder()
                .setValue((short) ((short) this.val * (short) val.val))
                .build();
    }

    @Override
    public Value div(Value val) {
        if (!(val instanceof ShortValue)) {
            throw new IllegalArgumentException("Should be of type '" + this.getClass() + "', but got '" + val.getClass() + "'");
        }
        assertNotNull((ShortValue) val);

        return ShortValue.builder()
                .setValue((short) ((short) this.val / (short) val.val))
                .build();
    }

    @Override
    public Value pow(Value val) {
        if (!(val instanceof LongValue))
            throw new IllegalArgumentException("Argument val should be instance of pl.edu.fais.uj.dfvalue.LongValue");

        if (val.val == null)
            throw new IllegalArgumentException("Val should not be null");

        return LongValue.builder()
                .setValue((short)(Math.pow((short) this.val, (short) val.val)))
                .build();
    }

    @Override
    public boolean eq(Value val) {
        return this == val;
    }

    @Override
    public boolean lte(Value val) {

        Short val1 = (Short) this.val;
        Short val2 = (Short) val.val;

        return val1<=val2;
    }

    @Override
    public boolean gte(Value val) {

        Short val1 = (Short) this.val;
        Short val2 = (Short) val.val;

        return val1>=val2;
    }

    @Override
    public boolean neq(Value val) {
        return this != val;
    }

    private void assertNotNull(ShortValue val) {
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
        ShortValue other1 = (ShortValue) other;
        return other1.val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "pl.edu.fais.uj.dfvalue.ShortValue{" +
                "value=" + val +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        Object valueToSet;

        public Builder setValue(short value) {
            valueToSet = value;
            return this;
        }

        public Builder setValue(String s) {
            valueToSet = create(s);
            return this;
        }

        public ShortValue build() {
            ShortValue sv = new ShortValue();
            sv.val = valueToSet;
            return sv;
        }
    }
}
