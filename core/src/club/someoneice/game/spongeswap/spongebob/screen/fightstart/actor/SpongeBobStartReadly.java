package club.someoneice.game.spongeswap.spongebob.screen.fightstart.actor;

import club.someoneice.game.spongeswap.spongebob.util.BaseActor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpongeBobStartReadly extends BaseActor {
    private float stepOfStart = 0.0f;
    private TextureRegion spongeBob0;
    private TextureRegion spongeBob1;

    public SpongeBobStartReadly(TextureRegion spongeBob0, TextureRegion spongeBob1) {
        this.spongeBob0 = spongeBob0;
        this.spongeBob1 = spongeBob1;
        this.setSize(spongeBob0.getRegionWidth(), spongeBob0.getRegionHeight());
    }

    @Override
    public void update(float delta) {
        if (stepOfStart < 3.0f) stepOfStart += delta;
    }

    @Override
    public void render(Batch batch, float delta) {
        if (stepOfStart >= 3.0f) {
            batch.draw(spongeBob1, 325, 425, spongeBob1.getRegionWidth() * 2.5f, spongeBob1.getRegionHeight() * 2.5f);
        } else {
            batch.draw(spongeBob0, 325, 425, spongeBob0.getRegionWidth() * 2.5f, spongeBob0.getRegionHeight() * 2.5f);
        }
    }
}
