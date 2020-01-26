package com.colin.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class FileHelper {
	
	/**
	 * �����ļ�
	 * @param fileName
	 * @param content
	 * @return
	 */
	public static File createFile(String fileName, String content) {
		File file = null;
		// д�ļ���
		try {
			file = new File(fileName);
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(fileName);
			PrintWriter pw = new PrintWriter(fos);
			pw.write(content);
			pw.flush();
			pw.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * �ļ�����
	 * @param srcFile Դ�ļ�
	 * @param destFile Ŀ���ļ�
	 * @throws Exception
	 */
	public static void copy(File srcFile, File destFile) throws Exception {
		// ���ļ���
		FileInputStream fis = new FileInputStream(srcFile);
		// д�ļ���
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] b = new byte[1024];
		int len = -1;
		// ѭ����д�ļ�
		while (-1 != (len = fis.read(b))) {
			fos.write(b, 0, len);
		}
		fos.flush();
		fos.close();
		fis.close();
	}
	
	/**
	 * ��Ŀ¼��ȡ��ָ����׺�����ļ�
	 * @param file  �ļ�Ŀ¼
	 * @param fileName  ��׺��
	 * @return �����������ļ�����
	 */
	public static File[] getFilesByFileNameFromDir(File file,final String fileName){
		if(file!=null&&fileName!=null&&fileName.length()>0){
			File[] files = file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.getName().endsWith(fileName);
				}
			});
			return files;
		}
		return new File[0];
	}
	/**
	 * ���������ļ�������ļ������
	 * @param file �������ļ���
	 * @return true:��ȡ�����ļ�    false:û�ж�ȡ���ļ�
	 */
	public static boolean showFileNameFromDir(File file) {
		// �ڷ����в�����ȫ���������Ĳ���
		// һ��Ҫ�Բ������н�Ϊ�������߼��жϺ��ټ�������
		if (file == null) {
			System.out.println("�ļ�Ϊ�գ�");
		} else {
			// �жϵ�ǰfile�Ƿ�Ϊһ���ļ�
			if (file.isFile()) {
				System.out.println(file.getName());
				// �����һ��Ŀ¼
			} else if (file.isDirectory()) {
				// �˷�������һ��File���飬�����ÿ��Ԫ�ض��ǵ�ǰfileĿ¼�����ļ�����
				File[] subFiles = file.listFiles();
				System.out.println();
				System.out.println(file.getName() + "�ļ��а���" + subFiles.length + "���ļ�");
				// ѭ�����ļ����飬��ÿ���ļ����ļ�����ӡ
				for (File subFile : subFiles) {
					System.out.println(subFile.getName());
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * ���ݸ�����·��,��ȡ��Ӧ���ļ��������ֽ����鷵��
	 * 1:��·����װΪһ��File����
	 * 2:������Ҫ���ص��ֽ�����,������file��Ӧ���ļ���Сһ��
	 * 3:����FileInputStream
	 * 4:����FileInputStream��ȡ�ļ�,�����ݴ�ŵ��ֽ�������
	 */
	public static byte[] read(String fileName) throws Exception {
		File file = new File(fileName);
		if (file.exists()) {
			FileInputStream input = new FileInputStream(file);
			byte[] buff = new byte[(int) file.length()];
			input.read(buff);
			input.close();// �ͷŵ�������(�ͷ���Դ)
			return buff;
		}
		return new byte[0];
	}
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("." + File.separator + "img.jpg");
		FileOutputStream fos = new FileOutputStream("." + File.separator + "copy.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int i = 0;
		long start = System.currentTimeMillis();
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("�ܹ���ʱ:" + (end - start));
		bos.flush();// ���ڻ����������˵����������Ǳ�Ҫ��
		bos.close();
		bis.close();
		fos.close();
		fis.close();
	}
	
	/**
	 * ʵ���ļ��Ŀ���
	 * 1:��λ׼���������ļ�
	 * 2:����FileInputStream��Դ�ļ��ж�ȡ����
	 * 3:ѭ����ȡ�ֽ�
	 * 4:����FileOutputStream����λĿ���ļ�(�������ļ�)
	 * 5:����ȡ��ÿ���ֽ�ͨ��FileOutputStreamд�뵽�����ļ���
	 */
	public static void copyFile() throws Exception{
		FileInputStream fis = new FileInputStream("."+File.separator+"img.jpg");
		FileOutputStream fos = new FileOutputStream("."+File.separator+"copy.jpg");
		int b=0;
		long start = System.currentTimeMillis();
		while((b=fis.read())!=-1){
			fos.write(b);
		}
		long end = System.currentTimeMillis();
		System.out.println("�ܹ���ʱ:"+(end-start));
		fis.close();
		fos.close();
	}
	
	/**
	 * ʵ����ȸ���
	 * 1.����ByteArrayOutputStream
	 *   �����������ǽ������������磬���������װ��һ��byte[]����ͨ��ByteArrayOutputStreamд�����ֽڱ��浽��������
	 *   byte[]�У����鳤�Ȳ������Զ�����
	 * 2.����ObjectOutputStream,������װByteArrayOutputStream
	 * 3.ͨ��ObjectOutputStream������д������ʵ���Ͼ���д�뵽��ByteArrayOutputStream[]����
	 * 4.ͨ��ByteArrayOutputStream��toByteArray()�������ڲ���byte[]���أ��������Ǿ��õ��˶������л�����Ǹ��ֽ�������
	 * 5.����ByteArrayInputStream
	 * 6.��byte[]����ByteArrayInputStream,����ByteArrayInputStream�ʹ������������л���Ķ���byte[]��
	 * 7.����ObjectInputStream��ByteArrayInputStream�л�ȡ����
	 * 8.�����л����󣬴Ӷ��õ��˿�����Ķ���
	 */
	public static Object copyObject(Object obj) throws Exception {
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buff);
		oos.writeObject(obj);
		byte[] objbuff = buff.toByteArray();// ��ByteArrayOutputStream�л�ȡ���л���Ķ�����ֽ�����
		//�ٽ��������л�����ֽ������װΪһ��ByteArrayInputStream
		ByteArrayInputStream input = new ByteArrayInputStream(objbuff);
		ObjectInputStream objInput = new ObjectInputStream(input);
		return objInput.readObject();
	}

}
