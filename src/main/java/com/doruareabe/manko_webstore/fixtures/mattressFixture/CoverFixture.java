package com.doruareabe.manko_webstore.fixtures.mattressFixture;

import com.doruareabe.manko_webstore.entity.mattressEntity.Cover;
import com.doruareabe.manko_webstore.service.mattressServise.CoverService;
import com.doruareabe.manko_webstore.service.mattressServise.CoverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoverFixture {
    private final CoverServiceInterface coverService;


    @Autowired
    public CoverFixture(CoverServiceInterface coverService) {
        this.coverService = coverService;
    }

    public void feel(){
        Cover cover1 = new Cover();
        cover1.setCovr("Mikro");
        Cover cover2 = new Cover();
        cover2.setCovr("Aloe");
        coverService.save(cover1);
        coverService.save(cover2);
    }
}
