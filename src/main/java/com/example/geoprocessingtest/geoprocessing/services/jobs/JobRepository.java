package com.example.geoprocessingtest.geoprocessing.services.jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobRepository extends JpaRepository<JobEntity, Long>, JpaSpecificationExecutor<JobEntity> {
   JobEntity findJobEntityByJobID(String jobID);
}
