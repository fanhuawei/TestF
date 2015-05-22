package cn.com.mobilereal.common.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.MD5Util;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.framework.dbbean.Attachment;


/**
 * Servlet implementation class AssetServlet
 */
@WebServlet(name = "AssetServlet", loadOnStartup = 20, urlPatterns = {"/Asset/*", "/UploadFile"})
@MultipartConfig(location=".",maxFileSize=100*1024*1024)
public class AssetServlet extends BaseHttpServlet {

	private static final long serialVersionUID = 1L;
	
	final long max_img_size = 512 * 1024; //512K
	
	private Map<String,Attachment> cacheMap = new TreeMap<String,Attachment>();
	
	private transient Logger log = Logger.getLogger(getClass());
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssetServlet() {
        super();
    }    

    @SuppressWarnings("unchecked")
    @Override
    public void init() throws ServletException {
       log.info("AssetServlet初始化");
       List<Attachment> list = (List<Attachment>) Attachment.I.doPageQuery(1, 100).getList();
       for (Attachment bean : list) {
           cacheMap.put(bean.getId().toString(), bean);
       }
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		log.debug("获取资源" + path);
		int sub = path.lastIndexOf("/");
		String id = path.substring(sub+1);
		Attachment atta = null;
		if(!StringUtil.isEmpty(id))
		{
            synchronized (cacheMap) {
                atta = cacheMap.get(id);
                if (atta == null) {
                    atta = Attachment.I.findById(new Long(id));
                    cacheMap.put(id, atta);
                }
            }
            String spath = atta.getStorePath();
            File ff = null;
            if (spath.startsWith("/asset")) {
                ff = new File(request.getServletContext().getRealPath(spath));
            } else {
                ff = new File(spath);
            }
		   if (ff.exists()) {
               response.setContentType(atta.getContentType());
               response.setHeader("Cache-Control", "max-age=1800");      
               response.setHeader("Content-Disposition","attachment; filename="+new String((atta.getFileName()).getBytes("gbk"),"iso8859-1"));
               FileInputStream fins = new FileInputStream(ff);
               writeIntoOut(fins, response.getOutputStream());
           } else {
               response.sendError(404);
           }
		} else {
		    response.sendError(404);
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Part part = req.getPart("uploadFile");
		PartInfo partInfo = new PartInfo(part);
		if ("img".equalsIgnoreCase(req.getParameter("fileType"))){
		   if (partInfo.getLength()>=max_img_size){
		       resp.getWriter().print("-1");
		       return;
		   }
		}
		resp.setContentType("text/html;charset=UTF-8");
		Attachment attr = new Attachment();
		attr.setId(PKUtil.$.getPK(TableEnum.TS_ATTACHMENT));
        HttpSession sess = req.getSession(false);
        if (sess != null) {
            MenuEnum menu = (MenuEnum) sess.getAttribute(ConfigInfo.$.getMenuKey());
            if (menu != null) {
                attr.setFunctionId(menu.getId());
            }
        }
		attr.setFileSize(partInfo.getLength());
		attr.setContentType(partInfo.getContentType());
		attr.setFileName(partInfo.getFileName());
		String storePath = ConfigInfo.$.getAssetPath() + "upload/" + DateUtil.getSystemDateStr()+"/" +attr.getId() + "-" +partInfo.getFileName().replaceAll(" ", "_");
		attr.setStorePath(storePath);    
	    String realFile = storePath;
	    if (storePath.startsWith("/asset")) {
	       realFile = getServletContext().getRealPath(storePath);
	    }
	    File file = new File(realFile);
	    if (!file.getParentFile().exists()){
	    	file.getParentFile().mkdirs();
	    }
		InputStream ins = part.getInputStream();
		writeIntoOut(ins,new FileOutputStream(file));
		attr.setCode(MD5Util.md5(file));
		Attachment.I.insert(attr);
		resp.getWriter().print(attr.getId());
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
