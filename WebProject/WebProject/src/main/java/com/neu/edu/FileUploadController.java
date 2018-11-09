package com.neu.edu;



import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.data.CandidateDAO;
import com.neu.edu.data.PersonDAO;
import com.neu.edu.pojo.candidate.UserAccount;
import com.neu.edu.resume.FileUploadForm;

@Controller
public class FileUploadController {

	@Autowired
	CandidateDAO userDao;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}
	
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String handleFileUpload(@Valid HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	      
		HttpSession session=request.getSession();
		UserAccount person = (UserAccount) session.getAttribute("userAccount");
	    if (fileUpload != null && fileUpload.length > 0) {
	        for (CommonsMultipartFile aFile : fileUpload){
	              
	            System.out.println("Saving file: " + aFile.getOriginalFilename());
	             
	            FileUploadForm uploadFile = new FileUploadForm();
	           
	            uploadFile.setFileName(aFile.getOriginalFilename());
	            uploadFile.setData(aFile.getBytes());
	            userDao.addResume(uploadFile,person);               
	        }
	    }

	    return "AddedSuccessfully";
	}
	@RequestMapping(value = "/doUpload", method = RequestMethod.GET)
	public String handleFileUpload1(@Valid HttpServletRequest request,@RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	      
		return "home";
	}
	
	@RequestMapping("/download")
    public ModelAndView download(HttpServletResponse response,HttpServletRequest request) {
         //int one=1;
         int personid=Integer.parseInt(request.getParameter("personid"));
         System.out.println("Person ID is:"+personid);
		FileUploadForm doc = userDao.getResume(personid);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFileName()+ "\"");
            OutputStream out = response.getOutputStream();
            out.write(doc.getData());
            
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } 
         System.out.println("file is"+doc.getFileName());
         ModelAndView mv= new ModelAndView("showResume","doc",doc);
        return mv;
    }
}