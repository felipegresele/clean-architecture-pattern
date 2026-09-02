package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.member;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberDaoRepository extends MongoRepository<MemberEntity, String> {
}
