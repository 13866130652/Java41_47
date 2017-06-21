package cn.bdqn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import org.junit.Test;

public class IODemo {

	// 通过InputStreamReader设置字符集
	public void read(String origin) {
		InputStream is = null;
		Reader isr = null;
		try {
			is = new FileInputStream(origin);
			isr = new InputStreamReader(is, "GBK");// "utf-8":origin文件的保存时使用的字符集
			char ch[] = new char[1024];
			int length = 0;
			while ((length = isr.read(ch)) != -1) {
				System.out.println(ch);
			}
		} catch (Exception e) {
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
			}
		}
	}

	// 通过标准输入流写信息到文件
	public void read() {
		Reader isr = new InputStreamReader(System.in);// System.in:标准输入流
		BufferedReader br = null;
		String s = "";
		Writer wt = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(isr);
			wt = new OutputStreamWriter(new FileOutputStream("D:/flies/file/a.txt", true));
			bw = new BufferedWriter(wt);
			System.out.println("输入：");
			while (!(s = br.readLine()).equals("exit")) {
				System.out.println(s);
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				wt.close();
				br.close();
				isr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void change() {
		byte b[] = new byte[1024];
		String st = "adavs美国";
		try {
			String s = new String(b, "utf-8");
			st = new String(st.getBytes("UTF-8"), "UTF-8");
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	// public void test() {
	// // read("D:/flies/file/a.txt");
	//
	// }

	public static void main(String[] args) {
		new IODemo().read();
	}
}
