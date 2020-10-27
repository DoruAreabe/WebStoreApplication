package com.doruareabe.manko_webstore.fixtures;

import com.doruareabe.manko_webstore.fixtures.mattressFixture.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixtureFasade {
    private final CoverFixture coverFixture;
    private final DensityFixture densityFixture;
    private final DimensionFixture dimensionFixture;
    private final ExtraComponentsFixture extraComponentsFixture;
    private final MattressFixture mattressFixture;
    private final TypeFixture typeFixture;
    private final ToContactFixture toContactFixture;
    private final EmailDBFixture emailDBFixture;

    @Autowired
    public FixtureFasade(EmailDBFixture emailDBFixture, CoverFixture coverFixture, DensityFixture densityFixture, DimensionFixture dimensionFixture, ExtraComponentsFixture extraComponentsFixture, MattressFixture mattressFixture, TypeFixture typeFixture, ToContactFixture toContactFixture) {
        this.coverFixture = coverFixture;
        this.densityFixture = densityFixture;
        this.dimensionFixture = dimensionFixture;
        this.extraComponentsFixture = extraComponentsFixture;
        this.mattressFixture = mattressFixture;
        this.typeFixture = typeFixture;
        this.toContactFixture=toContactFixture;
        this.emailDBFixture =emailDBFixture;
    }

    public void feel() {
        coverFixture.feel();
        densityFixture.feel();
        dimensionFixture.feel();
        extraComponentsFixture.feel();
        typeFixture.feel();
        //mattressFixture.feel();
        toContactFixture.feel();
        emailDBFixture.feel();
    }
}
