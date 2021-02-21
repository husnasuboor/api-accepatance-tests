package uk.kainos.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PayloadReaderUtil {

	public static String readPayload(String file) throws URISyntaxException, IOException {
		Path path = Paths.get(PayloadReaderUtil.class.getClassLoader().getResource(file).toURI());
		byte[] fileBytes = Files.readAllBytes(path);
		return new String(fileBytes);
	}

}
