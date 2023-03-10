package com.f12s.springboot_rickshawclub05.controllers;

import java.util.List;

import com.f12s.springboot_rickshawclub05.models.InquiryMdl;
import com.f12s.springboot_rickshawclub05.services.InquirySrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InquiryCtl {

    @Autowired
    private InquirySrv inquirySrv;

    @CrossOrigin

    @RequestMapping("/api/inquiry")
    public List<InquiryMdl> index(

    ) {
        return inquirySrv.allInquiry();
    }

    @RequestMapping(value="/api/inquiry", method=RequestMethod.POST)
    public InquiryMdl create(
            @RequestParam(value="email") String email,
            @RequestParam(value="nameFirst") String nameFirst,
            @RequestParam(value="nameLast") String nameLast,
            @RequestParam(value="ethereumWalletAddy") String ethereumWalletAddy){
        InquiryMdl inquiryObj = new InquiryMdl(email, nameFirst, nameLast, ethereumWalletAddy);
        return inquirySrv.createInquiry(inquiryObj);
    }

    @RequestMapping("/api/inquiry/{id}")
    public InquiryMdl show(
            @PathVariable("id") Long id
    ) {
        InquiryMdl inquiryObj = inquirySrv.findInquiry(id);
        return inquiryObj;
    }

    // to update a row in our database, we use the 'PUT' method
    // you will also need to change the Postman method to 'PUT' in order for this to work
    // the update process in Postman is very similar to adding rows with a 'POST' method
    @RequestMapping(value="/api/inquiry/{id}", method=RequestMethod.PUT)
    // first we get the Book ID from our path, we then get the title, description, language, and pages values
    public InquiryMdl update(
            @PathVariable("id") Long id,
            @RequestParam(value="email") String email,
            @RequestParam(value="nameFirst") String nameFirst,
            @RequestParam(value="nameLast") String nameLast,
            @RequestParam(value="ethereumWalletAddy") String ethereumWalletAddy
    ) {
        // we create a new Book object with the values we passed in
        InquiryMdl inquiryObjIncoming  = new InquiryMdl(email, nameFirst, nameLast, ethereumWalletAddy);
        // we then set the ID of the new Book object to equal the ID of the Book we are updating
        inquiryObjIncoming.setId(id);
        // now we can use our bookService to update the book
        InquiryMdl inquiryObjToBe = inquirySrv.updateInquiry(inquiryObjIncoming);
        return inquiryObjToBe;
    }

    // to delete a row, we must use the 'DELETE' method
    // in Postman, you will also have to use the 'DELETE' method
    @RequestMapping(value="/api/inquiry/{id}", method=RequestMethod.DELETE)
    // we only need the Book ID to delete the book in our bookService
    public void destroy(@PathVariable("id") Long id) {
        inquirySrv.deleteInquiry(id);
    }


} // end ctl
