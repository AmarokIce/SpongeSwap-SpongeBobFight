package club.someoneice.game.spongeswap.spongebob.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum SpongeBobFace {
    SpongeBobCommon(0),
    SpongeBobMoveLooking(1),
    SpongeBobLooking(2),
    SpongeBobHelpless(3),
    SpongeBobAngry(4),
    SpongeBobAngry2(5),
    SpongeBobSilent(6);

    private final int ID;
    SpongeBobFace(int ID) {
        this.ID = ID + 1;
    }

    public Texture getFace() {
        return new Texture(Gdx.files.internal("img/SpongeBobFace/SpongeBob_Face_" + this.ID + ".png"));
    }

    public static Texture getFace(SpongeBobFace face) {
        return new Texture(Gdx.files.internal("img/SpongeBobFace/SpongeBob_Face_" + face.ID + ".png"));
    }

    public static Texture getFace(int faceId) {
        return new Texture(Gdx.files.internal("img/SpongeBobFace/SpongeBob_Face_" + (faceId + 1) + ".png"));
    }
}
