import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShortValueTest {

    @Test
    void test_ShortValueBuilt_Equals_ShortValueCreated() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short) 123).build();
        ShortValue ShortValue2 = (ShortValue) ShortValue.create("123");
        assertEquals(ShortValue1, ShortValue2);
    }

    @Test
    void test_ShortValueBuilt_Eq_ShortValueCreated() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)123).build();
        ShortValue ShortValue2 = (ShortValue) ShortValue.create("123");
        assertEquals(true, ShortValue1.eq(ShortValue1));
        assertEquals(false, ShortValue1.eq(ShortValue2));
    }

    @Test
    void test_ShortValueBuilt_Lte_ShortValueCreated() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)12).build();
        ShortValue ShortValue2 = (ShortValue) ShortValue.create("123");
        assertEquals(false, ShortValue2.lte(ShortValue1));
        assertEquals(true, ShortValue1.lte(ShortValue2));
    }

    @Test
    void test_ShortValueBuilt_Gte_ShortValueCreated() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)1234).build();
        ShortValue ShortValue2 = (ShortValue) ShortValue.create("123");
        assertEquals(false, ShortValue2.gte(ShortValue1));
        assertEquals(true, ShortValue1.gte(ShortValue2));
    }

    @Test
    void test_BuildShortValueNull_NullPoShorterException() {
        Short nullObject = null;
        ShortValue.Builder builder = ShortValue.builder();
        assertThrows(NullPointerException.class, () -> builder.setValue(nullObject));
    }

    @Test
    void test_ShortValueAdd() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)123).build();
        ShortValue ShortValue2 = ShortValue.builder().setValue((short)456).build();
        ShortValue ShortValue1plus2 = (ShortValue) ShortValue1.add(ShortValue2);

        ShortValue ShortValue3 = ShortValue.builder().setValue((short)579).build();

        assertEquals(ShortValue1plus2, ShortValue3);
    }

    @Test
    void test_ShortValueSub() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)123).build();
        ShortValue ShortValue2 = ShortValue.builder().setValue((short)456).build();
        ShortValue ShortValue1sub2 = (ShortValue) ShortValue2.sub(ShortValue1);

        ShortValue ShortValue3 = ShortValue.builder().setValue((short)333).build();

        assertEquals(ShortValue1sub2, ShortValue3);
    }

    @Test
    void test_ShortValueMul() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)123).build();
        ShortValue ShortValue2 = ShortValue.builder().setValue((short)2).build();
        ShortValue ShortValue1sub2 = (ShortValue) ShortValue2.mul(ShortValue1);

        ShortValue ShortValue3 = ShortValue.builder().setValue((short)246).build();

        assertEquals(ShortValue1sub2, ShortValue3);
    }

    @Test
    void test_ShortValueDiv() {
        ShortValue ShortValue1 = ShortValue.builder().setValue((short)2).build();
        ShortValue ShortValue2 = ShortValue.builder().setValue((short)246).build();
        ShortValue ShortValue1sub2 = (ShortValue) ShortValue2.div(ShortValue1);

        ShortValue ShortValue3 = ShortValue.builder().setValue((short)123).build();

        assertEquals(ShortValue1sub2, ShortValue3);
    }
}
