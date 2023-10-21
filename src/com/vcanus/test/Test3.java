package com.vcanus.test;

public class Test3 {
    // 재귀 함수를 사용하여 팩토리얼을 계산하는 함수
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("음수 값은 처리할 수 없습니다.");
        }

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
    public static void main(String[] args) {
        long result = factorial(4);
        System.out.println(result);
        
        long exception = factorial(-1); 
        System.out.println(exception);
    }
}
