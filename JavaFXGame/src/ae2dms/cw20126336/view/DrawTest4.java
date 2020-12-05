package ae2dms.cw20126336.view;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class DrawTest4 extends JFrame{

	/**
	 * 读取文件
	 * 
	 * @param fileUrl
	 */
	public static StringBuffer read(String fileUrl) {
		String s = null;
		StringBuffer text = new StringBuffer();
		File f = new File(fileUrl);
		if (f.exists()) {
			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				while ((s = br.readLine()) != null) {
					text.append(s);
				}
				return text;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("文件不存在!");
		}
		return null;
	}

	/**
	 * 写文件
	 * 
	 * @param path
	 * @param content
	 */
	public static void write(String path, String content) {
		String s = new String();
		String s1 = new String();
		try {
			File f = new File(path);
			if (f.exists()) {

			} else {
				System.out.println("文件不存在，正在创建...");
				if (f.createNewFile()) {
					System.out.println("文件创建成功！");
				} else {
					System.out.println("文件创建失败！");
				}
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			while ((s = input.readLine()) != null) {
				s1 += s + "\n";
			}

			input.close();
			s1 += content;
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把图片生成Byte
	 * 
	 * @param path
	 * @return
	 */
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

	/**
	 * byte数组到图片
	 * 
	 * @param data
	 * @param path
	 */
	public static void byte2image(byte[] data, String path) {
		if (data.length < 3 || path.equals(""))
			return;
		try {
			FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in " + path);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}

	/**
	 * 读取文本的Byte转换成图片
	 * 
	 * @param path    文本路径
	 * @param fileUrl 图片保存路径
	 * @throws Exception
	 */
	public static void stringToImg(String path, String fileUrl) throws Exception {
		DrawTest4 to = new DrawTest4();
		InputStream is = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		to.saveToImgFile(sb.toString().toUpperCase(), fileUrl);
	}

	private void saveToImgFile(String src, String output) {
		if (src == null || src.length() == 0) {
			return;
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(output));
			byte[] bytes = src.getBytes();
			for (int i = 0; i < bytes.length; i += 2) {
				out.write(charToInt(bytes[i]) * 16 + charToInt(bytes[i + 1]));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int charToInt(byte ch) {
		int val = 0;
		if (ch >= 0x30 && ch <= 0x39) {
			val = ch - 0x30;
		} else if (ch >= 0x41 && ch <= 0x46) {
			val = ch - 0x41 + 10;
		}
		return val;
	}

	/**
	 * 图片转String(效率比较快)
	 * 
	 * @param contentPath
	 * @param ImgFileUrl
	 */
	public static void Img2String(String contentPath, String ImgFileUrl) {
		write(contentPath, byteTostring(image2byte(ImgFileUrl)));
	}

	/**
	 * 图片转String
	 * 
	 * @param fileUrl 文本路径
	 * @param imgPath 图片路径
	 */
	public static void ImgToString(String fileUrl, String imgPath) {

		try {
			StringBuffer sb = new StringBuffer();
			FileInputStream fis = new FileInputStream(imgPath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();

			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = fis.read(buff)) != -1) {
				bos.write(buff, 0, len);
			}
			// 得到图片的字节数组
			byte[] result = bos.toByteArray();

			// System.out.println("++++" + byte2HexStr(result));
			// 字节数组转成十六进制
			String str = byte2HexStr(result);
			/*
			 * 将十六进制串保存到txt文件中
			 */
			PrintWriter pw = new PrintWriter(new FileWriter(fileUrl));
			pw.println(str);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 实现字节数组向十六进制的转换方法一
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2HexStr(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	private static byte uniteBytes(String src0, String src1) {
		byte b0 = Byte.decode("0x" + src0).byteValue();
		b0 = (byte) (b0 << 4);
		byte b1 = Byte.decode("0x" + src1).byteValue();
		byte ret = (byte) (b0 | b1);
		return ret;
	}

	/**
	 * 实现字节数组向十六进制的转换的方法二
	 * 
	 * @param src
	 * @return
	 */
	public static String bytesToHexString(byte[] src) {

		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();

	}

	/**
	 * byte数组到16进制字符串
	 * 
	 * @param data
	 * @return
	 */
	public static String byteTostring(byte[] data) {
		if (data == null || data.length <= 1)
			return "0x";
		if (data.length > 200000)
			return "0x";
		StringBuffer sb = new StringBuffer();
		int buf[] = new int[data.length];
		// byte数组转化成十进制
		for (int k = 0; k < data.length; k++) {
			buf[k] = data[k] < 0 ? (data[k] + 256) : (data[k]);
		}
		// 十进制转化成十六进制
		for (int k = 0; k < buf.length; k++) {
			if (buf[k] < 16)
				sb.append("0" + Integer.toHexString(buf[k]));
			else
				sb.append(Integer.toHexString(buf[k]));
		}
		return sb.toString().toUpperCase();
	}
	/**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
	 * @return 
     */
	public static void ImageDemo(){
		//加载图片
		ImageIcon icon=new ImageIcon("bg.jpg");
		//Image im=new Image(icon);
		//将图片放入label中
		JLabel label=new JLabel(icon);
		
		//设置label的大小
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		JFrame frame=new JFrame();
		
		//获取窗口的第二层，将label放入
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
			
		//获取frame的顶层容器,并设置为透明
		JPanel j=(JPanel)frame.getContentPane();
		j.setOpaque(false);
 
		JPanel panel=new JPanel();
		JTextField jta=new JTextField(10);
		//JTextArea jta=new JTextArea(10,60);
		JButton jb=new JButton("确定");
		JButton jb2=new JButton("重置");
 
		panel.add(jta);
		panel.add(jb);
		panel.add(jb2);
 
		//必须设置为透明的。否则看不到图片
		panel.setOpaque(false);
 
		frame.add(panel);
		frame.add(panel);
		frame.setSize(icon.getIconWidth(),icon.getIconHeight());
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// 显示应用 GUI
		 ImageDemo();
	}
}