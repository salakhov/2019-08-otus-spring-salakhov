package ru.otus.task04.domain;
import java.util.List;

/**
 * Тест. Сущьность для хранения всего теста.
 */
public class StudentTest {
    private List<Puzzle> puzzleList;

    public StudentTest() {
    }

    public List<Puzzle> getPuzzleList() {
        return puzzleList;
    }

    public void setPuzzleList(List<Puzzle> puzzleList) {
        this.puzzleList = puzzleList;
    }
}
