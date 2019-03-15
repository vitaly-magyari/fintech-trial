package com.fintech.internship.randoms;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomINN {
    public String getRandomINN() {

        int[] nums = new int[12];
        nums[0] = 7;
        nums[1] = 7;
        for (int i = 2; i < 10; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 9);
        }
        int[] basis = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += basis[i + 1] * nums[i];
        }
        nums[10] = (sum % 11) % 10;

        sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += basis[i] * nums[i];
        }
        nums[11] = (sum % 11) % 10;

        String stringINN = Arrays.toString(nums).
                replaceAll("\\[|\\]|,|\\s", "");

        return stringINN;
    }
}


