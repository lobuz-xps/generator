package com.pg.scripts.n1qlgenerator.generator;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class IdGenerator {

    private static Random random = new Random();

    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public static int categoryId() {
        int rand = (int) (Math.random() * 7 + 1);
        return rand;
    }

    public static double getLat() {

        double min = 52.174252;
        double max = 52.302461;

        double value = min + (max - min) * random.nextDouble();
        return value;
    }

    public static double getLon() {

        double min = 20.903883;
        double max = 21.169336;

        double value = min + (max - min) * random.nextDouble();
        return value;
    }

    public static int getDiscount() {

        int rand = (int) (Math.random() * 60 + 5);
        return rand;
    }

    public static String getPrefixLogin(){

        StringBuilder builder = new StringBuilder();
        IntStream ints = random.ints(3, 0, 9);
        ints.forEach(i -> builder.append(i));
        return builder.toString();
    }


}
