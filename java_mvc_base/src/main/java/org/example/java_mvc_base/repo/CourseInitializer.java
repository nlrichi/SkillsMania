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
    private CourseRepository courseRepository; // allows access to courses
    @Autowired
    private QuestionRepository questionRepository; // allows access to questions

    @PostConstruct
    public void init() {
        createMissingCourses();
    }

    // creates a list of courses if they are not there
    private void createMissingCourses() {
        try {
            // reads csv of questions
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.csv");
            // give error if not found
            assert inputStream != null;
            // create a reader object
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // parses the csv using the reader
            CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            // convert to a list of CSVrecords
            List<CSVRecord> records = csvParser.getRecords();
            // loop through the records
            for (CSVRecord record : records) {
                String courseName = record.get("course");
                String questionText = record.get("question");
                String trueChoiceText = record.get("trueChoice");
                String falseChoice1Text = record.get("falseChoice1");
                String falseChoice2Text = record.get("falseChoice2");
                String falseChoice3Text = record.get("falseChoice3");

                // create course if not found
                Course course = courseRepository.findByCourseName(courseName);
                if (course == null) {
                    // create course
                    course = new Course();
                    course.setCourseName(courseName);
                    // save to db
                    courseRepository.save(course);
                    // create question
                    Question question = createQuestion(course, questionText, trueChoiceText, falseChoice1Text, falseChoice2Text, falseChoice3Text);
                    // save to db
                    questionRepository.save(question);
                }


            }
            // close the reader
            reader.close();
        // if error occurs print the error
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // creates question for a course
    private Question createQuestion(Course course, String questionText, String trueText, String falseText1, String falseText2, String falseText3) {
        // create question
        Question question = new Question();
        // the question text that will be displayed
        question.setQuestionText(questionText);
        // select course that the question is for
        question.setCourse(course);

        // create 3 fake and 1 real choice
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

        // add choices to a list
        List<Choice> choices = new ArrayList<>();
        choices.add(falseChoice1);
        choices.add(falseChoice2);
        choices.add(falseChoice3);
        choices.add(trueChoice);
        // add them to the question
        question.setChoices(choices);

        return question;
    }
}
