import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeValueTest {

    @Test
    void test_DateTimeValueBuilt_Equals_DateTimeValueCreated() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(2007).setMonth(12).setDay(03).setHour(10).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2007-12-03T10:15");
        assertEquals(dateTimeValue1, dateTimeValue2);
    }

    @Test
    void test_DateTimeValueBuilt_Eq_DateTimeValueCreated() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(2007).setMonth(12).setDay(03).setHour(10).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2007-12-03T10:15");
        assertEquals(true, dateTimeValue1.eq(dateTimeValue1));
        assertEquals(false, dateTimeValue1.eq(dateTimeValue2));
    }

    @Test
    void test_DateTimeValueBuilt_Lte_DateTimeValueCreated() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(2007).setMonth(12).setDay(03).setHour(10).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2008-12-03T10:15");
        assertEquals(true, dateTimeValue1.lte(dateTimeValue1));
        assertEquals(true, dateTimeValue1.lte(dateTimeValue2));
        assertEquals(false, dateTimeValue2.lte(dateTimeValue1));

    }

    @Test
    void test_DateTimeValueBuilt_Gte_DateTimeValueCreated() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(2007).setMonth(12).setDay(03).setHour(10).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2008-12-03T10:15");
        assertEquals(true, dateTimeValue1.gte(dateTimeValue1));
        assertEquals(false, dateTimeValue1.gte(dateTimeValue2));
        assertEquals(true, dateTimeValue2.gte(dateTimeValue1));
    }

    @Test
    void test_DateTimeValueBuilt_Neq_DateTimeValueCreated() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(2007).setMonth(12).setDay(03).setHour(10).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2007-12-03T10:15");
        assertEquals(false, dateTimeValue1.neq(dateTimeValue1));
        assertEquals(true, dateTimeValue1.neq(dateTimeValue2));
    }

    @Test
    void test_DateTimeValueAdd() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(1).setMonth(1).setDay(1).setHour(1).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2007-11-03T10:15");
        DateTimeValue dateTimeValue1plus2 = (DateTimeValue) dateTimeValue1.add(dateTimeValue2);

        DateTimeValue dateTimeValue3 = (DateTimeValue) DateTimeValue.create("2008-12-04T11:30");

        assertEquals(dateTimeValue1plus2, dateTimeValue3);
    }

    @Test
    void test_DateTimeValueSub() {
        DateTimeValue dateTimeValue1 = DateTimeValue.builder().setYear(1).setMonth(1).setDay(1).setHour(1).setMinute(15).build();
        DateTimeValue dateTimeValue2 = (DateTimeValue) DateTimeValue.create("2007-11-03T10:15");
        DateTimeValue dateTimeValue1sub2 = (DateTimeValue) dateTimeValue2.sub(dateTimeValue1);

        DateTimeValue dateTimeValue3 = (DateTimeValue) DateTimeValue.create("2006-10-02T09:00");

        assertEquals(dateTimeValue1sub2, dateTimeValue3);
    }

}
