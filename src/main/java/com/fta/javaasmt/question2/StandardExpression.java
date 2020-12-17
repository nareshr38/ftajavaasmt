package com.fta.javaasmt.question2;

public class StandardExpression {
    private int counter;
    private String balanceExpression;

    public StandardExpression(int counter, String balanceExpression){
        this.counter = counter;
        this.balanceExpression = balanceExpression;
    }
    public int getCounter(){
        return counter;
    }
    public String getBalanceExpression(){
        return balanceExpression;
    }
}


