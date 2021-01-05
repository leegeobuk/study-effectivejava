package chapter3.equals;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;
    //Comparator method chaining
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "Area code");
        this.prefix = rangeCheck(prefix, 999, "Prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "Line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    // compareTo using comparator
    @Override
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }

    /*
    1. Check if the input references itself.
    2. instanceof keyword checks whether it is of the same type. It also returns false for null.
    3. Cast the input type. It will never fail if it passed instanceof keyword.
    4. Check if the "core" fields are same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return lineNum == pn.lineNum && prefix == pn.prefix && areaCode == pn.areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public PhoneNumber clone() throws CloneNotSupportedException {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}
