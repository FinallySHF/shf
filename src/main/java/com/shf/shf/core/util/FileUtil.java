package com.shf.shf.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * <p><b>文件操作工具类</b></p>
 * @author Chao.yy  #2018年08月14日 下午2:38:37
 * @version V1.0
 *
 */
public class FileUtil {
	
	/**
	 * 
	 * <p><b>文件上传操作</b></p>
	 * @author Chao.yy  # 2018年08月14日 下午2:38:54
	 * @version V1.0
	 * @param file
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 *
	 */
	  public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
	    File targetFile = new File(filePath);
	    if (!targetFile.exists()) {
	      targetFile.mkdirs();
	    }
	    FileOutputStream out =null;
	    try {
	    	out = new FileOutputStream(filePath +File.separator+ fileName);
			out.write(file);
			out.flush();
		} catch (Exception e) {
			 throw e;
		}finally {
			if(out!=null) {
				out.close();
			}
		}
	  }
	  /**
	   * 
	   * <p><b>文件删除</b></p>
	   * @author Chao.yy  # 2018年08月14日 下午2:39:34
	   * @version V1.0
	   * @param fileName
	   * @return
	   *
	   */
	  public static boolean deleteFile(String fileName) {
	    File file = new File(fileName);
	    // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	    if (file.exists() && file.isFile()) {
	      if (file.delete()) {
	        return true;
	      } else {
	        return false;
	      }
	    } else {
	      return false;
	    }
	  }
	  
	  
	  /**
	     * 输出文件 
	     * @param path
	     * @param fileName
	     * @param content
	     * @throws IOException 
	     */
	    public static void out(String path, String fileName, String content) throws IOException {
	        File file = new File(path, fileName);
	        FileWriter out = null;
	        try {
	            out = new FileWriter(file);
	            out.write(content);
	            out.flush();
	        } catch (IOException e) {
	   			 throw e;
	        } finally {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}