package org.itstep.quiz;

import org.itstep.request_response.MyColor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@Controller
public class QuizController {

    private Question question; //Текущий вопрос

    @RequestMapping("/quiz")
    public String getQuiz(Model model) {
        question = new Question(1,"Question:", Arrays.asList("Wrong answer", "Right answer","Wrong answer"), 1);
        model.addAttribute("quiz", question);
        return "quiz";
    }

    //Get answer from browser
    @RequestMapping(value="/sendanswer", method = RequestMethod.POST)
    public String getAnswer (@RequestBody Answer answer) { //String проходит, а объект - нет
        if (answer.getAnswer()==question.getAnswer())
            System.out.printf("The answer %d on the question %d is right%n", answer.getAnswer(), answer.getId());
        else
            System.out.printf("The answer %d on the question %d is wrong%n", answer.getAnswer(), answer.getId());
        return "redirect:/quiz";
    }

}
