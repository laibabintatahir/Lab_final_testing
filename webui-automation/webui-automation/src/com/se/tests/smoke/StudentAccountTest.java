package com.se.tests.smoke;

import com.se.rolesbase.StudentLoginBase;
import com.se.utils.UtilsSet;
import com.se.config.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentAccountTest extends StudentLoginBase {

    @Test
    public void verifyStudentIsLoggedIn(){
        System.out.println("A Student is now logged in");
    }

    @Test
    public void verifyWelcomeToTrainStudent(){
        // Add implementation for verifying welcome message if needed
    }

    @Test
    public void TC_001_VerifyExamDetailsDisplay() {
        // Preconditions: User is logged in and on the Dashboard
//        UtilsSet.goToUrl("https://demo.subexpert.com/dashboard");

        // Step 1: Navigate to the Dashboard
        UtilsSet.clickOnElement(Constants.Dashboard.BY_ThreeDots);

        // Step 2: Click on the Exams button
        UtilsSet.clickOnElement(Constants.Dashboard.BY_ExamsButton);

        // Step 3: Verify the display of exam details: title, duration, examiner, course, start time
        String actualTitle = UtilsSet.getElementText(Constants.Exams.BY_ExamTitle);
        String actualDuration = UtilsSet.getElementText(Constants.Exams.BY_ExamDuration);
        String actualExaminer = UtilsSet.getElementText(Constants.Exams.BY_Examiner);
        String actualCourse = UtilsSet.getElementText(Constants.Exams.BY_Course);
        String actualStartTime = UtilsSet.getElementText(Constants.Exams.BY_StartTime);

        // Assert the exam details
        Assert.assertEquals(actualTitle, "Quiz 1 SP24");
        Assert.assertEquals(actualDuration, "Exam Closed");
        Assert.assertEquals(actualExaminer, "Mukhtiar Zamin");
        Assert.assertEquals(actualCourse, "Software Testing");
        Assert.assertEquals(actualStartTime, "4/26/2024, 9:45:03 AM");
    }

    @Test
    public void TC_003_VerifyQuestionTypesAndMarksDistribution() {
        // Preconditions: User is logged in and on the Exam Summary page
//        UtilsSet.goToUrl("https://demo.subexpert.com/exam-summary");

        // Step 2: Click on the Exams button
        UtilsSet.clickOnElement(Constants.Dashboard.BY_Quiz1);

        // Get the number of questions for each type
        int numberOfMCQs = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MCQs));
        int numberOfTrueFalse = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_TrueFalseQuestions));
        int numberOfFillInTheBlanks = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_FillInTheBlanks));
        int numberOfShortQuestions = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_ShortQuestions));

        // Get the marks per question for each type
        int marksPerMCQ = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MarksPerMCQ));
        int marksPerTrueFalse = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MarksPerTrueFalse));
        int marksPerFillInTheBlanks = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MarksPerFillInTheBlanks));
        int marksPerShortQuestion = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MarksPerShortQuestion));

        // Calculate the total marks
        int calculatedTotalMarks = marksPerMCQ +
                marksPerTrueFalse+
                marksPerFillInTheBlanks +
                marksPerShortQuestion;

        // Get the expected total marks from the page
        int expectedTotalMarks = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_TotalMarks));

        // Assert the calculated total marks match the expected total marks
        Assert.assertEquals(calculatedTotalMarks, expectedTotalMarks, "The calculated total marks do not match the expected total marks.");

        // Additional assertions to ensure individual counts and marks are correct
        Assert.assertEquals(numberOfMCQs, 7);
        Assert.assertEquals(numberOfTrueFalse, 9);
        Assert.assertEquals(numberOfFillInTheBlanks, 0);
        Assert.assertEquals(numberOfShortQuestions, 0);
    }
}
