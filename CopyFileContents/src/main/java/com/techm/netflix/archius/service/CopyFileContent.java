package com.techm.netflix.archius.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.stereotype.Component;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

@Component
public class CopyFileContent {

	public void CopyFileOperation() throws Exception {

		ConfigurationManager.loadCascadedPropertiesFromResources("config");
		DynamicStringProperty sourcedir = DynamicPropertyFactory.getInstance()
				.getStringProperty("sourcedir", "");
		DynamicStringProperty targetdir = DynamicPropertyFactory.getInstance()
				.getStringProperty("targetdir", "");
		
		DynamicStringProperty targetfileName = DynamicPropertyFactory.getInstance()
				.getStringProperty("targetFilename", "");
		
		String completepath = targetdir.get()+"/"+targetfileName.get();
		
		System.out.println("source Directory ::" + sourcedir.get());
		System.out.println("target Directory ::" + targetdir.get());
		InputStream input = null;
		OutputStream output = null;
		File sourceFile = null;
		File destFile,outputFile = null;
		try {
			/* Source file, from which content will be copied */
			sourceFile = new File(sourcedir.get());
		} catch (Exception e) {
			System.err.println("Excception occuredd in with source file :" + e);
		}

		try {
			/* destination file, where the content to be pasted */
			 destFile = new File(targetdir.get());
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