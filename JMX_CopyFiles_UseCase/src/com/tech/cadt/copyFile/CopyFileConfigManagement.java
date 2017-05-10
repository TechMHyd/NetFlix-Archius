package com.tech.cadt.copyFile;

import java.lang.management.ManagementFactory;
import java.util.Date;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class CopyFileConfigManagement {

	private static final int DEFAULT_NO_THREADS = 10;

	public static void main(String[] args) throws MalformedObjectNameException,
			InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException, InterruptedException {
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		// register the MBean

		String srcdir = "D:/CHAITANYA/CopiledFiles/input.txt";
		String targetdir = "D:/CHAITANYA/CopiledFiles/output";
		String fileName = "output.txt";

		CopyFileContents mBean = new CopyFileContents(srcdir, targetdir,
				fileName, DEFAULT_NO_THREADS);
		ObjectName name = new ObjectName(
				"com.techm.cadt.copyFile:type=CopyFileContents");
		mbs.registerMBean(mBean, name);
		do {
			Thread.sleep(10000);
			Date now = new Date(); // initialize date
			System.out.println("Time is :" + now); 
			mBean.CopyFileOperation();
		} while (mBean.getThreadCount() != 0);

	}

}