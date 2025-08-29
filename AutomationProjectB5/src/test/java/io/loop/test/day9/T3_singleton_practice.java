package io.loop.test.day9;

import org.testng.annotations.Test;

public class T3_singleton_practice {

    @Test
    public void googleTitle(){
        String str1 = T2_singleton_pattern_example.getWord();
        System.out.println("str1 =" + str1);

        System.out.println();

        String str2 = T2_singleton_pattern_example.getWord();
        System.out.println("str2 =" + str2);
    }

}
