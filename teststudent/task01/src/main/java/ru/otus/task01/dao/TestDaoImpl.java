package ru.otus.task01.dao;

import ru.otus.task01.domain.Answer;
import ru.otus.task01.domain.Puzzle;
import ru.otus.task01.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.task01.domain.Test;


public class TestDaoImpl implements TestDao {
    private String resource;

    public TestDaoImpl(String resource) {
        this.resource = resource;
    }

    @Override
    public Test read() {
        CSVRecord csvParser;
        Test test = new Test();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream(resource)))) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
            ArrayList<Puzzle> puzzleList = new ArrayList<Puzzle>();
            for (CSVRecord record:records){
                Question question = new Question(record.get("question"));
                Answer rightAnswer = new Answer(record.get("rightanswer"));
                ArrayList<Answer> answers = new ArrayList<Answer>();
                String answers_raw = record.get("answers");
                String []ans = answers_raw.split(":");
                for(String str:ans) {
                    Answer ans_tmp = new Answer(str);
                    answers.add(ans_tmp);
                }
                Puzzle puzzle = new Puzzle(question,rightAnswer,answers);
                puzzleList.add(puzzle);
            }
            test.setPuzzleList(puzzleList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return test;
    }
}
