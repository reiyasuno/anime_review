package controllers.animeList;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AnimeList;
import models.Category;
import models.Genre;
import utils.DBUtil;

/**
 * Servlet implementation class AnimeListEditServlet
 */
@WebServlet("/animelist/edit")
public class AnimeListEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimeListEditServlet() {
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

        request.setAttribute("animelist", a);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("animelist_id", a.getId());


        Genre g = em.find(Genre.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("genre", g);


        Category c = em.find(Category.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("category", c);

        em.close();

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/animelist/edit.jsp");
        rd.forward(request, response);
    }

}
