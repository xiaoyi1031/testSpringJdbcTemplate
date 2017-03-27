package com.xiaoyi.spring.controller;

import com.xiaoyi.spring.dao.ContactDAO;
import com.xiaoyi.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiapen on 2017-03-27.
 */
public class HomeComtroller {

    // @Autowired annotation to let Spring inject an instance of the ContactDAOimplementation into this controller automatically.
    @Autowired
    private ContactDAO contactDAO;

    // method for listing all contacts
    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Contact> listContact = contactDAO.list();
        model.addObject("listContact", listContact);
        model.setViewName("home");
        return model;
    }

    // method for showing new contact
    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("ContactForm");
        return model;
    }

    // method for updating and inserting a contact
    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

    // method for deleting a contact
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }

    // method for retrieving details of a particular contact for editing
    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contact", contact);

        return model;
    }
}
