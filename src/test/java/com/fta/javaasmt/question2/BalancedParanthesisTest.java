package com.fta.javaasmt.question2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BalancedParanthesisTest {
    private static final Logger logger = LogManager.getLogger(BalancedParanthesisTest.class.getName());

    @DataProvider(name = "testData")
    public Object[][] testData() {

        return new Object[][]
                {
                        {"src\\main\\resources\\input1.txt\\", "no", 1642},
                        {"src\\main\\resources\\input2.txt\\", "yes", 5},
                        {"src\\main\\resources\\input3.txt\\", "yes", 4},
                        {"src\\main\\resources\\input4.txt\\", "yes", 4},
                        {"src\\main\\resources\\input5.txt\\", "yes", 2},
                        {"src\\main\\resources\\input6.txt\\", "no", 1},
                        {"src\\main\\resources\\input7.txt\\", "no", 2},
                        {"src\\main\\resources\\input8.txt\\", "no", 0}


                };
    }

    @Test(dataProvider = "testData")
    public void allTests(String filePath, String expectedResult1, int expectedResult2) throws FileNotFoundException {

        FileReader fileReader = new FileReader(filePath);
        Scanner inFile = new Scanner(fileReader);
        String line = inFile.nextLine();
        inFile.close();
        String expression = line;
        char[] stringToCharArray = expression.toCharArray();
        StandardExpression expressionResult = BalancedParanthesis.isBalancedExpression(expression);
        String actualResult1 = expressionResult.getBalanceExpression();
        int actualResult2 = expressionResult.getCounter();
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        logger.info("Expected Result Balanced String--> {}", expectedResult1);
        logger.info("Actual Result  Balanced String --> {}", actualResult1);
        logger.info("Expected Result Count --> {}", expectedResult2);
        logger.info("Actual Result  Count --> {}", actualResult2);

    }

}
