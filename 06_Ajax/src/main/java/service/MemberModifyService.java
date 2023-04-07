package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberModifyService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터를 이용해서 Member member 객체 만들기
		Member member = new Member();
		member.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAddress(request.getParameter("address"));
		
		try {

			// Member member 객체의 정보를 이용해 DB의 내용 수정
			int updateResult = MemberDAO.getInstance().updateMember(member);
			
			// 응답 데이터 형식(JSON)
			response.setContentType("application/json; charset=UTF-8");
			
			// 응답 데이터 만들기
			JSONObject obj = new JSONObject();
			obj.put("updateResult", updateResult);
			
			// 응답
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.flush();
			out.close();
			
		} catch(Exception e) {
			response.setContentType("text/plain; charset=UTF-8");
			response.setStatus(500);
			String msg = "수정에 실패했습니다.\n데이터를 입력하세요.";
			
			PrintWriter out = response.getWriter();
			out.println(msg);
			out.flush();
			out.close();
		}
	}

}
