package dev.projects.otus.luckyticket;

import dev.projects.otus.testsystem.TestSystem;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        LuckyTicket ticketTask = new LuckyTicket();

        File directory = Path.of("/home/dev/projects/java/jotus/otus/luckyticket/src/main/resources/1.Tickets").toFile();

        TestSystem.runTests(directory, ticketTask);
    }
}
