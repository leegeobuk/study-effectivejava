package chapter3.hashCode;

import chapter3.equals.PhoneNumber;
import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {
    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(map);
        System.out.println(map.get(new PhoneNumber(707, 867, 5309)));
        PhoneNumber pn = new PhoneNumber(707, 867, 309);
        System.out.println(pn);
    }
}
