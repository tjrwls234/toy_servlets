package com.yojulab.toy_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.toy_servlets.beans.QuestionBean;
import com.yojulab.toy_servlets.beans.UserBean;

public class DataInfor {

    // 유저 정보
    public HashMap<String, String> getUserInfor() {
        UserBean userBean = new UserBean();
        userBean.setName("김석진");
        userBean.setTeam("KH정보교육원");

        HashMap<String, String> userInfor = new HashMap<>();
        userInfor.put("name", userBean.getName());
        userInfor.put("team", userBean.getTeam());

        return userInfor;
    }

    // 질문 및 답항
    public ArrayList<QuestionBean> getPollData() {
        ArrayList<QuestionBean> pollList = new ArrayList<>();

        QuestionBean questionBean01 = new QuestionBean();
        questionBean01.setQuestion("해당 매장을 방문시 매장은 청결 하였습니까?");
        questionBean01.setAnswer("1", "전혀아니다.");
        questionBean01.setAnswer("2", "아니다.");
        pollList.add(questionBean01);

        QuestionBean questionBean02 = new QuestionBean();
        questionBean02.setQuestion("주문시 직원은 고객님께 친절 하였습니까?");
        questionBean02.setAnswer("1", "전혀아니다.");
        questionBean02.setAnswer("2", "아니다.");
        questionBean02.setAnswer("3", "보통이다.");
        pollList.add(questionBean02);

        QuestionBean questionBean03 = new QuestionBean();
        questionBean03.setQuestion("주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        questionBean03.setAnswer("1", "전혀아니다.");
        questionBean03.setAnswer("2", "아니다.");
        pollList.add(questionBean03);

        QuestionBean questionBean04 = new QuestionBean();
        questionBean04.setQuestion("해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
        questionBean04.setAnswer("1", "전혀아니다.");
        questionBean04.setAnswer("2", "아니다.");
        questionBean04.setAnswer("3", "보통이다.");
        questionBean04.setAnswer("4", "그렇다.");
        questionBean04.setAnswer("5", "매우 그렇다.");
        pollList.add(questionBean04);

        QuestionBean questionBean05 = new QuestionBean();
        questionBean05.setQuestion("직원이 제조한 음료에 대해 맛은 좋았습니까?");
        questionBean05.setAnswer("1", "전혀아니다.");
        questionBean05.setAnswer("2", "아니다.");
        questionBean05.setAnswer("3", "보통이다.");
        pollList.add(questionBean05);

        return pollList;
    }

    // 두개의 메소드 합치기
    public HashMap<String, Object> getUserPollBundle() {
        HashMap<String, Object> userPollBundle = new HashMap<>();
        DataInfor dataInfor = new DataInfor();

        // user 정보 넣기
        userPollBundle.put("UserInfor", dataInfor.getUserInfor());
        // 설문 내용 넣기
        userPollBundle.put("PollData", dataInfor.getPollData());

        return userPollBundle;
    }
}
