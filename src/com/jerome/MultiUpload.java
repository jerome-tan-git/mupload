package com.jerome;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MultiUpload extends ActionSupport {
	// private File Filename;
	// public File getFilename() {
	// return Filename;
	// }
	// public void setFilename(File filename) {
	// Filename = filename;
	// }
	public void myExecute() throws Exception {
		Map map = new HashMap();
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = ServletActionContext.getRequest().getRealPath("/file");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);

		List<FileItem> list = (List<FileItem>) upload
				.parseRequest(ServletActionContext.getRequest());
		System.out.println(list.size());
		// System.out.println(ServletActionContext.getRequest().getParameter("Filename"));
		// System.out.println(ServletActionContext.getRequest().getParameter("Upload"));
		// System.out.println(ServletActionContext.getRequest().getParameter("Filedata"));
		// System.out.println(Filename);
		// System.out.println(ServletActionContext.getRequest().getParameterMap());
		// System.out.println("upload");
	}
}
