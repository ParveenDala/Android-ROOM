package com.parveendala.android_room.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*****
 * Parveen Dala
 * Android-ROOM
 */
@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String body;
    private String time;

    public Note(String title, String body, String time) {
        this.title = title;
        this.body = body;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

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
