package club.someoneice.game.spongeswap.spongebob.util;

import java.util.List;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import com.google.common.collect.Lists;

public abstract class BaseScreen extends ScreenAdapter {
    protected BitmapFont font;

    protected List<Disposable> disposables = Lists.newArrayList();

    @Override
    public void show() {
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
}
