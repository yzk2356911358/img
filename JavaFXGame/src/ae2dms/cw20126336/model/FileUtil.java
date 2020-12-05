package ae2dms.cw20126336.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private static String filenameTemp;
	private static String path = "C:\\Users\\Msb\\Documents\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\JavaFXGame\\src\\level\\";

	public static void main(String[] args) throws IOException {
//		System.out.println(fieleexists("12.txt"));
		addfs("12", "311");
	}

	/**
	 * 创建文件
	 * 
	 * @throws IOException
	 */
	public static boolean creatTxtFile(String name) throws IOException {
		boolean flag = false;
		filenameTemp = path + name + ".txt";
		File filename = new File(filenameTemp);
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName 被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("删除单个文件" + fileName + "成功！");
			return true;
		} else {
			System.out.println("删除单个文件" + fileName + "失败！");
			return false;
		}
	}

	public static boolean fieleexists(String filename) {
		File file = new File(path + filename+".txt");
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	// 读取文件内容
	public static String readFile(String filename) throws IOException {// 路径
		File file = new File(path + filename+".txt");
		StringBuilder result = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));// 构造一个BufferedReader类来读取文件
			String s = br.readLine();
			result.append(System.lineSeparator() + s);
//			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
//				result.append(System.lineSeparator() + s);
//			}
			br.close();
		return s;
	}
	public static void addfs(String filename,String key)
	{
		File file = new File(path+filename+".txt");
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(key.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}