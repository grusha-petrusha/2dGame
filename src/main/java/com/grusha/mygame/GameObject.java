package com.grusha.mygame;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Shape;


public abstract class GameObject {
    
    protected int xpos;
    protected int ypos;
    protected float xspeed;
    protected float yspeed;
    protected float generalspeed;
    protected Shape hitbox;

    protected float temp_xpos;
    protected float temp_ypos;
    protected float gravity = 0.03f;
    protected float friction = 0.9f;
    protected float jumpPower;
    protected int groundY;
    protected boolean isJumping;

    protected GameObject(int xpos, int ypos, Shape hitbox) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.hitbox = hitbox;

    }

    public void render() {
        if(this.hitbox!=null) {
            Game.gameContainer.getGraphics().setColor(Color.pink);
			Game.gameContainer.getGraphics().draw(this.hitbox);
        }
    }

    public Shape getHitbox() {
        return this.hitbox;
    }

    public float getxHitbox() {
        return this.hitbox.getX();
    }

    public float getyHitbox() {
        return this.hitbox.getY();
    }

}
