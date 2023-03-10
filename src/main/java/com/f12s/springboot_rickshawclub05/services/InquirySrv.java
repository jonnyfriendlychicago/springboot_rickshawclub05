package com.f12s.springboot_rickshawclub05.services;

import com.f12s.springboot_rickshawclub05.models.InquiryMdl;
import com.f12s.springboot_rickshawclub05.repositories.InquiryRpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquirySrv {
    // adding the book repository as a dependency
//    private final BookRepository bookRepository;
//
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @Autowired
    InquiryRpo inquiryRpo;

    // returns all the books
    public List<InquiryMdl> allInquiry() {
        return inquiryRpo.findAll();
    }

    // creates a book
    public InquiryMdl createInquiry(InquiryMdl x) {
        return inquiryRpo.save(x);
    }
    // retrieves a book

    public InquiryMdl findInquiry(Long id) {
        Optional<InquiryMdl> optionalInquiry = inquiryRpo.findById(id);
        if(optionalInquiry.isPresent()) {
            return optionalInquiry.get();
        } else {
            return null;
        }
    }

    // updateBook will take in a Book object and save it to our database
    // our repository will automatically update an existing Book object if their IDs match
    public InquiryMdl updateInquiry(InquiryMdl x) {
        return inquiryRpo.save(x);
    }

    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
    public void deleteInquiry(Long id) {
        Optional<InquiryMdl> optionalInquiry = inquiryRpo.findById(id);
        if(optionalInquiry.isPresent()) {
            inquiryRpo.deleteById(id);
        }
    }
} // end srv
