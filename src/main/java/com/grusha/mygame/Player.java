package com.grusha.mygame;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player extends GameObject {
    //private float gravity = 0.2f;
    //private float jumpPower = -5f;
    //private int groundY = 100;
    //private boolean isJumping;

    protected Player() throws SlickException {
        super(540,824,null);
        this.hitbox = new Rectangle(xpos-48, ypos-192, 96,192 ); // 16- 96   before 16 - 128 pix in general
        this.temp_xpos = this.xpos;
        this.temp_ypos = this.ypos;
        this.generalspeed = 1f;
        this.yspeed = 0;
        this.xspeed = 0;
        this.jumpPower = -5f;
        this.groundY = 824;

        this.isJumping = false;
    }

    public void update() throws SlickException{
		move(); //5pix - 1 time
        falling_after_jump();
        
    }

    private void falling_after_jump() {
            this.yspeed += this.gravity;
            this.temp_ypos += yspeed;
            this.ypos = (int) this.temp_ypos;
            this.hitbox.setY(ypos-192);
            
            if(this.ypos>=this.groundY) {
                //System.out.println("aaa");
                this.ypos = this.groundY;
                this.temp_ypos = this.groundY;
                this.hitbox.setY(ypos-192);
                isJumping = false;
                this.yspeed = 0;
            }
            //System.out.println(this.temp_ypos + "   " + this.ypos);
    }

    private void jump() {
        if(!isJumping) {
            this.yspeed = this.jumpPower;
            isJumping = true;
        }
    }

    private void move() throws SlickException {

		if(Game.gameContainer.getInput().isKeyPressed(Input.KEY_W)) {
            jump();
		}
		/*if(Game.gameContainer.getInput().isKeyDown(Input.KEY_S)){
			this.temp_ypos+=speed;
            this.ypos = (int) temp_ypos;
            System.out.println(this.temp_ypos + "   " + this.ypos);
            this.hitbox.setY(ypos-16);
			//this.hitbox.setY(this.hitbox.getY()+speed);
		}*/
		if(Game.gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            this.xspeed = -this.generalspeed;
            if(isJumping) {
                this.xspeed *= this.friction;
            }
			this.temp_xpos+=xspeed;
            this.xpos = (int) temp_xpos;
            //System.out.println(this.temp_xpos + "   " + this.xpos);
            this.hitbox.setX(xpos-48);
			//this.hitbox.setX(this.hitbox.getX()-speed);
		}
		if(Game.gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            this.xspeed = this.generalspeed;
            if(isJumping) {
                xspeed *= this.friction;
            }
			this.temp_xpos+=xspeed;
            this.xpos = (int) temp_xpos;
            //System.out.println(this.temp_xpos + "  " + this.temp_xpos);
            this.hitbox.setX(xpos-48);
			//this.hitbox.setX(this.hitbox.getX()+speed);
            //System.out.println(this.xpos + "lol" + this.hitbox.getX());
		}
		
	}
}
