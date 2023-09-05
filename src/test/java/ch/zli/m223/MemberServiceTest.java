package ch.zli.m223;

import ch.zli.m223.service.MemberService;

import ch.zli.m223.model.Member;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class MemberServiceTest {

    @Inject
    MemberService memberService;

    @Test
    @Transactional
    public void testCreateMember() {
        // Erstellen eines Test-Mitglieds
        Member member = new Member();
        member.setName("John");
        member.setEmail("john.doe@example.com");


        Member createdMember = memberService.createMember(member);

        assertNotNull(createdMember.getId());
        assertEquals("John", createdMember.getName());
        assertEquals("john.doe@example.com", createdMember.getEmail());
    }

    @Test
    @Transactional
    public void testUpdateMember() {
     
        Member member = new Member();
        member.setName("John");
        member.setEmail("john.doe@example.com");

  
        Member createdMember = memberService.createMember(member);

        createdMember.setName("Updated John");
        createdMember.setEmail("updated.john.doe@example.com");

     
        Member updatedMember = memberService.updateMember(createdMember.getId(), createdMember);

        assertEquals(createdMember.getId(), updatedMember.getId());
        assertEquals("Updated John", updatedMember.getName());
        assertEquals("updated.john.doe@example.com", updatedMember.getEmail());
    }

    @Test
    @Transactional
    public void testDeleteMember() {
  
        Member member = new Member();
        member.setName("John");
        member.setEmail("john.doe@example.com");

        Member createdMember = memberService.createMember(member);

        memberService.deleteMember(createdMember.getId());

        Optional<Member> deletedMember = memberService.findByEmail("john.doe@example.com");

      
        assertTrue(deletedMember.isEmpty());
    }

    @Test
    public void testFindAllMembers() {
       
        List<Member> members = memberService.findAll();

        assertNotNull(members);
    }
}
