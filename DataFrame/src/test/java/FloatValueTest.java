import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FloatValueTest {

    @Test
    void test_FloatValueBuilt_Equals_FloatValueCreated() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(0.123f).build();
        FloatValue FloatValue2 = (FloatValue) FloatValue.create("0.123");
        assertEquals(FloatValue1, FloatValue2);
    }

    @Test
    void test_FloatValueBuilt_Eq_FloatValueCreated() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(0.123f).build();
        FloatValue FloatValue2 = (FloatValue) FloatValue.create("0.123");
        assertEquals(true, FloatValue1.eq(FloatValue1));
        assertEquals(false, FloatValue1.eq(FloatValue2));
    }

    @Test
    void test_FloatValueBuilt_Lte_FloatValueCreated() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(12.12f).build();
        FloatValue FloatValue2 = (FloatValue) FloatValue.create("123.123");
        assertEquals(false, FloatValue2.lte(FloatValue1));
        assertEquals(true, FloatValue1.lte(FloatValue2));
    }

    @Test
    void test_FloatValueBuilt_Gte_FloatValueCreated() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(1234.22f).build();
        FloatValue FloatValue2 = (FloatValue) FloatValue.create("123.22");
        assertEquals(false, FloatValue2.gte(FloatValue1));
        assertEquals(true, FloatValue1.gte(FloatValue2));
    }

    @Test
    void test_BuildFloatValueNull_NullPoFloatrException() {
        Float nullObject = null;
        FloatValue.Builder builder = FloatValue.builder();
        assertThrows(NullPointerException.class, () -> builder.setValue(nullObject));
    }

    @Test
    void test_FloatValueAdd() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(123.55f).build();
        FloatValue FloatValue2 = FloatValue.builder().setValue(456.05f).build();
        FloatValue FloatValue1plus2 = (FloatValue) FloatValue1.add(FloatValue2);

        FloatValue FloatValue3 = FloatValue.builder().setValue(579.60f).build();

        assertEquals(FloatValue1plus2, FloatValue3);
    }

    @Test
    void test_FloatValueSub() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(123.43f).build();
        FloatValue FloatValue2 = FloatValue.builder().setValue(456.44f).build();
        FloatValue FloatValue1sub2 = (FloatValue) FloatValue2.sub(FloatValue1);

        FloatValue FloatValue3 = FloatValue.builder().setValue(333.01f).build();

        assertEquals(FloatValue1sub2, FloatValue3);
    }

    @Test
    void test_FloatValueMul() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(123.2f).build();
        FloatValue FloatValue2 = FloatValue.builder().setValue(2).build();
        FloatValue FloatValue1sub2 = (FloatValue) FloatValue2.mul(FloatValue1);

        FloatValue FloatValue3 = FloatValue.builder().setValue(246.4f).build();

        assertEquals(FloatValue1sub2, FloatValue3);
    }

    @Test
    void test_FloatValueDiv() {
        FloatValue FloatValue1 = FloatValue.builder().setValue(2.0f).build();
        FloatValue FloatValue2 = FloatValue.builder().setValue(246.0f).build();
        FloatValue FloatValue1sub2 = (FloatValue) FloatValue2.div(FloatValue1);

        FloatValue FloatValue3 = FloatValue.builder().setValue(123.0f).build();

        assertEquals(FloatValue1sub2, FloatValue3);
    }

    @Test
    void test_FloatValue_AddBadValueType_IllegalArgumentException() {
        Value FloatValue1 = FloatValue.builder().setValue(123.0f).build();
        Value longValue1 = LongValue.builder().setValue(123L).build();

        assertThrows(IllegalArgumentException.class, () -> FloatValue1.add(longValue1));
    }
}
