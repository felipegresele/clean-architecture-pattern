package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.member;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.contracts.MemberRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.MemberEntityMapper;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.MemberEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    public static final String MEMBER_COLLECTION_NAME = "Member";

    private final MemberDaoRepository dao;
    private final MongoTemplate mongoTemplate;

    public MemberRepositoryImpl(MemberDaoRepository dao, MongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Member save(Member member) {
        MemberEntity memberEntity = MemberEntityMapper.domainToEntity(member);
        this.dao.save(memberEntity);
        return MemberEntityMapper.entityToDomain(memberEntity);
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return this.dao.findById(id).map(MemberEntityMapper::entityToDomain);
    }

    @Override
    public List<Member> getAllMembers() {
        List<MemberEntity> memberEntityList = this.dao.findAll();
        return MemberEntityMapper.listMemberDomain(memberEntityList);
    }

    @Override
    public void delete(String id) {
        MemberEntity memberEntity = this.dao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found member with Id: " + id));
        this.dao.delete(memberEntity);
    }
}
