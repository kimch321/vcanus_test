package com.vcanus.test;

public class Test2 {
	public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.add(4).add(5).subtract(3).out();
        System.out.println(result); // 결과 출력: 6
    }
}


class Calculator {
    private int result;

    public Calculator add(int num) {
        result += num;
        return this;
    }

    public Calculator subtract(int num) {
        result -= num;
        return this;
    }
    
    public Calculator divided(int num) {
        result /= num;
        return this;
    }
    
    public Calculator multiple(int num) {
        result *= num;
        return this;
    }

    public int out() {
        return result;
    }
}