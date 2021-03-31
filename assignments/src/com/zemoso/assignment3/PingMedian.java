package com.zemoso.assignment3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PingMedian {

    private static final Runtime pingRunner = Runtime.getRuntime();
    private static final List<String> pings = new ArrayList<>();
    private static final List<Double> packetTimes = new ArrayList<>();

    public static void main(String[] args) {
        runPingCommand("ping -c 5 google.com");
        findTimeValues();
        findMedian();
    }

    private static void runPingCommand(String command) {
        try {
            Process proc1 = pingRunner.exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                pings.add(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findTimeValues() {
        for(String ping: pings){
            if(ping.contains("time=")){
                packetTimes.add(Double.parseDouble(ping.substring(ping.indexOf("time=") + 5, ping.indexOf(" ms"))));
            }
        }
    }

    private static void findMedian() {
        Collections.sort(packetTimes);
        double median;
        if (packetTimes.size() % 2 == 0)
            median = ((double) packetTimes.get(packetTimes.size()/2) + (double) packetTimes.get(packetTimes.size()/2 - 1))/2;
        else
            median = (double) packetTimes.get(packetTimes.size()/2);
        System.out.println("Median: " + median);
    }

}
