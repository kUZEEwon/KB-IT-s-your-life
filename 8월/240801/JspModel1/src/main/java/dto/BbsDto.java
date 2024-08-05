package dto;

import java.io.Serializable;
import java.lang.reflect.Member;

public class BbsDto implements Serializable {

    private int seq;
    private String id;

    private String title;
    private String content;
    private String wdate;

    private int del;
    private int readcount;

    public BbsDto() {
    }

    public BbsDto(int seq, String id, String title, String content, String wdate, int del, int readcount) {
        this.seq = seq;
        this.id = id;
        this.title = title;
        this.content = content;
        this.wdate = wdate;
        this.del = del;
        this.readcount = readcount;
    }

    public BbsDto(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWdate() {
        return wdate;
    }

    public void setWdate(String wdate) {
        this.wdate = wdate;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    @Override
    public String toString() {
        return "BbsDto{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", wdate='" + wdate + '\'' +
                ", del=" + del +
                ", readcount=" + readcount +
                '}';
    }
}
