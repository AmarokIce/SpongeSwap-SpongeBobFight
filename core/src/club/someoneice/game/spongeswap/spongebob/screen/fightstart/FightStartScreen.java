package club.someoneice.game.spongeswap.spongebob.screen.fightstart;

import club.someoneice.game.spongeswap.spongebob.screen.fightstart.actor.PlayBar;
import club.someoneice.game.spongeswap.spongebob.screen.fightstart.actor.SpongeBobStartReadly;
import club.someoneice.game.spongeswap.spongebob.util.BaseScreen;
import club.someoneice.game.spongeswap.spongebob.util.Util;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class FightStartScreen extends BaseScreen {
    Stage stage;

    Texture textureTalk;
    Texture textureCommon;
    private Texture hp_bg;
    private Texture hp_bar;

    SpongeBobStartReadly spongebob;
    PlayBar bar;

    @Override
    public void join() {
        this.stage = new Stage();

        this.textureTalk = new Texture(Gdx.files.internal("img/Talk/SpongeBob_Talk_0.png"));
        this.textureCommon = new Texture(Gdx.files.internal("img/SpongeBobTalk/SpongeBob_Talk_1.png"));
        hp_bg = new Texture(Gdx.files.internal("img/BG/HP_BG.png"));
        hp_bar = new Texture(Gdx.files.internal("img/BG/HP_BAR.png"));

        this.spongebob = new SpongeBobStartReadly(new TextureRegion(textureTalk), new TextureRegion(textureCommon));
        this.bar = new PlayBar(font, new TextureRegion(hp_bg), new TextureRegion(hp_bar));

        stage.addActor(spongebob);
        stage.addActor(bar);

        this.disposables.add(stage);
        this.disposables.add(textureTalk);
        this.disposables.add(textureCommon);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Util.getInstance().initScreen();

        this.stage.act(delta);
        this.stage.draw();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
}
