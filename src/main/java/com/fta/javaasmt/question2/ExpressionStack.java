package com.fta.javaasmt.question2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpressionStack {
    private static final Logger logger = LogManager.getLogger(ExpressionStack.class.getName());

    private int top = -1;
    private char[] items = new char[100000];

    public void push(char expressionValue) {

        if (top == 99999) {
            logger.info("Stack full");
        } else {
            items[++top] = expressionValue;
        }
    }

    public char pop() {
        if (top == -1) {
            logger.info("Underflow error");
            return '\0';
        } else {
            char element = items[top];
            top--;
            return element;
        }
    }

    public boolean isEmpty() {
      return (top ==-1);
    }

    public char peek() {
        if (top < 0) {
            logger.info("Stack is Empty");
            return 0;
        } else {
            return items[top];
        }
    }

}
