package chapter2.unnecessary_objects;

import java.util.regex.Pattern;
/*
By declaring constant ROMAN, the performance is enhanced greatly compared to
isRomanNumeral creating Pattern instance every time when it's called.
This due to limiting of number of objects being created.
 */
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})$" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
