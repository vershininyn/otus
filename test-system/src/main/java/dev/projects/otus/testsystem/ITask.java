package dev.projects.otus.testsystem;

import java.util.List;

public interface ITask {
    boolean run(List<String> inArgs, List<String> outArgs);
}
