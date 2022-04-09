import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntValueTest {

    @Test
    void test_IntValueBuilt_Equals_IntValueCreated() {
        IntValue intValue1 = IntValue.builder().setValue(123).build();
        IntValue intValue2 = (IntValue) IntValue.create("123");
        assertEquals(intValue1, intValue2);
    }

    @Test
    void test_IntValueBuilt_Eq_IntValueCreated() {
        IntValue intValue1 = IntValue.builder().setValue(123).build();
        IntValue intValue2 = (IntValue) IntValue.create("123");
        assertEquals(true, intValue1.eq(intValue1));
        assertEquals(false, intValue1.eq(intValue2));
    }

    @Test
    void test_IntValueBuilt_Lte_IntValueCreated() {
        IntValue intValue1 = IntValue.builder().setValue(12).build();
        IntValue intValue2 = (IntValue) IntValue.create("123");
        assertEquals(false, intValue2.lte(intValue1));
        assertEquals(true, intValue1.lte(intValue2));
    }

    @Test
    void test_IntValueBuilt_Gte_IntValueCreated() {
        IntValue intValue1 = IntValue.builder().setValue(1234).build();
        IntValue intValue2 = (IntValue) IntValue.create("123");
        assertEquals(false, intValue2.gte(intValue1));
        assertEquals(true, intValue1.gte(intValue2));
    }

    @Test
    void test_BuildIntValueNull_NullPointerException() {
        Integer nullObject = null;
        IntValue.Builder builder = IntValue.builder();
        assertThrows(NullPointerException.class, () -> builder.setValue(nullObject));
    }

    @Test
    void test_IntValueAdd() {
        IntValue intValue1 = IntValue.builder().setValue(123).build();
        IntValue intValue2 = IntValue.builder().setValue(456).build();
        IntValue intValue1plus2 = (IntValue) intValue1.add(intValue2);

        IntValue intValue3 = IntValue.builder().setValue(579).build();

        assertEquals(intValue1plus2, intValue3);
    }

    @Test
    void test_IntValueSub() {
        IntValue intValue1 = IntValue.builder().setValue(123).build();
        IntValue intValue2 = IntValue.builder().setValue(456).build();
        IntValue intValue1sub2 = (IntValue) intValue2.sub(intValue1);

        IntValue intValue3 = IntValue.builder().setValue(333).build();

        assertEquals(intValue1sub2, intValue3);
    }

    @Test
    void test_IntValueMul() {
        IntValue intValue1 = IntValue.builder().setValue(123).build();
        IntValue intValue2 = IntValue.builder().setValue(2).build();
        IntValue intValue1sub2 = (IntValue) intValue2.mul(intValue1);

        IntValue intValue3 = IntValue.builder().setValue(246).build();

        assertEquals(intValue1sub2, intValue3);
    }

    @Test
    void test_IntValueDiv() {
        IntValue intValue1 = IntValue.builder().setValue(2).build();
        IntValue intValue2 = IntValue.builder().setValue(246).build();
        IntValue intValue1sub2 = (IntValue) intValue2.div(intValue1);

        IntValue intValue3 = IntValue.builder().setValue(123).build();

        assertEquals(intValue1sub2, intValue3);
    }

    @Test
    void test_IntValue_AddBadValueType_IllegalArgumentException() {
        Value intValue1 = IntValue.builder().setValue(123).build();
        Value longValue1 = LongValue.builder().setValue(123L).build();

        assertThrows(IllegalArgumentException.class, () -> intValue1.add(longValue1));
    }
}
