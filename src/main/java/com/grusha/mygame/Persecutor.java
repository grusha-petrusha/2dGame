package com.grusha.mygame;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Persecutor extends GameObject {
    
    protected Persecutor() throws SlickException {
        super(700,824,null);
        this.hitbox = new Rectangle(xpos-96, ypos-96, 192,96 ); // 16- 96   before 16 - 128 pix in general
        this.temp_xpos = this.xpos;
        this.temp_ypos = this.ypos;
        this.generalspeed = 2f;
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
            this.hitbox.setY(ypos-96);
            
            if(this.ypos>=this.groundY) {
                //System.out.println("aaa");
                this.ypos = this.groundY;
                this.temp_ypos = this.groundY;
                this.hitbox.setY(ypos-96);
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

		
	}

}
