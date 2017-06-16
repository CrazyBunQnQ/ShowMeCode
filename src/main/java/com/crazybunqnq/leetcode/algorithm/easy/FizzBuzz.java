package com.crazybunqnq.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
 * "11", "Fizz", "13", "14", "FizzBuzz" ]
 *
 * @author Administrator
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String a = "Fizz";
        String b = "Buzz";
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if ((i) % 15 == 0) {
                result.add(a + b);
            } else if ((i) % 3 == 0) {
                result.add(a);
            } else if ((i) % 5 == 0) {
                result.add(b);
            } else {
                result.add(i + "");
            }
        }
        return result;
    }
}
