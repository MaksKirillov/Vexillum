package com.vex.vexillum.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RandomTest {

    @Test
    public void randomizer() {
        Random.getInstance();
        for (int i = 0; i < 100; i++) {
            int num = Random.randomizer(1, 5);
            Assertions.assertTrue(num > 0 && num < 6);
        }
    }

}
