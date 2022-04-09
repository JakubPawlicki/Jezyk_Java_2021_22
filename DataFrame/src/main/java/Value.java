import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Value {

    private static final Logger logger = LoggerFactory.getLogger(Value.class);
    protected Object val;

    public static Value create(String s) {
        throw new NotImplementedException();
    }

    public abstract Value add(Value val);

    public Object getVal() {
        return val;
    }

    public abstract Value sub(Value val);

    public abstract Value mul(Value val);

    public abstract Value div(Value val);

    public abstract Value pow(Value val);

    public abstract boolean eq(Value val); //operator ==

    public abstract boolean lte(Value val); //operator <=

    public abstract boolean gte(Value val); //operator >=

    public abstract boolean neq(Value val);  //operator !=

    public abstract boolean equals(Object other);

    public abstract int hashCode();

    public void print() {
        logger.info(val.toString());
    }

}
