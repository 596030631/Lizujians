package com.lizujian.qrcode.bean;

public class Record {
   public Record(){}
   public Record(String bizdate,String content){
       this.bizdate = bizdate;
       this.content = content;
   }
    private String bizdate;
    private String content;

    public String getBizdate() {
        return bizdate;
    }

    public void setBizdate(String bizdate) {
        this.bizdate = bizdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void addNewRecord(){
        Record record = new Record();
        record.setBizdate(new Record().bizdate);
        record.setContent(new Record().content);
    }
}
