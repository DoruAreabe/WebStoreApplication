package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import com.doruareabe.manko_webstore.service.generalInterfaces.GeneralCRUDInterface;

public interface ExtraComponentServiceInterface extends GeneralCRUDInterface<ExtraComponent> {
    ExtraComponent findExtraComponentByExtraComponent(String component);
}
