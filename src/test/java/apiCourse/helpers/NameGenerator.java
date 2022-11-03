package apiCourse.helpers;

import java.nio.charset.Charset;
import java.util.Random;

public class NameGenerator {
    private String name;

    public void setName(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        this.name = buffer.toString();
    }

    public String getName(){
        return name;
    }
}
