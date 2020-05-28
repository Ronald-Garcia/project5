package com.maze.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.maze.game.maze.GameMap;

public class Sword extends Entity {
    //INSTANCE VARIABLES
    public static boolean show = true;

    /*
     * This constructor inherits from Entity
     */
    public Sword(Vector2 position, Texture texture, GameMap gameMap) {
        super(position, texture, gameMap);
    }

    /*
     * This method renders the sword picture if it has not been picked up yet
     */
    @Override
    public void render(SpriteBatch batch) {
        if (show)
            batch.draw(_texture, _position.x - _texture.getWidth() / 4f, _position.y - _texture.getHeight() / 4f, _texture.getWidth(), _texture.getHeight());
    }

    /*
     * This method runs every frame and updates show depending if the player has thw sword
     */
    @Override
    public void update(float deltaTime) {
        show = !_gameMap.player.hasSword();
    }
}
