package com.xiaoyi.spring.dao;

import com.xiaoyi.spring.model.Contact;

import java.util.List;

/**
 * Created by xiapen on 2017-03-27.
 */
public interface ContactDAO {
    public void saveOrUpdate(Contact contact);

    public void delete(int contactId);

    public Contact get(int contactId);

    public List<Contact> list();
}