package com.mygdx.game;

import aurelienribon.tweenengine.TweenManager;

/**
 * Created by RobII on 3/30/2016.
 */
public class Constants {

    public TweenManager TWEENMANAGER;

    public static Constants instance;

    public Constants(){ this.instance = this; }

    public static Constants getInstance(){
        return instance;
    }
}
