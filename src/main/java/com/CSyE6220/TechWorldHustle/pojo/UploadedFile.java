/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CSyE6220.TechWorldHustle.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jyoti
 */

 
public class UploadedFile {
    private static final long serialVersionUID = 1L;
    
    public UploadedFile(){}
    private MultipartFile multipartFile;
    public MultipartFile getMultipartFile() {
        return multipartFile;
    }
    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}

