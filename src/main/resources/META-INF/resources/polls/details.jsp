<%@ page contentType ="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
    
    <%
      String questions_Uid = (String)request.getAttribute("QUESTIONS_UID");
      HashMap<String, Object> question = (HashMap<String, Object>) request.getAttribute("question");
      ArrayList<String> answers = (ArrayList<String>)request.getAttribute("answers");
    %>
    <div class="container bg-light mt-4 w-50 border border-second">
      <div class="d-flex justify-content-between mb-2 mt-2">
      <%-- 페이지 1 --%>
      <% if((int)question.get("ORDERS") == 1){ %>
        <button
          type="button"
          class="btn btn-secondary"
          onclick="alert('첫 페이지입니다.')"
        >
          prev
        </button>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q2" class="btn btn-secondary"
          >next</a
        >
      <%} %>
      <%-- 페이지 2 --%>
      <% if((int)question.get("ORDERS") == 2){ %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q1" class="btn btn-secondary"
          >prev</a
        >
        <a href="/polls/PollServlet?QUESTIONS_UID=Q3" class="btn btn-secondary"
          >next</a
        >
       
      <%} %>
            <%-- 페이지 3 --%>
      <% if((int)question.get("ORDERS") == 3){ %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q2" class="btn btn-secondary"
          >prev</a
        >
        <a href="/polls/PollServlet?QUESTIONS_UID=Q4" class="btn btn-secondary"
          >next</a
        >
       
      <%} %>
            <%-- 페이지 4 --%>
      <% if((int)question.get("ORDERS") == 4){ %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q3" class="btn btn-secondary"
          >prev</a
        >
        <a href="/polls/PollServlet?QUESTIONS_UID=Q5" class="btn btn-secondary"
          >next</a
        >
       
      <%} %>
            <%-- 페이지 5 --%>
      <% if((int)question.get("ORDERS") == 5){ %>
        <a href="/polls/PollServlet?QUESTIONS_UID=Q4" class="btn btn-secondary"
          >prev</a
        >
        <button
          type="button"
          class="btn btn-secondary"
          onclick="alert('마지막 페이지입니다.')"
        >
          next
        </button>
       
      <%} %>
      </div>
      
      <div class="border fs-6 align-items-center" style="height: 4rem">
      


      <div><%= question.get("ORDERS") %>. <%= question.get("QUESTION")%></div>
      </div>
      <div class="d-flex flex-column mt-3">
        <% for(int i=0; i<answers.size(); i++){ %>
        <div class="mb-2"><input type="radio" name="chck_info" /> <%= answers.get(i) %></div>
        <% } %>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
