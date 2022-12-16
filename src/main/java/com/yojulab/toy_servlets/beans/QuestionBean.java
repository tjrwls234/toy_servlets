package com.yojulab.toy_servlets.beans;

import java.util.HashMap;

public class QuestionBean {
    String question;
    HashMap<String, String> answer = new HashMap<>();

    public HashMap<String, String> getAnswer() {
        return answer;
    }

    public void setAnswer(String id, String answer) {
        this.answer.put(id, answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
