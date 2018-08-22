package controllers.comment;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AnimeList;
import models.Comment;
import utils.DBUtil;

/**
 * Servlet implementation class CommentCreateServlet
 */
@WebServlet("/comment/create")
public class CommentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String _token = (String)request.getParameter("_token");
        if(_token !=null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();
            System.out.println(request.getParameter("comment_date"));

            Comment c = new Comment();

            Date comment_date = new Date(System.currentTimeMillis());

            c.setComment_date(comment_date);

            AnimeList a = em.find(AnimeList.class, Integer.parseInt(request.getParameter("id")));

            c.setAnimelist(a);

            c.setName(request.getParameter("name"));
            c.setContent(request.getParameter("content"));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            c.setCreated_at(currentTime);
            c.setUpdated_at(currentTime);

            em.close();

            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("comment", c);

            response.sendRedirect("/anime_review/animelist/show?id=" + request.getParameter("id"));
        }
	}

	    private static void testdopost() {
	    int postID = 12;
	    String name = "namae";
	    String contents = "namae";

	    request = newRequest(postID, name, contents);
	    response = newResponse(); //←ここはよくわからん doPost(request, response) }

	}

}

