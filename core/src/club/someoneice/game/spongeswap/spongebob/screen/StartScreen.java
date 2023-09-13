package club.someoneice.game.spongeswap.spongebob.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.common.collect.Lists;

import club.someoneice.game.spongeswap.spongebob.GameMain;
import club.someoneice.game.spongeswap.spongebob.util.BaseScreen;
import club.someoneice.game.spongeswap.spongebob.util.Util;

import java.util.List;

public class StartScreen extends BaseScreen implements InputProcessor {
    private SpriteBatch batch;

    private int choose = 0;
    private List<String> textList = Lists.newArrayList();

    @Override
    public void join() {
        Gdx.input.setInputProcessor(this);

        batch = new SpriteBatch();

        textList.add("开始");
        textList.add("退出");

        disposables.add(font);
        disposables.add(batch);
    }

    @Override
    public void render(float delta) {
        Util.getInstance().initScreen();
        batch.begin();
        renderTextOnScreen();
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.S) {
            this.choose = Math.min(this.choose + 1, 1);
        } else if (keycode == Input.Keys.W) {
            this.choose = Math.max(this.choose - 1, 0);
        } else if (keycode == Input.Keys.Z || keycode == Input.Keys.ENTER) {
            if (this.choose == 0) {
                GameMain.INSTANCE.nextScreen(new PromenadeScreen());
            } else if (this.choose == 1) {
                Gdx.app.exit();
            }
        }
        return false;
    }

    @Override public boolean keyUp(int keycode) { return false; }
    @Override public boolean keyTyped(char character) { return false; }
    @Override public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchCancelled(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override public boolean scrolled(float amountX, float amountY) { return false; }

    private void renderTextOnScreen() {
        for (int i = 0; i < textList.size(); i ++) {
            if (i == this.choose) {
                font.setColor(1.0f, 0.79f, 0.0f, 1.0f);
            } else {
                font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            }

            font.draw(this.batch, textList.get(i), 80, 250 - i * 50);

        }
    }
}
