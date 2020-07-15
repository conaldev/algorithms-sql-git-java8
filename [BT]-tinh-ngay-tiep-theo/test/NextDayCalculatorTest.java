import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.jupiter.api.Assertions.*;


    public class NextDayCalculatorTest {
        @Test
        @DisplayName("Testing 1/1/2018")
        public void testFindNextDay01012018() {
            int day = 1;
            int month = 1;
            int year = 2018;
            String expected = "2/1/2018";
            String result = NextDayCalculator.nextDayCalculator(1,1,2018);
            assertEquals(expected,result);
        }
        @Test
        @DisplayName("Testing 31/1/2018")
        public void testFindNextDay31012018() {
            int day = 31;
            int month = 1;
            int year = 2018;
            String expected = "1/2/2018";
            String result = NextDayCalculator.nextDayCalculator(day,month,year);
            assertEquals(expected,result);
        }
        @Test
        @DisplayName("Testing 30/4/2018")
        public void testFindNextDay30042018() {
            int day = 30;
            int month = 4;
            int year = 2018;
            String expected = "1/5/2018";
            String result = NextDayCalculator.nextDayCalculator(day,month,year);
            assertEquals(expected,result);
        }
        @Test
        @DisplayName("Testing 28/02/2018")
        public void testFindNextDay28022018() {
            int day = 28;
            int month = 2;
            int year = 2018;
            String expected = "1/3/2018";
            String result = NextDayCalculator.nextDayCalculator(day,month,year);
            assertEquals(expected,result);
        }
        @Test
        @DisplayName("Testing 29/02/2020")
        public void testFindNextDay29020202() {
            int day = 29;
            int month = 2;
            int year = 2020;
            String expected = "1/3/2020";
            String result = NextDayCalculator.nextDayCalculator(day,month,year);
            assertEquals(expected,result);
        }
        @Test
        @DisplayName("Testing 31/12/2018")
        public void testFindNextDay31122018() {
            int day = 31;
            int month = 12;
            int year = 2018;
            String expected = "1/1/2019";
            String result = NextDayCalculator.nextDayCalculator(day,month,year);
            assertEquals(expected,result);
        }


}