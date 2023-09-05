package ch.zli.m223.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Member;

@ApplicationScoped
public class MemberService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Member createMember(Member member) {
        return entityManager.merge(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        var entity = entityManager.find(Member.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Member updateMember(Long id, Member member) {
        member.setId(id);
        return entityManager.merge(member);
    }

    public List<Member> findAll() {
        var query = entityManager.createQuery("FROM Member", Member.class);
        return query.getResultList();
    }

    public Optional<Member> findByEmail(String email) {
        return entityManager
                .createNamedQuery("Member.findByEmail", Member.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
