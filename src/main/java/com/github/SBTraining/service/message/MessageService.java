package com.github.SBTraining.service.message;

import com.github.SBTraining.dao.MessageDao;
import com.github.SBTraining.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageDao dao;

    public void add(Message message) {
        dao.save(message);
    }

    public Message findById(long id) {
        return dao.findById(id);
    }

    public void update(Message message) {
        Message dbMessage = dao.findById(message.getId());
        dbMessage.setNameUserFrom(message.getNameUserFrom());
        dbMessage.setValue(message.getValue());
        dao.save(dbMessage);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

}
