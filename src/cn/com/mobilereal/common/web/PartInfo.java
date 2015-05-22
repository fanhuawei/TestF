package cn.com.mobilereal.common.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

public class PartInfo {
	private String fileName;
	private Part part;

	public PartInfo(Part part) {
		super();
		String name = part.getHeader("content-disposition");
		String fileNameTmp = name.substring(name.indexOf("filename=") + 10);
		fileName = fileNameTmp.substring(0, fileNameTmp.indexOf("\""));
		fileName = fileName.replaceAll(" ", "_");
		this.part = part;
	}

	public String getFileName() {
		return fileName;
	}

	public String getContentType() {
		return part.getContentType();
	}

	public Long getLength() {
		return part.getSize();
	}
    public void writeInto(File newFile) {
        try {
            if (!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            part.write(newFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	public void writeInto(String newFile) {
		try {
			File newfile = new File(newFile);
			if (!newfile.getParentFile().exists()){
				newfile.getParentFile().mkdirs();
			}
			part.write(newFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
