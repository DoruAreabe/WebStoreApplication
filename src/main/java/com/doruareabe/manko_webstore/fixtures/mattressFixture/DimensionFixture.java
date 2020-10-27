package com.doruareabe.manko_webstore.fixtures.mattressFixture;

import com.doruareabe.manko_webstore.entity.mattressEntity.Dimension;
import com.doruareabe.manko_webstore.service.mattressServise.DimensionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DimensionFixture {

    private final DimensionServiceInterface dimensionService;

    @Autowired
    public DimensionFixture(DimensionServiceInterface dimensionService) {
        this.dimensionService = dimensionService;
    }

    public void feel(){
        Dimension dim1 = new Dimension();
        Dimension dim2 = new Dimension();
        Dimension dim3 = new Dimension();
        Dimension dim4 = new Dimension();
        Dimension dim5 = new Dimension();
        Dimension dim6 = new Dimension();
        Dimension dim7 = new Dimension();
        Dimension dim8 = new Dimension();
        Dimension dim9 = new Dimension();
        Dimension dim10 = new Dimension();

        dim1.setDimension("100x190x20");
        dim2.setDimension("100x190x16");
        dim3.setDimension("100x190x24");
        dim4.setDimension("100x200x16");
        dim5.setDimension("100x200x20");
        dim6.setDimension("100x200x24");
        dim7.setDimension("120x190x16");
        dim8.setDimension("120x190x20");
        dim9.setDimension("120x190x24");
        dim10.setDimension("120x200x16");

        dimensionService.save(dim1);
        dimensionService.save(dim2);
        dimensionService.save(dim3);
        dimensionService.save(dim4);
        dimensionService.save(dim5);
        dimensionService.save(dim6);
        dimensionService.save(dim7);
        dimensionService.save(dim8);
        dimensionService.save(dim9);
        dimensionService.save(dim10);
    }
}
