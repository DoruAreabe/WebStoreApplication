package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Cover;
import com.doruareabe.manko_webstore.service.generalInterfaces.GeneralCRUDInterface;

public interface CoverServiceInterface extends GeneralCRUDInterface<Cover> {
    Cover findCoverByCover(String cover);
}
