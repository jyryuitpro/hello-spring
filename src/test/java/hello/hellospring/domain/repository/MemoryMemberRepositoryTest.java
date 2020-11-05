package hello.hellospring.domain.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result =  memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}