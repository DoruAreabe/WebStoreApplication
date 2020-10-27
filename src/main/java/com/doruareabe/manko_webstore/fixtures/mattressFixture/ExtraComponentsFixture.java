package com.doruareabe.manko_webstore.fixtures.mattressFixture;

import com.doruareabe.manko_webstore.entity.mattressEntity.ExtraComponent;
import com.doruareabe.manko_webstore.service.mattressServise.ExtraComponentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExtraComponentsFixture {

    private final ExtraComponentServiceInterface extraComponentService;

    @Autowired
    public ExtraComponentsFixture(ExtraComponentServiceInterface extraComponentService) {
        this.extraComponentService = extraComponentService;
    }

    public void feel(){
        ExtraComponent c1 = new ExtraComponent();
        ExtraComponent c2 = new ExtraComponent();
        ExtraComponent c3 = new ExtraComponent();

        c1.setExtraComponent("Coconut");
        c2.setExtraComponent("Ovata");
        c3.setExtraComponent("Visco");

        extraComponentService.save(c1);
        extraComponentService.save(c2);
        extraComponentService.save(c3);
    }

}
