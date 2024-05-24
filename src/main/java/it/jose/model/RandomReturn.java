package it.jose.model;

import java.util.Random;

public class RandomReturn {
    private static Random r = new Random();

    public static int getRandomInt(int numeroMax) {
        return r.nextInt(numeroMax + 1);
    }
}
