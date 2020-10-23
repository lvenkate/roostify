package org.roostify.repository;

import java.util.HashMap;

public class StatesCapital {

    public final static HashMap<String, String> map = new HashMap<String, String>() {
        {
            put("Alabama", "Montgomery");
            put("Alaska", "Juneau");
            put("Arizona", "Phoenix");
            put("Arkansas", "Little Rock");
            put("California", "Sacramento");
            put("Colorado", "Denver");
            put("Connecticut", "Hartford");
            put("Delaware", "Dover");
            put("Florida", "Tallahassee");
            put("Georgia", "Atlanta");
            put("Hawaii", "Honolulu");
            put("Idaho", "Boise");
            put("Illinois", "Springfield");
            put("Indiana", "Indianapolis");
            put("Iowa", "Des Moines");
            put("Kansas", "Topeka");
            put("Kentucky", "Frankfort");
            put("Louisiana", "Baton Rouge");
            put("Maine", "Augusta");
            put("Maryland", "Annapolis");
            put("Massachusetts", "Boston");
            put("Michigan", "Lansing");
            put("Minnesota", "Saint Paul");
            put("Mississippi", "Jackson");
            put("Missouri", "Jefferson City");
            put("Montana", "Helena");
            put("Nebraska", "Lincoln");
            put("Nevada", "Carson City");
            put("New Hampshire", "Concord");
            put("New Jersey", "Trenton");
            put("New Mexico", "Santa Fe");
            put("New York", "Albany");
            put("North Carolina", "Raleigh");
            put("North Dakota", "Bismarck");
            put("Ohio", "Columbus");
            put("Oklahoma", "Oklahoma City");
            put("Oregon", "Salem");
            put("Pennsylvania", "Harrisburg");
            put("Rhode Island", "Providence");
            put("South Carolina", "Columbia");
            put("South Dakota", "Pierre");
            put("Tennessee", "Nashville");
            put("Texas", "Austin");
            put("Utah", "Salt Lake City");
            put("Vermont", "Montpelier");
            put("Virginia", "Richmond");
            put("Washington", "Olympia");
            put("West Virginia", "Charleston");
            put("Wisconsin", "Madison");
            put("Wyoming", "Cheyenne");
        }

    };
    public static String[] getStates() {
        String[] s = new String[map.keySet().size()];
        return map.keySet().toArray(s);
    }
    public static String[] getValues() {
        String[] v = new String[map.values().size()];
        return map.values().toArray( new String[map.values().size()]);
    }
}


