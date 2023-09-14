package club.someoneice.game.spongeswap.spongebob.screen.fightstart.actor;

import club.someoneice.game.spongeswap.spongebob.util.BaseActor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class PlayBar extends BaseActor {
    public int playerHp = 92;
    private final BitmapFont font;
    private TextureRegion hp_bg;
    private TextureRegion hp_bar;

    public PlayBar(BitmapFont font, TextureRegion hp_bg, TextureRegion hp_bar) {
        this.font = font;
        this.hp_bg = hp_bg;
        this.hp_bar = hp_bar;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Batch batch, float delta) {
        this.font.draw(batch, "PATCHY  FN 19  HP         KR " + playerHp + " / 92", 40, 150);
        batch.draw(hp_bg, 400, 125, hp_bg.getRegionWidth() - 110, hp_bg.getRegionHeight());
        batch.draw(hp_bar, 400, 125, hp_bar.getRegionWidth() * (100.0F / playerHp) - 110, hp_bar.getRegionHeight());
    }
}
