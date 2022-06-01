package com.vex.vexillum.util;

import com.vex.vexillum.model.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class ReaderTest {

    private static final String pathStart = "src\\main\\resources\\com\\vex\\vexillum\\file\\";

    @Test
    public void reader() throws IOException {
        Data.getInstance();
        String[] facts = Reader.factReader(pathStart + "facts.txt");
        String[] flags = Reader.lineReader(pathStart + "flagPath.txt");
        String[] maps = Reader.lineReader(pathStart + "mapPath.txt");
        Assertions.assertEquals(Data.levelCount, facts.length);
        Assertions.assertEquals(Data.levelCount, flags.length);
        Assertions.assertEquals(Data.levelCount, maps.length);
        Assertions.assertEquals(Data.levelCount, Reader.oneIntReader(pathStart + "totalNumberOfLevels.txt"));
    }

}
