package entity.powerup;

import engine.util.GameUtils;
import entity.projectile.LightLaser;

import java.awt.Color;

public class RevivePowerup extends Powerup {
    private int totalHeal = 5;
    private int regenDelay = 40;

    public RevivePowerup(double px, double py, double vx, double vy) {
        super(px, py, vx, vy);

//        this.color = new Color(0, 200, 0, 140);
        this.color = Color.yellow;

        // We don't care about the magnitude of the velocity vector passed in
        // We keep its direction and scale it to speed, defined above
        double velocityMag = GameUtils.distance(vx, vy);
        this.vx = vx / velocityMag * speed;
        this.vy = vy / velocityMag * speed;

        this.timeToLive = totalHeal * regenDelay;
    }

    @Override
    public boolean isRevive() {
        return true;
    }
}
