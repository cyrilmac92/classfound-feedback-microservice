package com.classfound.feedback.repository;

import com.classfound.feedback.entity.ApplicationEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The CRUD repository for the application table.
 * Created by philic3 on 8/27/2016.
 */
public interface ApplicationRepository extends CrudRepository<ApplicationEntity, Long> {

    /**
     * Find an application by the application name.
     * @param appName the application name.
     * @return the corresponding application entity.
     */
    ApplicationEntity findByAppName(String appName);
}
