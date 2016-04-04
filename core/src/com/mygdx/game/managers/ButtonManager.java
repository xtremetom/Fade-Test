package com.mygdx.game.managers;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.runtime.component.Invisible;
import com.kotcrab.vis.runtime.component.Layer;
import com.kotcrab.vis.runtime.component.Tint;
import com.mygdx.game.Animations;
import com.mygdx.game.Main;
import com.mygdx.game.component.Bounds;

import com.artemis.Entity;

/**
 * Created by RobII on 3/30/2016.
 */
public class ButtonManager extends BaseSceneManager {

    enum State{
        layer0 (0),
        layer1 (1),
        layer2 (2);

        private int layer;

        State(int layer){
            this.layer = layer;
        }

        public int getLayer(){
            return layer;
        }
    }

    private State state = State.layer0;

    private ComponentMapper<Bounds> boundsCm;
    private ComponentMapper<Tint> tintCm;
    private ComponentMapper<Layer> layerCm;
    private ComponentMapper<Invisible> invisibleCm;

    Array<Entity> textEntities = new Array<Entity>();
    Entity buttonEntity;
    Bounds buttonBounds;
    Tint buttonTint;
    Layer layer;
    Invisible invisible;

    IntBag entities;

    public ButtonManager (Main game) {
        super(game);
    }

    @Override
    public void afterSceneInit () {
        super.afterSceneInit();
        buttonEntity = idManager.get("button");
        buttonBounds = boundsCm.get(buttonEntity);
        buttonTint = tintCm.get(buttonEntity);
        textEntities = idManager.getMultiple("text");
    }

    @Override
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        unprojectVec.set(screenX, screenY, 0);
        cameraManager.getUiCamera().unproject(unprojectVec);

        float x = unprojectVec.x;
        float y = unprojectVec.y;

        if (buttonBounds.contains(x, y)) {
            //Animations.fade_out(buttonTint);
            switch(state){
                case layer0:
                    state = State.layer1;
                    break;
                case layer1:
                    state = State.layer2;
                    break;
                case layer2:
                    state = State.layer0;
                    break;
            }

            switch(state){
                case layer0:
                    hide();
                    show();
                    break;
                case layer1:
                    hide();
                    show();
                    break;
                case layer2:
                    hide();
                    show();
                    break;
            }
        }

        return false;
    }

    private void hide(){
        for(Entity e : textEntities){
            layer = layerCm.get(e);
            invisible = invisibleCm.get(e);
            if(layer.layerId != state.getLayer()){
                e.edit().add(new Invisible());
            }
        }
    }

    private void show(){
        for(Entity e : textEntities){
            layer = layerCm.get(e);
            invisible = invisibleCm.get(e);
            if(layer.layerId == state.getLayer()){
                e.edit().remove(new Invisible());
            }
        }
    }
}
