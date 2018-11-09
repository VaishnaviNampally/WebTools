package com.neu.edu.resume;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
 
@Entity
@Table(name = "UploadFile")
public class FileUploadForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;
    @NotEmpty(message="File could not be left blank/ Invalid Characters")
    @Lob
    private byte[] data;
 
    
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    
    public byte[] getData() {
        return data;
    }
 
    public void setData(byte[] data) {
        this.data = data;
    }
}