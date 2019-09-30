package ru.otus.task01.dao;

import ru.otus.task01.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;



public class QuestionDaoImpl implements QuestionDao {


    @Override
    public Question readQuestion() {
        CSVRecord csvParser;
        try (InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("/questions.csv")) {


        } catch (IOException e) {
            e.printStackTrace();
        }


        return new Question("Как дела");
    }
}
