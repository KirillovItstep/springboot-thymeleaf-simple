package org.itstep.quiz;

import org.itstep.request_response.MyColor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //Post answer to server
    @RequestMapping(value="/answer", method = RequestMethod.POST)
    public String getAnswer (@RequestBody Answer answer, Model model,
                             RedirectAttributes redirectAttributes) { //String проходит, а объект - нет при RequestParam
        if (answer.getAnswer()==question.getAnswer()) {
            redirectAttributes.addFlashAttribute("res","1"); //Передать браузеру, верный ли ответ
            System.out.printf("The answer %d on the question %d is right%n", answer.getAnswer(), answer.getId());
        }
        else {
            redirectAttributes.addFlashAttribute("res","0");
            System.out.printf("The answer %d on the question %d is wrong%n", answer.getAnswer(), answer.getId());
        }
        //model.addAttribute("result", "1");
        return "redirect:/quiz";
    }

}
