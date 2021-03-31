package com.zemoso.assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.util.Calendar.YEAR;

public class KycRange {

    private static Date registrationDate = null;
    private static Date currentDate = null;
    private static final Calendar registrationDateCalendarObject = Calendar.getInstance();
    private static final Calendar currentDateCalendarObject = Calendar.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String extraBlankLineReader_NotUsedAnywhere = scanner.nextLine();

        for(int i = 0; i < testCases; i++) {
            String dates = scanner.nextLine();
            convertStringDateToDateObject(dates);

            if(isRegistrationDateMoreThanAYearApart(getDifferenceBetweenDatesInDays()))
                printThirtyPlusMinusDays();
            else
                System.out.println("No Range");
        }
    }

    private static void convertStringDateToDateObject(String dates) {
        String[] datesArr = dates.split(" ");

        try {
            registrationDate = new SimpleDateFormat("dd-MM-yyyy").parse(datesArr[0]);
            currentDate = new SimpleDateFormat("dd-MM-yyyy").parse(datesArr[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean isRegistrationDateMoreThanAYearApart(int daysSinceRegistration) {
        return daysSinceRegistration > 335; // 335 is to accommodate -30 days.
    }

    private static int getDifferenceBetweenDatesInDays() {
        long timeSinceRegistration = currentDate.getTime() - registrationDate.getTime();
        int daysSinceRegistration = (int) (timeSinceRegistration/ (1000 * 60 * 60 * 24));

        return daysSinceRegistration;
    }

    private static void printThirtyPlusMinusDays() {
        registrationDateCalendarObject.setTime(registrationDate);
        currentDateCalendarObject.setTime(currentDate);
        setRegistrationDateYearToCurrentYear();
        printRangeInGivenFormat();
    }

    private static void setRegistrationDateYearToCurrentYear() {
        int currentYear = currentDateCalendarObject.get(YEAR);
        registrationDateCalendarObject.set(YEAR, currentYear);
    }

    private static void printRangeInGivenFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        registrationDateCalendarObject.add(Calendar.DATE, -30);
        System.out.print(sdf.format(registrationDateCalendarObject.getTime()));
        registrationDateCalendarObject.add(Calendar.DATE, 60);
        if(isCurrentDateBeforeRegistrationEndDate())
            System.out.println("\t " + sdf.format(currentDateCalendarObject.getTime()));
        else
            System.out.println("\t " + sdf.format(registrationDateCalendarObject.getTime()));
    }

    private static boolean isCurrentDateBeforeRegistrationEndDate() {
        return currentDateCalendarObject.before(registrationDateCalendarObject);
    }

}