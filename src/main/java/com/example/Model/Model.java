package com.example.Model;

import com.example.Teams.Teams;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Model {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static String timeStamp = dateFormat.format(new Date());

    public static HashMap<Integer, Teams> teams = new HashMap<>(){{
       put(1,new Teams("Lyons","23", timeStamp));
        put(2,new Teams("Eagles","32", timeStamp));
        put(3,new Teams("Bears","41", timeStamp));
        put(4,new Teams("Dogs","50", timeStamp));
        put(5,new Teams("Cats","68", timeStamp));
    }};


}
