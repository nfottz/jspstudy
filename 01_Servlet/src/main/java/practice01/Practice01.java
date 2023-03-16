package practice01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Practice01")

public class Practice01 extends HttpServlet {
	private static final long serialVersionUIDW = 1L;

    public Practice01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month"); 
		String day = request.getParameter("day");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String tel = request.getParameter("country") + request.getParameter("tel").substring(1);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>입력정보</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>아이디 : " + id + "</li>");
		out.println("<li>비밀번호 : " + pw + "</li>");
		out.println("<li>이름 : " + name + "</li>");
		out.println("<li>생년월일 : " + year + "년 " + String.format("%02d", Integer.parseInt(month)) + "월 "
									+ String.format("%02d", Integer.parseInt(day)) + "일" + "</li>");
		out.println("<li>성별 : " + (gender.equals("male")? "남자" : gender.equals("female")? "여자" : "선택안함") + "</li>");
		out.println("<li>이메일 : " + (email.isEmpty()? "없음" : email) + "</li>");
		out.println("<li>전화번호 : " + tel + "</li>");
		out.println("</ul>");
		out.println("</body></html>");
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
