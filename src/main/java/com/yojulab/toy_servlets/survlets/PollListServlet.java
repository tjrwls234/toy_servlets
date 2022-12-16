package com.yojulab.toy_servlets.survlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.yojulab.toy_servlets.DataInfor;
import com.yojulab.toy_servlets.beans.QuestionBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pollListServlet")
public class PollListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requerst, HttpServletResponse response)
            throws ServletException, IOException {
        // 정상적인 한글 작동을 위한 UTF-8 설정
        response.setContentType("text/html;charset=UTF-8");

        // DataInfor 객체 생성
        DataInfor dataInfor = new DataInfor();

        // UserPollBundle 가져오기
        HashMap<String, Object> userPollBundle = dataInfor.getUserPollBundle();
        // 유저 데이터 담기
        HashMap<String, String> userInfor = (HashMap<String, String>) userPollBundle.get("UserInfor");
        // 설문조사 데이터 담기
        ArrayList<QuestionBean> pollData = (ArrayList<QuestionBean>) userPollBundle.get("PollData");

        // 추출
        // 유저 name, team 추출
        String name = userInfor.get("name");
        String team = userInfor.get("team");

        // 추출
        // 설문조사 질문, 답항 추출
        String question01 = pollData.get(0).getQuestion();
        String answer_list = "1." + pollData.get(0).getAnswer().get("1") + " 2." + pollData.get(0).getAnswer().get("2");

        PrintWriter printWriter = response.getWriter();

        // HTML
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8' />");
        printWriter.println("<title>Document</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("/>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='container text-bg-light border border-dark'>");
        printWriter.println("<div class='fs-3'>설문조사</div>");
        printWriter.println("<div>");
        printWriter.println("<table class='table w-25 border border-secondary'>");
        printWriter.println("<tr>");
        printWriter.println("<td>이름 :</td>");
        printWriter.println("<td>" + name + "</td>");
        printWriter.println("</tr>");
        printWriter.println("<tr>");
        printWriter.println("<td>소속 :</td>");
        printWriter.println("<td>" + team + "</td>");
        printWriter.println("</tr>");
        printWriter.println("</table>");
        printWriter.println("</div>");

        printWriter.println("<form action='' class='form'>");
        printWriter.println("<div");
        printWriter.println("id='carouselControl'");
        printWriter.println("class='carousel slide text-bg-secondary text-center w-75 mb-4 d-flex align-items-center'");
        printWriter.println("data-bs-rid='carousel'");
        printWriter.println("style='height: 10rem'>");
        printWriter.println("<div class='carousel-inner'>");
        // active로 인한 1번 항목
        printWriter.println("<div class='carousel-item active' w-100>");
        printWriter.println("<div class='mb-2'> 1. " + question01 + "</div>");
        printWriter.println("<div>" + answer_list + "</div>");
        printWriter.println("</div>");
        // for문으로 만들 목록
        // printWriter.println("<div class='carousel-item' w-100>");
        // printWriter.println("<div class='mb-2'>질문2</div>");
        // printWriter.println("<div>답항2</div>");
        // printWriter.println("</div>");
        // printWriter.println("<div class='carousel-item' w-100>");
        // printWriter.println("<div class='mb-2'>질문3</div>");
        // printWriter.println("<div>답항3</div>");
        // printWriter.println("</div>");
        // printWriter.println("<div class='carousel-item' w-100>");
        // printWriter.println("<div class='mb-2'>질문4</div>");
        // printWriter.println("<div>답항4</div>");
        // printWriter.println("</div>");
        // printWriter.println("<div class='carousel-item' w-100>");
        // printWriter.println("<div class='mb-2'>질문5</div>");
        // printWriter.println("<div>답항5</div>");
        // printWriter.println("</div>");
        String question;
        HashMap<String, String> answersMap;
        for (int i = 1; i < pollData.size(); i++) {
            // question 뽑기
            question = pollData.get(i).getQuestion();
            printWriter.println("<div class='carousel-item' w-100>");
            printWriter.println("<div class='mb-2'>" + (i + 1) + ". " + question + "</div>");
            answer_list = "";
            answersMap = pollData.get(i).getAnswer();
            for (Entry<String, String> answerMap : answersMap.entrySet()) {
                answer_list += answerMap.getKey() + "." + answerMap.getValue() + " ";
            }
            printWriter.println("<div>" + answer_list + "</div>");
            printWriter.println("</div>");
        }

        printWriter.println("</div>");
        printWriter.println("<button");
        printWriter.println("class='carousel-control-prev'");
        printWriter.println("type='button'");
        printWriter.println("data-bs-target='#carouselControl'");
        printWriter.println("data-bs-slide='prev'>");
        printWriter.println("<span class='carousel-control-prev-icon' aria-hidden='true'></span>");
        printWriter.println("</button>");
        printWriter.println("<button");
        printWriter.println("class='carousel-control-next'");
        printWriter.println("type='button'");
        printWriter.println("data-bs-target='#carouselControl'");
        printWriter.println("data-bs-slide='next'>");
        printWriter.println("<span class='carousel-control-next-icon' aria-hidden='true'></span>");
        printWriter.println("</button>");
        printWriter.println("</div>");
        printWriter.println("</form>");
        printWriter.println("</div>");
        printWriter.println("<script");
        printWriter.println("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("crossorigin='anonymous'>");
        printWriter.println("</script>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();

    }
}
