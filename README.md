## agile Berlin clock kata
# Create a representation of the Berlin Clock for a given time (hh:mm:ss).
The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that blinks on/off every two seconds. The time is calculated by adding rectangular lamps.

The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

The lamps are switched on from left to right.

## Features of the Kata: 

# Digital time to berlin time 

input: 13:17:1

output: ORROORRROYYROOOOOOOOYYOO

# Berlin time to digital time 
input : ORROORRROYYROOOOOOOOYYOO
output: 13:17:1

## Tech stack 
* language java (version 17)
* framework spring 
* Tests Junit
* view thymeleaf. 
![image](https://user-images.githubusercontent.com/36473921/208371731-c2bf749d-ed01-408f-a57b-b5eabb40b767.png)

![image](https://user-images.githubusercontent.com/36473921/208371357-1aef0741-5572-4dce-b90e-df288acefa98.png)



test file 

https://github.com/landryfomena/berlinclock-agile-kata/blob/master/src/test/java/com/example/agilekata/AgileKataApplicationTests.java


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


the application is listening the port 8080

