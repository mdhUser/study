package com.maxwell.base.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MathQuestion {

    public static boolean prime(int num) {

        for (int i = 2; i < num; i++) {
            if (0 == num % i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> m = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        for (int i = 1; i < 25; i++) {
            for (int j = 1; j < 18; j++) {
                if (i * 5 + j * 7 == 129) {
                    if (prime(i))
                        m.add(i);

                    if (prime(j))
                        n.add(j);
                }
            }
        }

        n = n.stream().distinct().collect(Collectors.toList());
        m = m.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j < n.size(); j++) {
                if (5 * m.get(i) + 7 * n.get(j) == 129) {
                    System.out.println("m = " + m.get(i));
                    System.out.println("n = " + n.get(i));
                    System.out.println("m+n=" + (m.get(i) + n.get(j)));
                }
            }

        }

    }
}