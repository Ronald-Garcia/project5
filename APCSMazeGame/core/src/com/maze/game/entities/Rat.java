package com.maze.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.maze.game.maze.GameMap;

import static com.maze.game.entities.Minotaur.randomRange;

public class Rat extends Entity {

    //INSTANCE VARIABLES
    public static final int SPEED = 3;
    public static final int ACCEL = 25;
    protected Vector2 _startPos, _direction;
    private Vector2 dir = new Vector2(0, 0);

    /*
     * This constructor initializes instance variables and inherits from Entity
     */
    public Rat(Vector2 position, Texture texture, GameMap gameMap) {
        super(position, texture, gameMap);
        _startPos = _position;
        dir = new Vector2(0, -1);
        _velocity.x = dir.x * SPEED;
        _velocity.y = dir.y * SPEED;
    }
    //GETTER
    public Vector2 getVelocity() { return _velocity; }

    //SETTER
    public void setVelocity(Vector2 velocity) { _velocity = velocity; }
    /*
     * This method draws the Rat image
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(_texture, _position.x, _position.y, _texture.getWidth(), _texture.getHeight());
    }

    /*
     * This method moves the Rat in patrol mode every frame
     */
    @Override
    public void update(float deltaTime) {
        patrol();

        _position.x += _velocity.x;
        _position.y += _velocity.y;
    }

    /*
     * This method handles movement, if it collides, it switches to a random direction
     */
    public void patrol() {
        if(_gameMap.doesRectCollideWithMap((_position.x  + (dir.x * (_texture.getWidth() / 2))) + _velocity.x, (_position.y + (dir.y * (_texture.getHeight() / 2))) + _velocity.y, _texture.getWidth(), _texture.getHeight())) {
            int rand = randomRange(-1, 1);
            _velocity.rotate90(rand);
            dir.rotate90(rand);
        }
    }

}
