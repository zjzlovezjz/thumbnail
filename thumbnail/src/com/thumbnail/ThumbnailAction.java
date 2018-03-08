package com.thumbnail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ThumbnailAction {
	private UploadService uploadService;
	private ThumbnailnailService thumbnailnailService;

	@RequestMapping(value="/thumbnail",method=RequestMethod.POST) //Ϊ���file������ӳ�����ñ���nameΪ"iamge"���ļ�
	public ModelAndView thumbnail(@RequestParam("image")CommonsMultipartFile file,HttpSession session) throws Exception{
		String uploadPath = "/images";  //ͼƬ����λ��
		String realUploadPath = session.getServletContext().getRealPath(uploadPath);
		
		//���������ڷ������ϵ�ͼƬ������ͼ��URL���ع�ǰ��ʹ����ʾͼƬ
		String imageUrl = uploadService.uploadImage(file, uploadPath, realUploadPath);
		String thumImageUrl = thumbnailnailService.thumbnail(file, uploadPath, realUploadPath);
		
		ModelAndView ret = new ModelAndView();

		ret.addObject("imageURL", imageUrl);
		ret.addObject("thumbImageURL", thumImageUrl);
		ret.setViewName("thumbnail"); 
		return ret;
	}

	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@Autowired
	public void setThumbnailnailService(ThumbnailnailService thumbnailnailService) {
		this.thumbnailnailService = thumbnailnailService;
	}
	
	
	
	
	
	
	
	
}
