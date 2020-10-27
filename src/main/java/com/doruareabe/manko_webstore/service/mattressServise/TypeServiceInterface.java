package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Type;
import com.doruareabe.manko_webstore.service.generalInterfaces.GeneralCRUDInterface;

public interface TypeServiceInterface extends GeneralCRUDInterface<Type> {
    Type findTypeByType(String type);
}
