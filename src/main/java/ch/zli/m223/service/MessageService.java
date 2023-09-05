package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Message;

@ApplicationScoped
public class MessageService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Message createMessage(Message message) {
        return entityManager.merge(message);
    }

    @Transactional
    public void deleteMessage(Long id) {
        var entity = entityManager.find(Message.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Message updateMessage(Long id, Message message) {
        message.setId(id);
        return entityManager.merge(message);
    }

    public List<Message> findAll() {
        var query = entityManager.createQuery("FROM Message", Message.class);
        return query.getResultList();
    }

    public Optional<Message> findByEmail(String email) {
        return entityManager
                .createNamedQuery("Message.findByEmail", Message.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
