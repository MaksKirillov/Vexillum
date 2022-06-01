package com.vex.vexillum.model;

import com.vex.vexillum.util.Reader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class UserWorkerTest {

    private static final String pathStart = "src\\main\\resources\\com\\vex\\vexillum\\file\\";

    @Test
    public void user() throws IOException {
        Data.getInstance();
        UserWorker.deleteAllUsers();
        String users = Reader.reader(pathStart + "users.txt");
        String stats = Reader.reader(pathStart + "stats.txt");
        String flagStats = Reader.reader(pathStart + "flagStats.txt");
        String mapStats = Reader.reader(pathStart + "mapStats.txt");
        String factStats = Reader.reader(pathStart + "factStats.txt");
        Assertions.assertEquals(0, UserWorker.userCount);
        Assertions.assertEquals("NoUsers\n", users);
        Assertions.assertEquals("", stats);
        Assertions.assertEquals("", flagStats);
        Assertions.assertEquals("", mapStats);
        Assertions.assertEquals("", factStats);
        Assertions.assertTrue(UserWorker.noUsers());

        UserWorker.addUser("Max");
        users = Reader.reader(pathStart + "users.txt");
        stats = Reader.reader(pathStart + "stats.txt");
        flagStats = Reader.reader(pathStart + "flagStats.txt");
        mapStats = Reader.reader(pathStart + "mapStats.txt");
        factStats = Reader.reader(pathStart + "factStats.txt");
        Assertions.assertEquals(1, UserWorker.userCount);
        Assertions.assertEquals(0, UserWorker.currentUserInt);
        Assertions.assertEquals("Max\n", users);
        Assertions.assertEquals("0 0 0 0 0 0 \n", stats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", flagStats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", mapStats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", factStats);
        Assertions.assertFalse(UserWorker.noUsers());

        UserWorker.addUser("Bill");
        users = Reader.reader(pathStart + "users.txt");
        stats = Reader.reader(pathStart + "stats.txt");
        flagStats = Reader.reader(pathStart + "flagStats.txt");
        mapStats = Reader.reader(pathStart + "mapStats.txt");
        factStats = Reader.reader(pathStart + "factStats.txt");
        Assertions.assertEquals(2, UserWorker.userCount);
        Assertions.assertEquals(1, UserWorker.currentUserInt);
        Assertions.assertEquals("Max\nBill\n", users);
        Assertions.assertEquals("0 0 0 0 0 0 \n0 0 0 0 0 0 \n", stats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", flagStats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", mapStats);
        Assertions.assertEquals("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n", factStats);
        Assertions.assertFalse(UserWorker.noUsers());

        UserWorker.deleteAllUsers();
        users = Reader.reader(pathStart + "users.txt");
        stats = Reader.reader(pathStart + "stats.txt");
        flagStats = Reader.reader(pathStart + "flagStats.txt");
        mapStats = Reader.reader(pathStart + "mapStats.txt");
        factStats = Reader.reader(pathStart + "factStats.txt");
        Assertions.assertEquals(0, UserWorker.userCount);
        Assertions.assertEquals("NoUsers\n", users);
        Assertions.assertEquals("", stats);
        Assertions.assertEquals("", flagStats);
        Assertions.assertEquals("", mapStats);
        Assertions.assertEquals("", factStats);
        Assertions.assertTrue(UserWorker.noUsers());
    }

}
