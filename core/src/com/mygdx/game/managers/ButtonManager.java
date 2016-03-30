package com.mygdx.game.managers;

import com.artemis.ComponentMapper;
import com.badlogic.gdx.Gdx;
import com.kotcrab.vis.runtime.component.Tint;
import com.mygdx.game.Animations;
import com.mygdx.game.Main;
import com.mygdx.game.component.Bounds;

import com.artemis.Entity;

/**
 * Created by RobII on 3/30/2016.
 */
public class ButtonManager extends BaseSceneManager {
    private ComponentMapper<Bounds> boundsCm;
    private ComponentMapper<Tint> tintCm;

    Entity buttonEntity;
    Bounds buttonBounds;
    Tint buttonTint;

    public ButtonManager (Main game) {
        super(game);
    }

    @Override
    public void afterSceneInit () {
        super.afterSceneInit();
        buttonEntity = idManager.get("button");
        buttonBounds = boundsCm.get(buttonEntity);
        buttonTint = tintCm.get(buttonEntity);
    }

    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        unprojectVec.set(screenX, screenY, 0);
        cameraManager.getUiCamera().unproject(unprojectVec);

        float x = unprojectVec.x;
        float y = unprojectVec.y;

        if (buttonBounds.contains(x, y)) {
            Animations.fade_out(buttonTint);
        }

        return false;
    }
}
