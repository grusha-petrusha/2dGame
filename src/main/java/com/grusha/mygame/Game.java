package com.grusha.mygame;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;


public class Game extends BasicGame {
    
    public static GameContainer gameContainer;
    public static Player player;


    public Game(String title) {
        super(title);
        
    }

  
    public void init(GameContainer container) throws SlickException {
        player = new Player();
        gameContainer = container;
    }

    public void update(GameContainer container, int delta) throws SlickException {
        player.update();
        //System.out.println(player.getxHitbox() + " update " + player.getyHitbox());
    }

    public void render(GameContainer container, Graphics argi) throws SlickException {
        //System.out.println(player.getxHitbox() + " " + player.getyHitbox());
        player.render();
    }

    

}
