import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoubleValueTest {

    @Test
    void test_DoubleValueBuilt_Equals_DoubleValueCreated() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(0.123).build();
        DoubleValue DoubleValue2 = (DoubleValue) DoubleValue.create("0.123");
        assertEquals(DoubleValue1, DoubleValue2);
    }

    @Test
    void test_DoubleValueBuilt_Eq_DoubleValueCreated() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(0.123).build();
        DoubleValue DoubleValue2 = (DoubleValue) DoubleValue.create("0.123");
        assertEquals(true, DoubleValue1.eq(DoubleValue1));
        assertEquals(false, DoubleValue1.eq(DoubleValue2));
    }

    @Test
    void test_DoubleValueBuilt_Lte_DoubleValueCreated() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(12.12).build();
        DoubleValue DoubleValue2 = (DoubleValue) DoubleValue.create("123.123");
        assertEquals(false, DoubleValue2.lte(DoubleValue1));
        assertEquals(true, DoubleValue1.lte(DoubleValue2));
    }

    @Test
    void test_DoubleValueBuilt_Gte_DoubleValueCreated() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(1234.22).build();
        DoubleValue DoubleValue2 = (DoubleValue) DoubleValue.create("123.22");
        assertEquals(false, DoubleValue2.gte(DoubleValue1));
        assertEquals(true, DoubleValue1.gte(DoubleValue2));
    }

    @Test
    void test_BuildDoubleValueNull_NullPoDoublerException() {
        Double nullObject = null;
        DoubleValue.Builder builder = DoubleValue.builder();
        assertThrows(NullPointerException.class, () -> builder.setValue(nullObject));
    }

    @Test
    void test_DoubleValueAdd() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(123.55).build();
        DoubleValue DoubleValue2 = DoubleValue.builder().setValue(456.05).build();
        DoubleValue DoubleValue1plus2 = (DoubleValue) DoubleValue1.add(DoubleValue2);

        DoubleValue DoubleValue3 = DoubleValue.builder().setValue(579.60).build();

        assertEquals(DoubleValue1plus2, DoubleValue3);
    }

    @Test
    void test_DoubleValueSub() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(123.43).build();
        DoubleValue DoubleValue2 = DoubleValue.builder().setValue(456.44).build();
        DoubleValue DoubleValue1sub2 = (DoubleValue) DoubleValue2.sub(DoubleValue1);

        DoubleValue DoubleValue3 = DoubleValue.builder().setValue(333.01).build();

        assertEquals(DoubleValue1sub2, DoubleValue3);
    }

    @Test
    void test_DoubleValueMul() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(123.2).build();
        DoubleValue DoubleValue2 = DoubleValue.builder().setValue(2).build();
        DoubleValue DoubleValue1sub2 = (DoubleValue) DoubleValue2.mul(DoubleValue1);

        DoubleValue DoubleValue3 = DoubleValue.builder().setValue(246.4).build();

        assertEquals(DoubleValue1sub2, DoubleValue3);
    }

    @Test
    void test_DoubleValueDiv() {
        DoubleValue DoubleValue1 = DoubleValue.builder().setValue(2.0).build();
        DoubleValue DoubleValue2 = DoubleValue.builder().setValue(246.0).build();
        DoubleValue DoubleValue1sub2 = (DoubleValue) DoubleValue2.div(DoubleValue1);

        DoubleValue DoubleValue3 = DoubleValue.builder().setValue(123.0).build();

        assertEquals(DoubleValue1sub2, DoubleValue3);
    }

    @Test
    void test_DoubleValue_AddBadValueType_IllegalArgumentException() {
        Value DoubleValue1 = DoubleValue.builder().setValue(123.0).build();
        Value longValue1 = LongValue.builder().setValue(123L).build();

        assertThrows(IllegalArgumentException.class, () -> DoubleValue1.add(longValue1));
    }
}
