package com.vex.vexillum.util;

import com.vex.vexillum.model.Data;
import com.vex.vexillum.model.UserWorker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StatsTest {

    private static final String pathStart = "src\\main\\resources\\com\\vex\\vexillum\\file\\";

    @Test
    public void stats() throws FileNotFoundException {
        Data.getInstance();
        Stats.getInstance();
        UserWorker.deleteAllUsers();
        UserWorker.addUser("Max");
        UserWorker.addUser("Bill");
        int[][] stats = new int[2][6];
        Assertions.assertArrayEquals(stats, Stats.getStats());
        Stats.updateStats();

        UserWorker.currentUserInt = 0;
        Stats.changeNum(1, 0);
        Stats.changeNum(2, 1);
        Stats.changeNum(3, 2);
        Stats.changeNum(4, 3);
        Stats.changeNum(5, 4);
        Stats.changeNum(6, 5);
        UserWorker.currentUserInt = 1;
        Stats.changeNum(7, 0);
        Stats.changeNum(8, 1);
        Stats.changeNum(9, 2);
        Stats.changeNum(10, 3);
        Stats.changeNum(11, 4);
        Stats.changeNum(12, 5);
        stats = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
        };
        Assertions.assertArrayEquals(stats, Stats.getStats());
        UserWorker.currentUserInt = 0;
        Assertions.assertEquals(3, Stats.getAllFlags());
        Assertions.assertEquals(7, Stats.getAllFacts());
        Assertions.assertEquals(11, Stats.getAllMaps());
        Assertions.assertEquals(21, Stats.getAllAll());

        UserWorker.deleteAllUsers();
    }

    @Test
    public void levelStats() throws IOException {
        Data.getInstance();
        Stats.getInstance();
        UserWorker.deleteAllUsers();
        UserWorker.addUser("Max");
        UserWorker.addUser("Bill");

        Stats.changeLevelStat(1, 0, 1);
        String flagStats = Reader.reader(pathStart + "flagStats.txt");
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", flagStats);

        Stats.resetLevel(1);
        flagStats = Reader.reader(pathStart + "flagStats.txt");
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", flagStats);

        UserWorker.deleteAllUsers();
    }

}
