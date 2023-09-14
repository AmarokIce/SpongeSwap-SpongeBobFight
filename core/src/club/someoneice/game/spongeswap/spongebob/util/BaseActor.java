package club.someoneice.game.spongeswap.spongebob.util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BaseActor extends Actor {
    @Override
    public void act(float delta) {
        super.act(delta);
        update(delta);
    }

    @Override
    public void draw(Batch batch, float step) {
        super.draw(batch, step);
        render(batch, step);
    }

    abstract public void update(float delta);
    abstract public void render(Batch batch, float delta);
}
