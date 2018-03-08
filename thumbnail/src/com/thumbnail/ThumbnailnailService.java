package com.thumbnail;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ThumbnailnailService {

	//定义缩略图的属性
	public static final int WIDTH =100;  
	public static final int HEIGHT = 100;
	
	public String thumbnail(CommonsMultipartFile file,String uploadPath,String realUploadPath){
		try {
			//String des = realUploadPath + "/thum_" + file.getOriginalFilename();
			String des = realUploadPath + "/t_" + file.getOriginalFilename();
			Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(des);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploadPath + "/t_" + file.getOriginalFilename();
	}
}
