package com.example.agilekata;

import com.example.agilekata.service.BerlinClickService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AgileKataApplicationTests {

    @Test
    public void testBerlinClock() {
        assertEquals("ORROORRROYYROOOOOOOOYYOO", BerlinClickService.digitalTimeToBerlinTime("13:17:1"));
        assertEquals("YRRRRRRROYYRYYROOOOOYYYY", BerlinClickService.digitalTimeToBerlinTime("23:34:42"));
    }

    @Test
    public void testSeconds() {
        assertEquals("Y", BerlinClickService.getSeconds(0));
        assertEquals("O", BerlinClickService.getSeconds(1));
        assertEquals("Y", BerlinClickService.getSeconds(42));
        assertEquals("O", BerlinClickService.getSeconds(59));
    }

    @Test
    public void testHours() {
        assertEquals("OOOOOOOO", BerlinClickService.getHours(0));
        assertEquals("RROORRRO", BerlinClickService.getHours(13));
        assertEquals("RRRRRRRO", BerlinClickService.getHours(23));
    }

    @Test
    public void testMinutes() {
        assertEquals("YYROOOOOOOOYYOO", BerlinClickService.getMinutes(17));
        assertEquals("YYRYYROOOOOYYYY", BerlinClickService.getMinutes(34));

    }

    @Test
    public void testDigitalClock() {
        assertEquals(BerlinClickService.getDigitalTimeFromBerlinTime("ORROORRROYYROOOOOOOOYYOO"), "13:17:1");
        assertEquals(BerlinClickService.getDigitalTimeFromBerlinTime("YRRRRRRROYYRYYROOOOOYYYY"), "23:34:1");
    }

    @Test
    public void testBerlinFirsLine() {
        assertEquals(BerlinClickService.getFirstLine("Y"), 0);
        assertEquals(BerlinClickService.getFirstLine("O"), 1);
    }
    @Test
    public void testBerlinSecondLine() {
        assertEquals(BerlinClickService.getSecondLine("RROO"), 10);
        assertEquals(BerlinClickService.getSecondLine("RRRO"), 15);
    }
    @Test
    public void testBerlinThirdLine() {
        assertEquals(BerlinClickService.getThirdLine("RROO"), 2);
        assertEquals(BerlinClickService.getThirdLine("RRRO"), 3);
    }
    @Test
    public void testBerlinFourthLine() {
        assertEquals(BerlinClickService.getFourthLine("YYOO0000000"), 10);
        assertEquals(BerlinClickService.getFourthLine("YYYOO000000"), 15);
    }
    @Test
    public void testBerlinFifthLine() {
        assertEquals(BerlinClickService.getFifthLine("YYOO"), 2);
        assertEquals(BerlinClickService.getFifthLine("YYYO"), 3);
    }

    @Test
    public  void  testBerlinHoursFromDigitaltime(){
        assertEquals(BerlinClickService.getHoursFromBerlinTime("RROO","RRRO"), "13");
        assertEquals(BerlinClickService.getHoursFromBerlinTime("RRRO","RRRO"), "18");
    }
    @Test
    public  void  testBerlinMinutesFromDigitaltime(){
        assertEquals(BerlinClickService.getMinutesFromBerlinTime("YYROOOOOOOO","YYOO"), "17");
        assertEquals(BerlinClickService.getMinutesFromBerlinTime("YYRYYROOOOO","YYOO"), "32");
    }
    @Test
    public  void  testBerlinSecondsFromDigitaltime(){
        assertEquals(BerlinClickService.getSecondsFromBerlinTime("Y"), "0");
        assertEquals(BerlinClickService.getSecondsFromBerlinTime("R"), "1");
    }

}
