package com.mygdx.game.Tweens;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.kotcrab.vis.runtime.component.Tint;

/**
 * Created by RobII on 10/03/2016.
 */
public class TintAccessor implements TweenAccessor<Tint> {
    public static final int OPACITY = 1;
    private Color tint;

    @Override
    public int getValues(Tint target, int tweenType, float[] returnValues) {
        switch (tweenType) {

            case OPACITY:
                returnValues[0] = target.getTint().a;
                return 1;

            default: assert false; return -1;
        }
    }

    @Override
    public void setValues(Tint target, int tweenType, float[] newValues) {
        switch (tweenType) {

            case OPACITY:
                tint = target.getTint();
                target.set(tint.r, tint.g, tint.b, newValues[0]);
                break;

            default: assert false;
        }
    }
}
