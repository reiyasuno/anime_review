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
import models.Category;
import models.Genre;
import utils.DBUtil;

/**
 * Servlet implementation class AnimeListIndexServlet
 */
@WebServlet("/animelist/index")
public class AnimeListIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimeListIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    EntityManager em = DBUtil.createEntityManager();

	    int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }

        List<AnimeList> anime = em.createNamedQuery("getAllAnimeList", AnimeList.class)
                                  .setFirstResult(15 * (page - 1))
                                  .setMaxResults(15)
                                  .getResultList();

        long anime_count = (long)em.createNamedQuery("getAnimeListCount", Long.class)
                                     .getSingleResult();


        List<Genre> genres = em.createNamedQuery("getAllGenre",Genre.class)
                               .getResultList();
        response.getWriter().append(Integer.valueOf(genres.size()).toString());


        List<Category> category = em.createNamedQuery("getAllCategory",Category.class)
                               .getResultList();
        response.getWriter().append(Integer.valueOf(category.size()).toString());

        em.close();

        request.setAttribute("animelist", anime);
        request.setAttribute("anime_count", anime_count);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/animelist/index.jsp");
        rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    EntityManager em = DBUtil.createEntityManager();

	    int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }

	    String search_key = request.getParameter("search_key");

        List<AnimeList> anime = em.createNamedQuery("findAllAnimeListWithName", AnimeList.class)
                .setParameter("animelistName","%"+search_key+"%")
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

        //request.setAttribute("animelistName", animelistName);
        //response.sendRedirect("/anime_review/animelist/index");
        request.setAttribute("animelist", anime);
        request.setAttribute("anime_count", anime.size());
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/animelist/index.jsp");
        rd.forward(request, response);
	}

}
