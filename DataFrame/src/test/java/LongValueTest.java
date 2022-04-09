import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongValueTest {

    @Test
    void test_LongValueBuilt_Equals_LongValueCreated() {
        LongValue LongValue1 = LongValue.builder().setValue(123L).build();
        LongValue LongValue2 = (LongValue) LongValue.create("123");
        assertEquals(LongValue1, LongValue2);
    }

    @Test
    void test_LongValueBuilt_Eq_LongValueCreated() {
        LongValue LongValue1 = LongValue.builder().setValue(123L).build();
        LongValue LongValue2 = (LongValue) LongValue.create("123");
        assertEquals(true, LongValue1.eq(LongValue1));
        assertEquals(false, LongValue1.eq(LongValue2));
    }

    @Test
    void test_LongValueBuilt_Lte_LongValueCreated() {
        LongValue LongValue1 = LongValue.builder().setValue(12L).build();
        LongValue LongValue2 = (LongValue) LongValue.create("123");
        assertEquals(false, LongValue2.lte(LongValue1));
        assertEquals(true, LongValue1.lte(LongValue2));
    }

    @Test
    void test_LongValueBuilt_Gte_LongValueCreated() {
        LongValue LongValue1 = LongValue.builder().setValue(1234L).build();
        LongValue LongValue2 = (LongValue) LongValue.create("123");
        assertEquals(false, LongValue2.gte(LongValue1));
        assertEquals(true, LongValue1.gte(LongValue2));
    }

    @Test
    void test_BuildLongValueNull_NullPoLongerException() {
        Long nullObject = null;
        LongValue.Builder builder = LongValue.builder();
        assertThrows(NullPointerException.class, () -> builder.setValue(nullObject));
    }

    @Test
    void test_LongValueAdd() {
        LongValue LongValue1 = LongValue.builder().setValue(123L).build();
        LongValue LongValue2 = LongValue.builder().setValue(456L).build();
        LongValue LongValue1plus2 = (LongValue) LongValue1.add(LongValue2);

        LongValue LongValue3 = LongValue.builder().setValue(579L).build();

        assertEquals(LongValue1plus2, LongValue3);
    }

    @Test
    void test_LongValueSub() {
        LongValue LongValue1 = LongValue.builder().setValue(123L).build();
        LongValue LongValue2 = LongValue.builder().setValue(456L).build();
        LongValue LongValue1sub2 = (LongValue) LongValue2.sub(LongValue1);

        LongValue LongValue3 = LongValue.builder().setValue(333L).build();

        assertEquals(LongValue1sub2, LongValue3);
    }

    @Test
    void test_LongValueMul() {
        LongValue LongValue1 = LongValue.builder().setValue(123L).build();
        LongValue LongValue2 = LongValue.builder().setValue(2L).build();
        LongValue LongValue1sub2 = (LongValue) LongValue2.mul(LongValue1);

        LongValue LongValue3 = LongValue.builder().setValue(246L).build();

        assertEquals(LongValue1sub2, LongValue3);
    }

    @Test
    void test_LongValueDiv() {
        LongValue LongValue1 = LongValue.builder().setValue(2L).build();
        LongValue LongValue2 = LongValue.builder().setValue(246L).build();
        LongValue LongValue1sub2 = (LongValue) LongValue2.div(LongValue1);

        LongValue LongValue3 = LongValue.builder().setValue(123L).build();

        assertEquals(LongValue1sub2, LongValue3);
    }
}
