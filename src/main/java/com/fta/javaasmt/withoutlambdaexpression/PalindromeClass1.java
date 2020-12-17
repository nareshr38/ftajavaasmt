package com.fta.javaasmt.withoutlambdaexpression;

public class PalindromeClass1 implements Palindrome1 {

    @Override
    public boolean isPalindromeW(String string) {
        StringBuilder reverse = new StringBuilder(string).reverse();
        return (reverse.toString()).equals(string);
    }
}
