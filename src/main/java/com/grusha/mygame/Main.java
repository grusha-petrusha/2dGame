package com.grusha.mygame;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args) throws SlickException {
        System.setProperty("org.lwjgl.librarypath", new File("libs/natives").getAbsolutePath());

        AppGameContainer app = new AppGameContainer(new Game("Setup Test"));

        app.setDisplayMode(1920, 1080, true); //320 180 before 240 152
        app.start();
    }
}
