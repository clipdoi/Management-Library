package helpers;

import java.io.File;
import java.io.FileInputStream;

public class FileHelper {

	public static byte[] convertFileToBytes(File file) {
		try {
			byte[] bytes = new byte[(int)file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytes);
			fileInputStream.close();
			return bytes;
		} catch (Exception e) {
			return null;
		}
	}

}
