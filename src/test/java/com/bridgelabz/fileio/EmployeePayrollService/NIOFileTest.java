package com.bridgelabz.fileio.EmployeePayrollService;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.*;
import org.junit.*;

public class NIOFileTest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException
	{
		//Check File exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		//Delete File and check file not exists
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		//Create Directory
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		//Create File
		IntStream.range(1,10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.notExists(playPath));
			try{
				Files.createFiles(tempFile);
			}
			catch(IOException E)
			{}
			Assert.assertTrue(Files.exists(tempFile));
		});

		//List files, directories as well as files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
		path.toString().startsWith("temp")).forEach(System.out::println);
	}
}

