package com.vex.vexillum.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomTest {

    @Test
    public void randomizer() {
        Random.getInstance();
        for (int i = 0; i < 100; i++) {
            Assertions.assertNotEquals(0, Random.randomizer(1, 5));
            Assertions.assertNotEquals(6, Random.randomizer(1, 5));
        }
    }

}
