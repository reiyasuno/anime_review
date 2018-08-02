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
import models.validators.AnimeListValidator;
import utils.DBUtil;

/**
 * Servlet implementation class AnimeListUpdateServlet
 */
@WebServlet("/animelist/update")
public class AnimeListUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimeListUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            AnimeList a= em.find(AnimeList.class, (Integer)(request.getSession().getAttribute("animelist_id")));

            int genreId = Integer.parseInt(request.getParameter("genreid"));
            Genre g = em.getReference(Genre.class, genreId);

            int categoryId = Integer.parseInt(request.getParameter("categoryid"));
            Category c = em.getReference(Category.class, categoryId);

            a.setTitle(request.getParameter("title"));
            a.setCompany(request.getParameter("company"));
            a.setStaff(request.getParameter("staff"));
            a.setSummary(request.getParameter("summary"));
            a.setGenre(g);
            a.setCategory(c);
            a.setMusic(request.getParameter("music"));
            a.setCast(request.getParameter("cast"));

            List<String> errors = AnimeListValidator.validate(a);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("animelist", a);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/animelist/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("animelist_id");

                response.sendRedirect(request.getContextPath() + "/animelist/index");
            }
        }
	}

}
