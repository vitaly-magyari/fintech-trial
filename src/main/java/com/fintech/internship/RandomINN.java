package com.fintech.internship;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomINN {
    public String getRandomINN() {

        int a = 7;
        int b = 7;
        int c = ThreadLocalRandom.current().nextInt(0, 4);
        int d = ThreadLocalRandom.current().nextInt(0, 9);
        int e = ThreadLocalRandom.current().nextInt(0, 9);
        int f = ThreadLocalRandom.current().nextInt(0, 9);
        int g = ThreadLocalRandom.current().nextInt(0, 9);
        int h = ThreadLocalRandom.current().nextInt(0, 9);
        int i = ThreadLocalRandom.current().nextInt(0, 9);
        int j = ThreadLocalRandom.current().nextInt(0, 9);

        int k = ((a * 7 + b * 2 + c * 4 + d * 10 + e * 3 + f * 5 + g * 9 + h * 4 + i * 6 + j * 8) % 11) % 10;
        int z = ((a * 3 + b * 7 + c * 2 + d * 4 + e * 10 + f * 3 + g * 5 + h * 9 + i * 4 + j * 6 + k * 8) % 11) % 10;

        String string1 = String.valueOf(a);
        String string2 = string1 + b + c + d + e + f + g + h + i + j + k + z;
        String string3 = String.valueOf(string2);

        return string3;
    }
}

//        int[] nums = new int[12];
//        nums[0] = 7;
//        nums[1] = 7;
//        for (int i = 2; i < 10; i++) {
//            nums[i] = ThreadLocalRandom.current().nextInt(0, 9);
//        }
//        int[] basis = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
//
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            sum += basis[i + 1] * nums[i];
//        }
//        nums[10] = (sum % 11) % 10;
//
//        sum = 0;
//        for (int i = 0; i < 11; i++) {
//            sum += basis[i] * nums[i];
//        }
//        nums[11] = (sum % 11) % 10;
//
//        return Arrays.toString(nums);
