package data.util;

import java.math.BigInteger;

public class Validation {
    public static boolean isValidatedIdx(BigInteger idx) {
        BigInteger bigInteger = new BigInteger("0");

        if (idx.compareTo(bigInteger) == -1) {
            return false;
        }
        return true;
    }
}
