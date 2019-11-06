package ru.otus.task04.dao;

import org.springframework.stereotype.Repository;
import ru.otus.task04.config.AppProperties;
import ru.otus.task04.domain.Answer;
import ru.otus.task04.domain.Puzzle;
import ru.otus.task04.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.task04.domain.StudentTest;

@Repository
public class TestDaoImpl implements TestDao {
    private final String resource;

    public TestDaoImpl(AppProperties appProperties) {
        this.resource = appProperties.getFilepath();
    }

    @Override
    public StudentTest read() {
        StudentTest test = new StudentTest();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream(resource)))) {
            System.out.println("1");
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
