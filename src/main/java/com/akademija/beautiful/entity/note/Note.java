package com.akademija.beautiful.entity.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "notes")
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "topic_name")
    private String topicName;

    @Column(columnDefinition = "TEXT(3000)", name = "note")
    private String note;

    public Note(long id, String topicName, String note) {
        super();
        this.id = id;
        this.topicName = topicName;
        this.note = note;
    }

    public Note(String topicName, String note) {
        super();
        this.topicName = topicName;
        this.note = note;
    }

    public Note() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setnId(long nId) {
        this.id = nId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", topicName=" + topicName + ", note=" + note + "]";
    }
}
