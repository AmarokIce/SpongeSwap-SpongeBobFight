package club.someoneice.game.spongeswap.spongebob;

import club.someoneice.game.spongeswap.spongebob.screen.StartScreen;
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

	public void nextScreen(Screen next) {
		this.holder.hide();
		this.holder.dispose();

		this.holder = next;
		setScreen(holder);
	}
	
	@Override
	public void dispose () {
		super.dispose();
		holder.dispose();
	}
}
