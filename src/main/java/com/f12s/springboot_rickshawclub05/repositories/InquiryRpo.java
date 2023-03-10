package com.f12s.springboot_rickshawclub05.repositories;

import com.f12s.springboot_rickshawclub05.models.InquiryMdl;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface InquiryRpo extends CrudRepository<InquiryMdl, Long> {
    // this method retrieves all the books from the database
    List<InquiryMdl> findAll();
    // this method finds inquiry obj with email containing the search string
    List<InquiryMdl> findByEmailContaining(String search);
    // this method counts how many inquiries contain a certain string
    Long countByNameFirstContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByEmailStartingWith(String search);
}
