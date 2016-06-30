package com.theironyard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	TextureRegion stand, jump;
    Animation walk;
    float time;
    float x, y, xv, yv = 0;
    boolean canJump, faceRight = true;
    public static final float MAX_VELOCITY = 100;
    public static final float MAX_JUMP_VELOCITY = 2000;
    public static final float GRAVITY = -50;

	static final int WIDTH = 18;
	static final int HEIGHT = 26;
	static final int DRAW_WIDTH = WIDTH * 3;
    static final int DRAW_HEIGHT = HEIGHT * 3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		Texture sheet = new Texture("koalio.png");
		TextureRegion[][] tiles = TextureRegion.split(sheet, WIDTH, HEIGHT);
		stand = tiles[0][0];
		jump = tiles[0][1];
        walk = new Animation(0.2f, tiles[0][2], tiles[0][3], tiles[0][4]);
	}

	@Override
	public void render () {
        time += Gdx.graphics.getDeltaTime();
        move();

		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        TextureRegion img = stand;
        if(y > 0){
            img = jump;
        }
        else if(xv != 0){
            img = walk.getKeyFrame(time, true);
        }

		batch.begin();
        if(faceRight) {
            batch.draw(img, x, y, DRAW_WIDTH, DRAW_HEIGHT);
        }
        else{
            batch.draw(img, x + DRAW_WIDTH, y, DRAW_WIDTH * -1, DRAW_HEIGHT);
        }
		batch.end();
	}

    public float decelerate(float velocity){
        float deceleration = 0.95f;
        velocity *= deceleration;
        if(Math.abs(velocity) < 1){
            velocity = 0;
        }
        return velocity;
    }

    public void move(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && canJump) {
            yv = MAX_JUMP_VELOCITY;
            canJump = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xv = MAX_VELOCITY;
            faceRight = true;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xv = MAX_VELOCITY * -1;
            faceRight = false;
        }

        yv += GRAVITY;

        y += yv * Gdx.graphics.getDeltaTime();
        x += xv * Gdx.graphics.getDeltaTime();

        xv = decelerate(xv);
        yv = decelerate(yv);

        if(y < 0){
            y = 0;
            canJump = true;
        }


    }
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
