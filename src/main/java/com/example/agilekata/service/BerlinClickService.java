package com.example.agilekata.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BerlinClickService {
    public static String digitalTimeToBerlinTime(String digitalTime) {
        validateDigitaltime(digitalTime);
        List<String> time = Arrays.asList(digitalTime.split(":"));
        System.out.println(time);
        int seconds = Integer.parseInt(time.get(2));
        int minutes = Integer.parseInt(time.get(1));
        int hours = Integer.parseInt(time.get(0));
        return berlinClock(getHours(hours), getMinutes(minutes), getSeconds(seconds));
    }

    private static void validateDigitaltime(String digitalTime) {
        List<String> time = Arrays.asList(digitalTime.split(":"));
        if (time.size() != 3) {
            throw new IllegalArgumentException("digital time format is HH:MM:ss example 12:15:16");
        }
        try{
            time.stream().map(Integer::parseInt).collect(Collectors.toList());
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
            throw new IllegalArgumentException("digital time format is HH:MM:ss example 12:15:16");
        }

    }

    private static void validateBerlinTime(String berlinTime) {
        if(berlinTime.length()!=24){
            throw new IllegalArgumentException("berlin time format is ORROORRROYYROOOOOOOOYYOO");
        };
    }


    public static String getHours(int hours) {
        int numberTopHourLamps = hours / 5;
        int numberBottomHourLamps = hours % 5;

        StringBuilder sb = new StringBuilder();
        sb.append(getLampRow(4, numberTopHourLamps, "R"))
                .append(getLampRow(4, numberBottomHourLamps, "R"));

        return sb.toString();
    }

    public static String getDigitalTimeFromBerlinTime(String berlinTime) {
        if (berlinTime.length() != 24) {
            throw new IllegalArgumentException("Berlin clock is made up of 24 digits you passed " + berlinTime.length());
        } else {
            String firstLine = berlinTime.substring(0, 1);
            String secondLine = berlinTime.substring(1, 5);
            String thirdLine = berlinTime.substring(5, 9);
            String fourthLine = berlinTime.substring(9, 20);
            String fifthLine = berlinTime.substring(20, 24);

            String seconds = getSecondsFromBerlinTime(firstLine);
            String minutes = getMinutesFromBerlinTime(fourthLine, fifthLine);

            String hours = getHoursFromBerlinTime(secondLine, thirdLine);
            return hours + ":" + minutes + ":" + seconds;
        }


    }

    public static String getSeconds(int seconds) {
        return seconds % 2 == 0 ? "Y" : "O";
    }


    private static String getLampRow(int totalNumberLamps, int numberLampsOn, String lampSymbol) {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, totalNumberLamps)
                .forEach(i -> sb.append(i <= numberLampsOn ? lampSymbol : "O"));
        return sb.toString();
    }

    public static String getMinutes(int minutes) {
        int numberTopMinutesLamps = minutes / 5;
        int numberBottomMinutesLamps = minutes % 5;

        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, 11)
                .forEach(i -> sb.append(i <= numberTopMinutesLamps ? getMinuteLampColour(i) : "O"));
        sb.append(getLampRow(4, numberBottomMinutesLamps, "Y"));

        return sb.toString();
    }


    public static String getMinuteLampColour(int index) {
        return index % 3 == 0 ? "R" : "Y";
    }

    public static String berlinClock(String hours, String minutes, String seconds) {
        return seconds + hours + minutes;
    }

    public static int getFirstLine(String firstLine) {
        return (firstLine == "Y") ? 0 : 1;
    }

    public static int getSecondLine(String secondLine) {

        return Math.toIntExact(5 * secondLine.chars().filter(c -> c == 'R').count());
    }

    public static int getThirdLine(String thirdLine) {
        return Math.toIntExact(thirdLine.chars().filter(c -> c == 'R').count());
    }

    public static int getFourthLine(String fourthLine) {
        return (Math.toIntExact(5 * fourthLine.chars().filter(c -> (c == 'Y') || (c == 'R')).count()));
    }

    public static int getFifthLine(String fifthLine) {
        return Math.toIntExact(fifthLine.chars().filter(c -> c == 'Y').count());
    }

    public static String getSecondsFromBerlinTime(String firstLine) {
        return "" + getFirstLine(firstLine);
    }

    public static String getHoursFromBerlinTime(String secondLine, String thirdLine) {
        int hours = getSecondLine(secondLine) + getThirdLine(thirdLine);
        return "" + hours;
    }

    public static String getMinutesFromBerlinTime(String fourthLine, String fifthLine) {
        int minutes = getFourthLine(fourthLine) + getFifthLine(fifthLine);
        return "" + minutes;
    }

}
