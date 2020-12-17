package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaTreeMap9;
import com.fta.javaasmt.withoutlambdaexpression.TreeMap9;
import com.fta.javaasmt.withoutlambdaexpressiontests.TreeMapTests9;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

public class LamdaTreeMapTests9 {

    private static final Logger logger = LogManager.getLogger(TreeMapTests9.class.getName());

    @Test
    public void testSortNumTreeSet() {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.put("A", 3);
        map.put("B", 2);
        map.put("C", 1);
        map.put("D", 4);
        logger.info(map);
        logger.info(new LamdaTreeMap9().lamdaEntriesSortedByValues(map));
    }
}
