package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 	Dynamic Web Project에서 외부 라이브러리(*.jar)를 사용하는 방법
 	
 	방법1. CATALINA_HOME/lib 디렉터리에 사용할 라이브러리를 추가한다.
 	방법2. 컨텍스트(프로젝트)에 사용할 라이브러리를 추가한다. (수업에서 사용할 방법!)
 		src/main/webapp/WEB-INF/lib 디렉터리에 외부 라이브러리 추가
*/

@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 요청 인코딩
			request.setCharacterEncoding("UTF-8");
			
			// 요청 파라미터
			String name = request.getParameter("name");
			if(name.length() < 2 || name.length() > 6) {
				throw new RuntimeException("601" + name + "은 잘못된 이름 입니다.");
			}
			String strAge = request.getParameter("age");
			int age = 0;
			if(strAge != null && strAge.isEmpty() == false) {
				age = Integer.parseInt(strAge);
			}
			if(age < 0 || age > 100) {
				throw new RuntimeException("600" + age + "살은 잘못된 나이입니다.");
			}
			// 응답할 JSON 데이터
			JSONObject person = new JSONObject();
			person.put("name", name);
			person.put("age", age);
			
			// 응답 데이터 타입
			response.setContentType("application/json; charset=UTF-8");
			
			// 출력 스트림 생성
			PrintWriter out = response.getWriter();
			
			// 출력
			out.println(person.toString());	// 텍스트 형식으로 된 JSON 데이터를 응답한다.
			out.flush();
			out.close();
		} catch(RuntimeException e) {
			response.setContentType("text/plain; charset=UTF-8");
			response.setStatus(Integer.parseInt(e.getMessage().substring(0,3)));
			PrintWriter out = response.getWriter();
			out.println(e.getMessage().substring(3));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
