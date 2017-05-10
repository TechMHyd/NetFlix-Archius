package com.tech.cadt.copyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileContents implements CopyFileContentsMBean {
	
	private String srcdir;
	private String targetdir;
	private String fileName;
	private int threadCount;
	
	@Override
	public int getThreadCount() {
		return threadCount;
	}

    @Override
	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

    @Override
	public String getSrcdir() {
		return srcdir;
	}

    @Override
	public void setSrcdir(String srcdir) {
		this.srcdir = srcdir;
	}

    @Override
	public String getTargetdir() {
		return targetdir;
	}

    @Override
	public void setTargetdir(String targetdir) {
		this.targetdir = targetdir;
	}

    @Override
	public String getFileName() {
		return fileName;
	}

    @Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public CopyFileContents(String srcdir, String targetdir, String fileName,
			int threadCount) {
		super();
		this.srcdir = srcdir;
		this.targetdir = targetdir;
		this.fileName = fileName;
		this.threadCount = threadCount;
	}
	

	@Override
	public String doConfig() {
		return "CopyFileContents [srcdir=" + srcdir + ", targetdir="
				+ targetdir + ", fileName=" + fileName + ", threadCount="
				+ threadCount + "]";
	}

	public void CopyFileOperation(){
		
		System.out.println(doConfig());
		String completepath = targetdir+"/"+fileName;
		InputStream input = null;
		OutputStream output = null;
		File sourceFile = null;
		File destFile,outputFile = null;
		try {
			/* Source file, from which content will be copied */
			sourceFile = new File(srcdir);
		} catch (Exception e) {
			System.err.println("Excception occuredd in with source file :" + e);
		}

		try {
			/* destination file, where the content to be pasted */
			 destFile = new File(targetdir);
				if (!destFile.exists()) {
					destFile.mkdirs();
					outputFile = new File(completepath);
					System.out.println("DIR created");
				}

		} catch (Exception e) {
			System.out.println("Exception occured with target file::" + e);
		}

		try {
			/* FileInputStream to read streams */
			input = new FileInputStream(sourceFile);

			/* FileOutputStream to write streams */
			output = new FileOutputStream(completepath);

			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

			System.out.println("File Copied Sucessfully...");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}

				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}
