package com.doruareabe.manko_webstore.service.mattressServise;

import com.doruareabe.manko_webstore.entity.mattressEntity.Density;
import com.doruareabe.manko_webstore.service.generalInterfaces.GeneralCRUDInterface;

public interface DensityServiceInterface extends GeneralCRUDInterface<Density> {
    Density findDensityByDensity(String density);
}
