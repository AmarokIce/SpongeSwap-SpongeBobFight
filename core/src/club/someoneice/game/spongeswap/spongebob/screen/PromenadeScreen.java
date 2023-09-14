package club.someoneice.game.spongeswap.spongebob.screen;

import club.someoneice.game.spongeswap.spongebob.GameMain;
import club.someoneice.game.spongeswap.spongebob.screen.fightstart.FightStartScreen;
import club.someoneice.game.spongeswap.spongebob.util.BaseScreen;
import club.someoneice.game.spongeswap.spongebob.util.SpongeBobFace;
import club.someoneice.game.spongeswap.spongebob.util.Util;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class PromenadeScreen extends BaseScreen {

    private final Texture[] textureSpongeBobFace = new Texture[7];
    private Texture TalkBlock;

    private Texture Background;

    private Texture Plankton;
    private Texture Spongebob;


    private SpriteBatch batch;
    private final List<String> talkMessageList = Lists.newArrayList();

    @Override
    public void join() {

        batch = new SpriteBatch();

        TalkBlock = new Texture(Gdx.files.internal("img/Talk/Talk_Outside.png"));
        Background = new Texture(Gdx.files.internal("img/BG/BackGround.png"));

        Plankton = new Texture(Gdx.files.internal("img/BG/Plankton_BG.png"));
        Spongebob = new Texture(Gdx.files.internal("img/BG/Spongebob_BG.png"));

        textureSpongeBobFace[0] = SpongeBobFace.getFace(0);
        textureSpongeBobFace[1] = SpongeBobFace.getFace(1);
        textureSpongeBobFace[2] = SpongeBobFace.getFace(2);
        textureSpongeBobFace[3] = SpongeBobFace.getFace(3);
        textureSpongeBobFace[4] = SpongeBobFace.getFace(4);
        textureSpongeBobFace[5] = SpongeBobFace.getFace(5);
        textureSpongeBobFace[6] = SpongeBobFace.getFace(6);

        this.disposables.addAll(Arrays.asList(textureSpongeBobFace));

        disposables.add(TalkBlock);
        disposables.add(batch);
        disposables.add(Background);
        disposables.add(Plankton);
        disposables.add(Spongebob);

        // 1
        talkMessageList.add("你好阿, Plankton.");
        talkMessageList.add("我看你最近过的挺开心的, \n虽然绝对不是我赞同的那种.");
        talkMessageList.add("你知道吗Plankton, \n虽然你一直不是一个好家伙.");
        talkMessageList.add("但是这次你是真的过分了.");
        // step = 3

        // 2
        talkMessageList.add("哈哈哈哈哈哈! ");
        talkMessageList.add("好吧, 如果你再靠近一步. ");
        talkMessageList.add("我保证你不会喜欢接下来发生的事. ");
        // step = 6

        // 3
        talkMessageList.add("嘿! 别过来! 我在警告你! ");
        // step = 7

        // 4
        talkMessageList.add("* 叹气 *");
        talkMessageList.add("既然你执意的话...");
        talkMessageList.add("抱歉了, 秃头殿下. \n看来我不得不违约了... ");
        talkMessageList.add("因为有些事情...");
        talkMessageList.add("我早就该去做了! ");
        // step = 12

    }

    private void stepHelper(int id) {
        int face = 0;
        if (id == 1) face = 1;
        else if (id == 3) face = 2;
        else if (id == 4) face = 3;
        else if (id == 5) face = 6;
        else if (id == 6) face = 2;
        else if (id == 7) face = 4;
        else if (id == 8) face = 3;
        else if (id == 9) face = 6;
        else if (id == 10) face = 3;
        else if (id == 11) face = 6;
        else if (id == 12) face = 5;

        String str = checkMessageLength(id);
        batch.draw(TalkBlock, 50, 515);
        batch.draw(textureSpongeBobFace[face], 80, 550, 128, 128);
        font.draw(batch, str, 230, 650);
    }
    private String checkMessageLength(int id) {
        if (talkMessageStep < talkMessageList.get(id).length()) ++talkMessageStep;
        return talkMessageList.get(id).substring(0, talkMessageStep);
    }

    private int talkStep = 0;
    private float step = 0.0f;
    private int talkMessageStep = 0;
    private boolean canMove = false;

    private int TalkLevel = 0;

    private boolean started1 = false;
    private boolean ended1 = false;

    private boolean started2 = false;
    private boolean ended2 = false;

    private boolean started3 = false;
    private boolean ended3 = false;

    private boolean started4 = false;
    private boolean ended4 = false;

    private int speedX = 0;
    private int speedY = 0;
    private int X = 60;
    private int Y = 150;
    private boolean running = false;

    @Override
    public void render(float delta) {
        Util.getInstance().initScreen();

        batch.begin();
        batch.draw(Background, 0, 0);
        batch.draw(Plankton, X, Y, 32, 32);
        batch.draw(Spongebob, 450, 150, 96, 96);

        if (canMove) {
            int realSpeedX = speedX;
            int realSpeedY = speedY;
            if (running) {
                realSpeedX *= 2;
                realSpeedY *= 2;
            }

            int x = X + realSpeedX;
            x = Math.min(x, 710);
            x = Math.max(x, 11);
            X = x;

            int y = Y + realSpeedY;
            y = Math.min(y, 180);
            y = Math.max(y, 15);
            Y = y;
        }

        if (TalkLevel == 0) {
            step += delta;
            if (step > 3.0f) {
                started1 = true;
                TalkLevel ++;
            }
        }

        if (TalkLevel == 1 && started1 && !ended1) {
            stepHelper(talkStep);
        }

        if (TalkLevel == 2){
            if (X >= 100) {
                initSpeed();
                this.started2 = true;
                canMove = false;
            }

            if (started2 && !ended2) {
                stepHelper(talkStep);
            }
        }

        if (TalkLevel == 3) {
            if (X >= 110) {
                initSpeed();
                this.started3 = true;
                canMove = false;
            }

            if (started3 && !ended3) {
                stepHelper(talkStep);
            }
        }

        if (TalkLevel == 4) {
            if (X >= 115) {
                initSpeed();
                this.started4 = true;
                canMove = false;
            }

            if (started4 && !ended4) {
                stepHelper(talkStep);
            }
        }

        batch.end();

        if (ended4) {
            if (tick < 1.0F) tick += 0.4f;
            else {
                tick = 0.0f;
                Util.getInstance().initScreen();
                tickTimes++;
            }

            if (tickTimes > 3) {
                GameMain.INSTANCE.nextScreen(new FightStartScreen());
            }
        }
    }

    private float tick = 0.0f;
    private int tickTimes = 0;

    private void initSpeed() {
        this.speedX = 0;
        this.speedY = 0;
        this.running = false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if ((started1 && !ended1) || (started2 && !ended2) || (started3 && !ended3) || (started4 && !ended4)) {
            if (keycode == Input.Keys.Z || keycode == Input.Keys.ENTER) {
                if (talkStep == 3) {
                    this.ended1 = true;
                    this.TalkLevel ++;
                    this.canMove = true;
                } else if (talkStep == 6) {
                    this.ended2 = true;
                    this.TalkLevel ++;
                    this.canMove = true;
                } else if (talkStep == 7) {
                    this.ended3 = true;
                    this.TalkLevel ++;
                    this.canMove = true;
                } else if (talkStep == 12) {
                    this.ended4 = true;

                    // TODO
                }

                this.talkStep += 1;
                this.talkMessageStep = 0;
                return true;
            }
        }

        if (canMove) {
            if (keycode == Input.Keys.S) {
                this.speedY -= 2;
                return true;
            } else if (keycode == Input.Keys.W) {
                this.speedY += 2;
                return true;
            } else if (keycode == Input.Keys.A) {
                this.speedX -= 2;
                return true;
            } else if (keycode == Input.Keys.D) {
                this.speedX += 2;
                return true;
            } else if (keycode == Input.Keys.SHIFT_LEFT || keycode == Input.Keys.SHIFT_RIGHT) {
                this.running = true;
                return true;
            }
        }
        return false;
    }

    @Override public boolean keyUp(int keycode) {
        if (canMove) {
            if (keycode == Input.Keys.S) {
                this.speedY += 2;
                return true;
            } else if (keycode == Input.Keys.W) {
                this.speedY -= 2;
                return true;
            } else if (keycode == Input.Keys.A) {
                this.speedX += 2;
                return true;
            } else if (keycode == Input.Keys.D) {
                this.speedX -= 2;
                return true;
            } else if (keycode == Input.Keys.SHIFT_LEFT || keycode == Input.Keys.SHIFT_RIGHT) {
                this.running = false;
                return true;
            }
        }
        return false;
    }
}