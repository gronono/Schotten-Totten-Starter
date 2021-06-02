package unc.gl.api.game;

import java.time.Instant;

public class GameOptions {
    private Instant created;
    private String name;

    public GameOptions(String name){
        this.created = Instant.now();
        this.name = name;
    }

    public Instant getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }
}
