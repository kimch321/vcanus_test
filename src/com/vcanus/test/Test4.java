package com.vcanus.test;

import java.math.BigInteger;

public class Test4 {

    public static void main(String[] args) {
        int n = 100000;
        BigInteger result = FactorialCalculator.calculateFactorial(n);
        System.out.println("팩토리얼 " + n + " 은: " + convertToScientificNotation(result));
    }

    // BigInteger를 지수 가수 형태로 변환하는 함수
    private static String convertToScientificNotation(BigInteger value) {
        String strValue = value.toString();
        int length = strValue.length();

        if (length <= 1) {
            return strValue;
        }

        // 가수와 지수 추출
        char sign = strValue.charAt(0);
        String mantissa = strValue.substring(1, 2);
        int exponent = length - 1;

        return sign + "." + mantissa + "E" + exponent;
    }
}

class FactorialCalculator {
    public static BigInteger calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수 값은 처리할 수 없습니다.");
        }

        return calculateFactorialInRange(1, n);
    }

    private static BigInteger calculateFactorialInRange(int start, int end) {
        if (start > end) {
            return BigInteger.ONE;
        }

        if (start == end) {
            return BigInteger.valueOf(start);
        }

        int mid = (start + end) / 2;
        BigInteger leftFactorial = calculateFactorialInRange(start, mid);
        BigInteger rightFactorial = calculateFactorialInRange(mid + 1, end);

        return leftFactorial.multiply(rightFactorial);
    }
}
