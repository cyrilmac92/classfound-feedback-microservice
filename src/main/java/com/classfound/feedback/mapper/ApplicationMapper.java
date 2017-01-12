package com.classfound.feedback.mapper;

import com.classfound.feedback.entity.ApplicationEntity;
import com.classfound.feedback.model.ApplicationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The map struct mapper class for application details.
 * Created by philic3 on 8/27/2016.
 */
@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper( ApplicationMapper.class );
    @Mapping(source = "applicationName", target = "appName")
    /*@Mapping(source = "applicationKey", target = "appKey")*/
    /*@Mapping(source = "applicationOwner", target = "appOwner")*/
    ApplicationEntity applicationModelToApplicationEntity(ApplicationModel applicationModel);
}
