package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;
import model.PostAction;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//ユーザーの情報を取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");

		if(user != null) {
			//予定表をセッションスコープに保存する
			List<Action> actions = new ArrayList<Action>();
			session.setAttribute("Actions", actions);

			//フォワードする
			RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispather.forward(request, response);
		}else {
			//ログイン画面にリダイレクトする
			response.sendRedirect("/TimeLine/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String when = request.getParameter("when");
		String what = request.getParameter("what");

		//行動の生成
		Action action = new Action(when, what);

		//予定表をセッションスコープから取得
		HttpSession session = request.getSession();
		List<Action> actions = (List<Action>)session.getAttribute("Actions");

		//予定表に行動を登録
		PostAction postAction = new PostAction();
		postAction.execute(actions, action);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
