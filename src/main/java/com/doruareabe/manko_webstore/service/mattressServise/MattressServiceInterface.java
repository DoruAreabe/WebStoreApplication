package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Mattress;
import com.doruareabe.manko_webstore.service.generalInterfaces.GeneralCRUDInterface;

public interface MattressServiceInterface extends GeneralCRUDInterface<Mattress> {
    Mattress findOneByIdWithAllFields(Long id);
}
