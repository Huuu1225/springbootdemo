package com.cqdx.springbootdemo2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileUploadController {

    // 获取当前项目的运行路径并拼接上传文件夹路径
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/upload")
    public String upload(@RequestParam("nickname") String nickname, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        System.out.println("UPLOAD_DIR: " + UPLOAD_DIR);
        System.out.println("Received file: " + (file != null ? file.getOriginalFilename() : "null"));
        System.out.println("Received nickname: " + nickname);

        // 检查文件是否为空
        assert file != null;
        if (file.isEmpty()) {
            return "文件为空，请重新上传";
        }

        try {
            // 获取文件名
            String originalFileName = file.getOriginalFilename();
            String fileExtension = "";
            if (originalFileName != null && originalFileName.contains(".")) {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                originalFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
            }

            // 生成唯一文件名
            String newFileName = originalFileName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileExtension;

            // 确保上传目录存在
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            // 保存文件到上传目录
            Path filePath = uploadPath.resolve(newFileName);
            file.transferTo(filePath.toFile());
            System.out.println("Stored Filename: " + newFileName);
            return "上传成功，昵称：" + nickname + "，文件名：" + newFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败： " + e.getMessage();
        }
    }
}


