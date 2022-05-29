package org.itstep.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int id; //Номер вопроса
    private String question; //Вопрос
    private List<String> answers; //Ответы
    private int answer = -1; //Верный ответ
}
