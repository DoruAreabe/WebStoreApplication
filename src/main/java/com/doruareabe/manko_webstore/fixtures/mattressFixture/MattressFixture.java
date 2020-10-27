package com.doruareabe.manko_webstore.fixtures.mattressFixture;

import com.doruareabe.manko_webstore.entity.mattressEntity.Mattress;
import com.doruareabe.manko_webstore.service.mattressServise.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MattressFixture {

    private final CoverServiceInterface coverService;
    private final DensityServiceInterface densityService;
    private final DimensionServiceInterface dimensionService;
    private final ExtraComponentServiceInterface extraComponentService;
    private final MattressServiceInterface mattressService;
    private final TypeServiceInterface typeService;
    private final Random rand;

    public MattressFixture(CoverServiceInterface coverService, DensityServiceInterface densityService, DimensionServiceInterface dimensionService, ExtraComponentServiceInterface extraComponentService, MattressServiceInterface mattressService, TypeServiceInterface typeService) {
        this.coverService = coverService;
        this.densityService = densityService;
        this.dimensionService = dimensionService;
        this.extraComponentService = extraComponentService;
        this.mattressService = mattressService;
        this.typeService = typeService;
        rand = new Random();
    }

    public void feel() {
        int coverSize = coverService.findAll().size();
        int densitySize = densityService.findAll().size();
        int dimensionSize = dimensionService.findAll().size();
        int extraComponentSize = extraComponentService.findAll().size();
        int typeSize = typeService.findAll().size();


        for (int i = 0; i < 400; i++) {
            Mattress mattress = new Mattress();
            mattress.setName("MateracManko");
            mattress.setDescription("Some description for mattress");
            mattress.setCover(coverService.findAll().get(rand.nextInt(coverSize)));
            mattress.setDensity(densityService.findAll().get(rand.nextInt(densitySize)));
            mattress.setDimensions(dimensionService.findAll().get(rand.nextInt(dimensionSize)));
            mattress.getExtraComponents().add(extraComponentService.findAll().get(rand.nextInt(extraComponentSize)));
            mattress.getExtraComponents().add(extraComponentService.findAll().get(rand.nextInt(extraComponentSize)));
            mattress.setAvailability(false);
            mattress.setPrice(String.valueOf(rand.nextInt(1000)+1));
            mattress.setType(typeService.findAll().get(rand.nextInt(typeSize)));
            mattress.setImg("someImg");
            mattressService.save(mattress);

        }
    }
}
