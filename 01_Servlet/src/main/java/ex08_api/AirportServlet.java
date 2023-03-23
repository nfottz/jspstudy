package ex08_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AirportServlet")
public class AirportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String schDate = request.getParameter("schDate");
		String schDeptCityCode = request.getParameter("schDeptCityCode");
		String schArrvCityCode = request.getParameter("schArrvCityCode");
		
		String serviceKey = "GxglCuHtwp4CJcuT52KlHO7b6Wbrih22bXKzL4adhI7UbMQt9zCNMnoyqziFiAmTxpxMcsGIbqnduYKgPQdtYg==";
		
//		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
//		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
//		apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");
//		apiURL += "&schDate=" + URLEncoder.encode(schDate, "UTF-8");
//		apiURL += "&schDeptCityCode=" + URLEncoder.encode(schDeptCityCode, "UTF-8");
//		apiURL += "&schArrvCityCode=" + URLEncoder.encode(schArrvCityCode, "UTF-8");
		
		StringBuilder sbURL = new StringBuilder();
		sbURL.append("http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList");
		sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
		sbURL.append("&pageNo=" + URLEncoder.encode("1", "UTF-8"));
		sbURL.append("&schDate=" + URLEncoder.encode(schDate, "UTF-8"));
		sbURL.append("&schDeptCityCode=" + URLEncoder.encode(schDeptCityCode, "UTF-8"));
		sbURL.append("&schArrvCityCode=" + URLEncoder.encode(schArrvCityCode, "UTF-8"));
		String apiURL = sbURL.toString();
		
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		
		BufferedReader reader = null;
		if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		con.disconnect();

		response.setContentType("application/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
