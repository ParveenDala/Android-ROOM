package com.parveendala.android_room.models;

/*****
 * Parveen Dala
 * Android-ROOM
 */
public class Note {

    private int id;
    private String title;
    private String body;
    private String time;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
