package com.mygdx.game;

import aurelienribon.tweenengine.Tween;
import com.kotcrab.vis.runtime.component.Tint;
import com.mygdx.game.Tweens.TintAccessor;


/**
 * Created by RobII on 3/30/2016.
 */
public class Animations {

    private static Constants CONSTANTS = Constants.getInstance();

    public static void fade_out(Tint tint){
        Tween.to(tint, TintAccessor.OPACITY, 3f)
                .target(0f)
                .start(CONSTANTS.TWEENMANAGER);
    }
}
