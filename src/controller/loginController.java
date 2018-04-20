package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginController
 */
@WebServlet(name = "loginController", urlPatterns = { "/loginController.do" })
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");      
        response.setCharacterEncoding("utf-8");
		String accountNo = (String)request.getParameter("accountNo");
		String password = (String)request.getParameter("password");
		//System.out.println(password + " " + accountNo); 
		PrintWriter out = response.getWriter();
		if(accountNo == null || password == null || password.isEmpty() || accountNo.isEmpty()) {
			out.print("-1");
		}else if(!accountNo.equals("41512241")){
			out.println("-2");
		}else{
			String encodePass = "";
			try {
				 encodePass = utils.MD5Utils.md5Encode(password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				encodePass = "";
				e.printStackTrace();
			}
			if(encodePass.equals("9ad11ec05bf0d153e01147685dd3211e")){
				out.print("0");
				HttpSession session = request.getSession(); 
				session.setAttribute("yh", accountNo);
			}else
				out.print("-3");
			}
	}

}
