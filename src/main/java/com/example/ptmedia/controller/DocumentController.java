package com.example.ptmedia.controller;

import com.example.ptmedia.model.Document;
import com.example.ptmedia.model.Post;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    private final PostRepository postRepository;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("postId") Long postId) throws IOException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("User not found"));


        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setPost(post);
        document.setContent(file.getBytes());

        // Save the file to the database
        documentService.save(document);

        return "oke bod";
    }

    @PostMapping("/get")
    public Optional<Document> handelGetFile(@RequestParam("id") Long id) {
      return   documentService.findById(id);
    }
}
