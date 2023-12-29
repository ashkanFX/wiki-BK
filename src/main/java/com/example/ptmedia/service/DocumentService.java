package com.example.ptmedia.service;

import com.example.ptmedia.model.Document;
import com.example.ptmedia.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public Document add(Document document) {
        return this.documentRepository.save(document);
    }
}
