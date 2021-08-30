package util;

import java.util.Random;

public class StringUtils {

    private static final Random random = new Random();

    public static String createRandomMailSubject(){
        return  "a" + random.nextInt(4000) +  "@a.a";
    }
}
