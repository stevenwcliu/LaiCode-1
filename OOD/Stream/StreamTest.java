import java.io.*;
public class StreamTest {

	public static void main(String[] args) {
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void test1() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("./stream/input.txt");
			out = new FileOutputStream("./stream/output.txt");
			int c; 
			while ((c= in.read()) != -1) {
				System.out.println(c);
				System.out.println((char)c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void test2() throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("./stream/input.txt");
			out = new FileOutputStream("./stream/output.txt");
			byte[] bytes = new byte[10];
			int n = in.read(bytes);
			System.out.println("n = " + n);
			for (byte b : bytes) {
				System.out.print((char)b);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static void test3() throws IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader("./stream/chineseinput.txt");
			out = new FileWriter("./stream/chineseoutput.txt");
			int c; 
			while ((c= in.read()) != -1) {
				System.out.println(c);
				System.out.println((char)c);
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}