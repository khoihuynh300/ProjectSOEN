package com.sunny.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sunny.connections.HibernateUtil;
import com.sunny.model.Image;

@Repository
public class ImageDaoImpl {
	public String storeFile(MultipartFile file) throws Exception {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            String uploadDir = "D:\\HK5\\CNPM\\ProjectSOEN\\ProjectSOEN\\ProjectSOEN\\workspace\\sunny\\src\\main\\resources\\static\\img\\product_image\\" + file.getName();
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			InputStream inputStream = file.getInputStream();
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
	
	public Image createImage(MultipartFile[] multipartFiles) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction t = session.beginTransaction();
			List<String> fileName = new ArrayList<>(); 
			for (MultipartFile multipartFile : multipartFiles) {
				fileName.add(StringUtils.cleanPath(multipartFile.getOriginalFilename()));
			}
			Image img = new Image(fileName.get(0),fileName.get(1),fileName.get(2),fileName.get(3));
			
			session.save(img);
			
			t.commit();
			return img;
		}
	}
}
