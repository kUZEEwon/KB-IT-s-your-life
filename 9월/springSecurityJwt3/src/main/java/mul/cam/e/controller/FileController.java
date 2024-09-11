package mul.cam.e.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import mul.cam.e.util.MediaTypeUtiles;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/pds")
public class FileController {

	private final ServletContext servletContext;

    public FileController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @PostMapping(value = "/fileUpload")
	public String fileUpload(	@RequestParam(value = "uploadFile", required = false)
								MultipartFile uploadFile, 
								HttpServletRequest req) {
		System.out.println("FileController fileUpload()");
		if(uploadFile.isEmpty()){
			System.out.println("uploadFile is empty ~~~~");
		}
		
		// 경로	src/main/webapp/upload 폴더를 생성할 것	
		String uploadPath = req.getServletContext().getRealPath("/upload");
		
		// String uploadPath = "d:\\tmp";
		
		String filename = uploadFile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;
		//									'/'
		System.out.println("filepath:" + filepath);
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			os.write(uploadFile.getBytes());			
			os.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "file upload fail";			
		}
		
		return "file upload success";		
	}
	
	@GetMapping(value = "/fileDownload")
	public ResponseEntity<InputStreamResource> download(String fileName, HttpServletRequest req) throws Exception{
		System.out.println("FileController download()");
		
		// 경로	
		String uploadPath = req.getServletContext().getRealPath("/upload");
		// String uploadPath = "d:\\tmp";

		MediaType mediaType = MediaTypeUtiles.getMediaTypeForFileName(this.servletContext, fileName);
		System.out.println("fileName:" + fileName);
		System.out.println("mediaType:" + mediaType);
		
		File file = new File(uploadPath + File.separator + fileName);
		InputStreamResource is = new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				.contentType(mediaType)
				.contentLength(file.length())
				.body(is);
		
	}
	
	
}








