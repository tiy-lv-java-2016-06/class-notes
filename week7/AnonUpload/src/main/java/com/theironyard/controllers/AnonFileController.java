package com.theironyard.controllers;

import com.theironyard.entities.AnonFile;
import com.theironyard.services.AnonFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by jeff on 7/27/16.
 */
@RestController
public class AnonFileController {

    @Autowired
    AnonFileRepository repository;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public void upload(MultipartFile file, HttpServletResponse response, String description) throws IOException {
        File dir = new File("public/files");
        if(!dir.exists()) {
            dir.mkdirs();
        }

        File f = File.createTempFile("anonfile", file.getOriginalFilename(), dir);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(file.getBytes());

        AnonFile anonFile = new AnonFile(f.getName(), file.getOriginalFilename(), description);
        repository.save(anonFile);

        response.sendRedirect("/");
    }

    @RequestMapping(path = "/files", method = RequestMethod.GET)
    public List<AnonFile> getFiles(){
        return repository.findAll();
    }
}
