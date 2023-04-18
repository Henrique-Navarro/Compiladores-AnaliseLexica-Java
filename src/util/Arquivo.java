package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {
	private String path;

	public Arquivo(String path) {
		this.path = path;
	}

	public String ler() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine();
		String result = "";

		while (line != null) {
			result += line + "\n";
			line = buffRead.readLine();
		}
		buffRead.close();
		return result;
	}
}
