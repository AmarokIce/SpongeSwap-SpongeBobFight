package club.someoneice.game.spongeswap.spongebob.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;

public class Util {
    private Util() {}

    public static final Util INSTANCE = new Util();
    public static Util getInstance() {
        return INSTANCE;
    }

    public void initScreen() {
        ScreenUtils.clear(0, 0, 0, 1);
    }

    public void dispose(Disposable disposableObject) {
        if (disposableObject != null) {
            disposableObject.dispose();
            disposableObject = null;
        }
    }

    public BitmapFont newBitmapFont() {
        return new BitmapFont(Gdx.files.internal("font/font_vw/vonwaon.fnt"));
    }
}
