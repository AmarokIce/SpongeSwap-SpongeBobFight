package club.someoneice.game.spongeswap.spongebob;

import club.someoneice.game.spongeswap.spongebob.screen.StartScreen;
import club.someoneice.game.spongeswap.spongebob.util.BaseScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameMain extends Game {
	public static GameMain INSTANCE;
	public Screen holder;

	@Override
	public void create () {
		INSTANCE = this;

		Gdx.app.log("SpongeSwap", "Game is start success!");

		holder = new StartScreen();
		setScreen(holder);
	}

	public void nextScreen(BaseScreen next) {
		Screen sc = holder;
		this.holder = next;
		setScreen(holder);

		sc.hide();
		sc.dispose();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		holder.dispose();
	}
}
