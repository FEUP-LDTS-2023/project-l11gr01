package com.ldts1101.sotss.controller.game;

import com.ldts1101.sotss.controller.Controller;
import com.ldts1101.sotss.model.game.level.Level;

public abstract class GameController extends Controller<Level> {
    public GameController(Level level) {
        super(level);
    }
}
