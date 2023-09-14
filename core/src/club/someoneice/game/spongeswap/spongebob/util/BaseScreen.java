package club.someoneice.game.spongeswap.spongebob.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import com.google.common.collect.Sets;

import java.util.Set;

public abstract class BaseScreen extends ScreenAdapter implements InputProcessor {
    protected BitmapFont font;

    protected final Set<Disposable> disposables = Sets.newHashSet();
    public boolean setLicense;

    public BaseScreen() {
        this.setLicense = true;
    }

    public BaseScreen(boolean shouldLicense) {
        this.setLicense = shouldLicense;
    }


    @Override
    public void show() {
        if (setLicense)
            Gdx.input.setInputProcessor(this);
        else Gdx.input.setInputProcessor(null);

        font = Util.INSTANCE.newBitmapFont();
        disposables.add(font);
        join();
    }


    abstract public void join();

    @Override
    public void dispose() {
        disposables.forEach(it -> {
            Util.getInstance().dispose(it);
        });
    }

    @Override public boolean keyTyped(char character) { return false; }
    @Override public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchCancelled(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override public boolean scrolled(float amountX, float amountY) { return false; }
}
