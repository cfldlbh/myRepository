package com.lbh.cfld.utils;

public class Result {
    private boolean resultFlag;
    private String message;
    public Result(boolean flag,String message){
        this.resultFlag = flag;
        this.message = message;
    }

    public void setFlag(boolean flag) {
        this.resultFlag = flag;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResultFlag() {
        return resultFlag;
    }

    public Result(){

    }
}
