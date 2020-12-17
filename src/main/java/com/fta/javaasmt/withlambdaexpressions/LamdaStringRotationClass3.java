package com.fta.javaasmt.withlambdaexpressions;

public class LamdaStringRotationClass3 {

    public LamdaStringRotation3 stringRotationW = (str1, str2) -> {
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);


    };
}
