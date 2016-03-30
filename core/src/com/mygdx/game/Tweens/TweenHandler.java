package com.mygdx.game.Tweens;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import com.kotcrab.vis.runtime.component.Tint;
import com.mygdx.game.Constants;


public class TweenHandler {

	public TweenHandler(){
		Constants.getInstance().TWEENMANAGER = new TweenManager();
		Tween.registerAccessor(Tint.class, new TintAccessor());
	}
}
