package cn.com.mobilereal.common.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mobilereal.common.util.ConfigInfo;

/**
 * Servlet implementation class AssetServlet
 */
@WebServlet(name = "ShareResourceServlet", loadOnStartup = 30, urlPatterns = {"/app/*", "/excel/*", "/db/*"})
public class ShareResourceServlet extends BaseHttpServlet {

    private static final long serialVersionUID = 9161451155388096006L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareResourceServlet() {
        super();
    }

	@Override
    public void init() throws ServletException {
	    log.info("ShareResourceServlet初始化");
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String ctx = request.getContextPath();
		if (ctx!=null && ctx.length() > 2){
		   path = path.substring(ctx.length() + 1);
		}
	    File ff = new File(ConfigInfo.$.getAssetPath() + path);
        if (ff.exists()) {
            FileInputStream fins = new FileInputStream(ff);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment; filename="+new String((ff.getName()).getBytes("gbk"),"iso8859-1"));
            writeIntoOut(fins, response.getOutputStream());
        } else {
            response.sendError(404);
        }
        return;
	}
	
	private void writeIntoOut(InputStream ins, OutputStream out) {
		byte[] bb = new byte[10 * 1024];
		try {
			int cnt = ins.read(bb);
			while (cnt > 0) {
				out.write(bb, 0, cnt);
				cnt = ins.read(bb);
			}
		} catch (IOException e) {

		} finally {
			try {
				ins.close();
				out.close();
			} catch (IOException e) {

			}
		}
	}
}
