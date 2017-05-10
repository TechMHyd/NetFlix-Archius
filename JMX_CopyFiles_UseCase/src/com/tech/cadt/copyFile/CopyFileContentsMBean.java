package com.tech.cadt.copyFile;

public interface CopyFileContentsMBean {

	public void CopyFileOperation();

	public int getThreadCount();

	public void setThreadCount(int threadCount);

	public String getSrcdir();

	public void setSrcdir(String srcdir);

	public String getTargetdir();

	public void setTargetdir(String targetdir);

	public String getFileName();

	public void setFileName(String fileName);

	public String doConfig();
	
}
