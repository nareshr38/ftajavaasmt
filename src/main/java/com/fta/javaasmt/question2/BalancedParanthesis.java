package com.fta.javaasmt.question2;

public class BalancedParanthesis {
    private BalancedParanthesis() {
    }

    public static StandardExpression isBalancedExpression(String expression) {
        int lengthExpression = expression.length();
        int counter = 0;
        String isBalanced = "yes";

        if (expression.isEmpty()) {
            isBalanced = "yes";
        }

        ExpressionStack stack = new ExpressionStack();
        for (int expressionIndex = 0; expressionIndex < lengthExpression; expressionIndex++) {
            char currentExpressionValue = expression.charAt(expressionIndex);

            if (isOpenBrace(currentExpressionValue)) {
                stack.push(currentExpressionValue);
            }

            if (isClosedBrace(currentExpressionValue)) {
                if (stack.isEmpty()) {
                    isBalanced = "no";
                    break;
                }
                char lastExpressionValue = stack.peek();
                if (isMatchingPair(currentExpressionValue, lastExpressionValue)) {
                    stack.pop();
                    counter = counter + 1;
                } else
                    break;
            }
            if (stack.isEmpty()) {
                isBalanced = "yes";
            } else {
                isBalanced = "no";
            }
        }
        return new StandardExpression(counter, isBalanced);
    }

    private static boolean isOpenBrace(char currentExpressionValue) {
        return (currentExpressionValue == '{' ||
                currentExpressionValue == '(' ||
                currentExpressionValue == '[' ||
                currentExpressionValue == '<');
    }

    private static boolean isClosedBrace(char currentExpressionValue) {
        return (currentExpressionValue == '}' ||
                currentExpressionValue == ')' ||
                currentExpressionValue == ']' ||
                currentExpressionValue == '>');
    }

    private static boolean isMatchingPair(char currentExpressionValue, char lastExpressionValue) {
        return (currentExpressionValue == '}' && lastExpressionValue == '{' ||
                currentExpressionValue == ')' && lastExpressionValue == '(' ||
                currentExpressionValue == ']' && lastExpressionValue == '[' ||
                currentExpressionValue == '>' && lastExpressionValue == '<');
    }

}


