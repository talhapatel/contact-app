package com.codewithtalha.contactapp.controller;

import com.codewithtalha.contactapp.constant.AppConstant;
import com.codewithtalha.contactapp.entity.Contact;
import com.codewithtalha.contactapp.props.AppProperties;
import com.codewithtalha.contactapp.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ContactRestController {
    private final ContactService contactService;
    private final AppProperties appProperties;

    @PostMapping("/contacts")
    public String saveContact(@RequestBody Contact contact){
        boolean status=contactService.saveContact(contact);

        Map<String,String> messages=appProperties.getMessages();
        if(status){
            return messages.get(AppConstant.CONTACT_SAVE_SUCC);
        }else{
            return messages.get(AppConstant.CONTACT_SAVE_FAIL);
        }
    }

    @GetMapping("contacts")
    public List<Contact> findAllContacts(){
        return contactService.getAllContact();
    }

    @GetMapping("contact/{contactId}")
    public Contact getContactById(@PathVariable("contactId") Integer contactId){
        return contactService.getContactById(contactId);
    }

    @DeleteMapping("contact/{contactId}")
    public String deleteById(@PathVariable("contactId") Integer contactId){
        Map<String,String> messages=appProperties.getMessages();
        boolean status= contactService.deleteContactById(contactId);
        if(status){
            return messages.get(AppConstant.CONTACT_DEL_SUCC);
        }else {
            return messages.get(AppConstant.CONTACT_DEL_FAIL);
        }
    }



}
