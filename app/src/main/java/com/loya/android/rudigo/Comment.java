package com.loya.android.rudigo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 7/26/2017.
 */
public class Comment {
    private String comment;
    private String currentTime;

     public Comment(String comment,String currentTime){
         this.comment = comment;
         this.currentTime= currentTime;

     }
    public String getComment() {
        return comment;
    }

    public String getCurrentTime() {

        return currentTime;
    }


}
