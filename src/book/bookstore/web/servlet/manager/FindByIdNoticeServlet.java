package book.bookstore.web.servlet.manager;
import book.bookstore.domain.Notice;
import book.bookstore.service.NoticeService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindByIdNoticeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        NoticeService nService = new NoticeService();
        //获取公告id
        String n_id = req.getParameter("id");
        Notice notice = nService.findNoticeById(n_id);

        req.setAttribute("n", notice);

        req.getRequestDispatcher("/admin/notices/edit.jsp").forward(req, resp);
    }
}
