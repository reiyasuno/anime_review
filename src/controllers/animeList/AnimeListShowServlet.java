package controllers.animeList;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AnimeList;
import models.Comment;
import utils.DBUtil;

/**
 * Servlet implementation class AnimeListShowServlet
 */
@WebServlet("/animelist/show")
public class AnimeListShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimeListShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    EntityManager em = DBUtil.createEntityManager();

        AnimeList a = em.find(AnimeList.class, Integer.parseInt(request.getParameter("id")));

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e){
            page = 1;
        }
        List<Comment> comment = em.createNamedQuery("getAnimeList",Comment.class)
                                    .setParameter("id", a)
                                    .setFirstResult(15 * (page - 1))
                                    .setMaxResults(15)
                                    .getResultList();

        Long comment_count = (long)em.createNamedQuery("getCommentCount",Long.class)
                                    .getSingleResult();
        em.close();

        request.setAttribute("animelist", a);
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("commentlist", comment);
        request.setAttribute("comment_count", comment_count);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null){
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/animelist/show.jsp");
        rd.forward(request, response);
	 }
}
