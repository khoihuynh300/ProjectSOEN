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
import com.sunny.dao.IImageDao;
import com.sunny.model.Image;

@Repository
public class ImageDaoImpl implements IImageDao {
//	@Override
//	public Image createImage(Image image) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Transaction t = session.beginTransaction();
//			session.save(image);
//			t.commit();
//			session.close();
//			return image;
//		}
//	}
//
//	@Override
//	public Image getImageById(int id) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Image result = session.get(Image.class, id);
//			session.close();
//			return result;
//		}
//	}
//
//	@Override
//	public void updateImage(Image image) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Transaction t = session.beginTransaction();
//			session.update(image);
//			t.commit();
//			session.close();
//		}
//	}
	public String storeFile(MultipartFile file, String filename) throws Exception {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            String uploadDir = "D:\\sunny\\ProductImage";
            //System.err.println(file.getName());
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			InputStream inputStream = file.getInputStream();
			Path filePath = uploadPath.resolve(filename);
			System.err.println(filePath);
			
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
	
	public Image createImage(MultipartFile[] multipartFiles, String[] filename) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction t = session.beginTransaction();
			List<String> fileName = new ArrayList<>(); 
			for (MultipartFile multipartFile : multipartFiles) {
				fileName.add(StringUtils.cleanPath(multipartFile.getOriginalFilename()));
			}
			Image img = new Image(filename[0],filename[1],filename[2],filename[3]);
			
			session.save(img);
			
			t.commit();
			return img;
		}
	}
}
