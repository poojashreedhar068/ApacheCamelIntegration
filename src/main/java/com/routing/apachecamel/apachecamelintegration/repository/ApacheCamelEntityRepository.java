package com.routing.apachecamel.apachecamelintegration.repository;

import com.routing.apachecamel.apachecamelintegration.entity.ApacheCamelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApacheCamelEntityRepository extends JpaRepository<ApacheCamelEntity, Long> {

}
