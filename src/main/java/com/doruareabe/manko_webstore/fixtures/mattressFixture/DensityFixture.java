package com.doruareabe.manko_webstore.fixtures.mattressFixture;


import com.doruareabe.manko_webstore.entity.mattressEntity.Density;
import com.doruareabe.manko_webstore.service.mattressServise.DensityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DensityFixture {

    private final DensityServiceInterface densityService;

    @Autowired
    public DensityFixture(DensityServiceInterface densityService) {
        this.densityService = densityService;
    }

    public void feel(){
        Density d1 = new Density();
        Density d2 = new Density();
        Density d3 = new Density();
        Density d4 = new Density();
        d1.setDensit("H1");
        d2.setDensit("H2");
        d3.setDensit("H3");
        d4.setDensit("H4");
        densityService.save(d1);
        densityService.save(d2);
        densityService.save(d3);
        densityService.save(d4);
    }
}

