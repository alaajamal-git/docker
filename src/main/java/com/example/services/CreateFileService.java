package com.example.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;

import com.example.models.CreateFileRequest;

public interface CreateFileService {
	
	public static Path createFile(CreateFileRequest req) {
		Path temp = Path.of("temp");
		Path files = Path.of("files");

		try {
			Path des2 =Files.createDirectories(files,  new FileAttribute<?>[] {});
			temp =Files.createDirectories(temp,  new FileAttribute<?>[] {});
			System.out.println(temp.toAbsolutePath().resolve(req.getFileName()+".txt"));
			Path des1= temp.toAbsolutePath().resolve(req.getFileName()+".txt");
			des1.toAbsolutePath().toFile().createNewFile();
			Files.writeString(des1, req.getContent(), StandardOpenOption.APPEND);
			Runnable copySyn =new Runnable() {
				
				@Override
				public void run() {
					try {
						Files.copy(des1, des2.toAbsolutePath().resolve(des1.getFileName()), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			
			copySyn.run();
		} catch (IOException e) {
			e.printStackTrace();
			temp=Path.of("exception");
		}
		
		
		
		return temp;
		
	}
	
	public static List<String> getDetails(String fileName) {
		Path path = Path.of("files");
		List<String> content =null;
		System.out.println("Done1");

		try {
			content= Files.readAllLines(path.resolve(fileName+".txt"));
			System.out.println("Done2");
			System.out.println(Arrays.toString(Paths.get("").toAbsolutePath().toFile().list()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			content=null;
			e.printStackTrace();
		}
		return content;
	}

}
