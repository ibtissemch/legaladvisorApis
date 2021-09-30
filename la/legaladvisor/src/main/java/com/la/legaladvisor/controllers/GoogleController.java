package com.la.legaladvisor.controllers;

import com.la.legaladvisor.services.GCalenderService;
import com.la.legaladvisor.services.GDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.drive.model.File;
import org.springframework.web.multipart.MultipartFile;

@RestController
    @RequestMapping("/api/google")
    public class GoogleController {

    @Autowired
    GDriveService gDriveService;
    @Autowired
    GCalenderService gCalenderService;

        @GetMapping("drive/")
        public List<File> getfiles(@RequestParam(value ="fileName") String fileName) throws GeneralSecurityException, IOException {
            return gDriveService.getFiles(fileName);
        }

        @GetMapping("drive/download/{fileId}")
        public void downloadFile(@PathVariable(value ="fileId") String fileId) throws GeneralSecurityException, IOException {
            gDriveService.downloadFile(fileId);
        }

       @PostMapping("drive/uploadFile")
        public File createOrUpdate(@RequestParam("file") MultipartFile multipartFile,@RequestParam("folderId")String folderId) throws IOException {
            return gDriveService.UploadFile(multipartFile,folderId);
        }

    @GetMapping("calender/")
    public void getEvents() throws GeneralSecurityException, IOException {
         gCalenderService.getEvents();
    }

    @PostMapping("calender/insert")
    public void insertCalender() throws GeneralSecurityException, IOException {
        gCalenderService.insert();
    }

    }