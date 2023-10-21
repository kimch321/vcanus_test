package com.vcanus.test;

import java.math.BigInteger;

public class Test4 {

    public static void main(String[] args) {
        int n = 1000000;
        BigInteger result = FactorialCalculator.calculateFactorial(n);
        System.out.println("팩토리얼 " + n + " 은: " + result);
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