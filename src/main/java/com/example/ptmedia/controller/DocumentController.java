package com.example.ptmedia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {
//    private final DocumentService documentService;
//    private final PostRepository postRepository;
//
//    @PostMapping("/upload")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   @RequestParam("postId") Long postId) throws IOException {
//        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("User not found"));
//
//
//        Document document = new Document();
//        document.setFileName(file.getOriginalFilename());
//        document.setPost(post);
//        document.setContent(file.getBytes());
//
//        // Save the file to the database
//        documentService.save(document);
//
//        return "oke bod";
//    }
//
//    @PostMapping("/get")
//    public Optional<Document> handelGetFile(@RequestParam("id") Long id) {
//      return   documentService.findById(id);
//    }
}
