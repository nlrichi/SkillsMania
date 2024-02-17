package org.example.java_mvc_base.repo;

import jakarta.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.example.java_mvc_base.model.Choice;
import org.example.java_mvc_base.model.Course;
import org.example.java_mvc_base.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseInitializer {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @PostConstruct
    public void init() {
        createMissingCourses();
    }

    private void createMissingCourses() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.csv");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                String courseName = record.get("course");
                String questionText = record.get("question");
                String trueChoiceText = record.get("trueChoice");
                String falseChoice1Text = record.get("falseChoice1");
                String falseChoice2Text = record.get("falseChoice2");
                String falseChoice3Text = record.get("falseChoice3");

                Course course = courseRepository.findByCourseName(courseName);
                if (course == null) {
                    course = new Course();
                    course.setCourseName(courseName);
                    courseRepository.save(course);
                }

                Question question = createQuestion(course, questionText, trueChoiceText, falseChoice1Text, falseChoice2Text, falseChoice3Text);

                questionRepository.save(question);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Question createQuestion(Course course, String questionText, String trueText, String falseText1, String falseText2, String falseText3) {
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setCourse(course);

        Choice falseChoice1 = new Choice();
        falseChoice1.setQuestion(question);
        falseChoice1.setChoiceText(falseText1);
        falseChoice1.setIsTrue(false);

        Choice falseChoice2 = new Choice();
        falseChoice2.setQuestion(question);
        falseChoice2.setChoiceText(falseText2);
        falseChoice2.setIsTrue(false);

        Choice falseChoice3 = new Choice();
        falseChoice3.setQuestion(question);
        falseChoice3.setChoiceText(falseText3);
        falseChoice3.setIsTrue(false);

        Choice trueChoice = new Choice();
        trueChoice.setQuestion(question);
        trueChoice.setChoiceText(trueText);
        trueChoice.setIsTrue(true);

        List<Choice> choices = new ArrayList<>();
        choices.add(falseChoice1);
        choices.add(falseChoice2);
        choices.add(falseChoice3);
        choices.add(trueChoice);

        question.setChoices(choices);

        return question;
    }
}
