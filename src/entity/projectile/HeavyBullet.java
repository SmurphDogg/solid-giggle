package entity.projectile;

import entity.Entity;
import engine.util.GameUtils;

import java.awt.Color;

public class HeavyBullet extends Projectile {

    public HeavyBullet(double px, double py, double vx, double vy, Entity parent) {
        super(px, py, vx, vy, parent);

        this.color = new Color(200,220,220);
        this.damage = 3;
        this.size = 1.5;
        this.speed = 0.25; // AHA! With graphics wrappers, speeds no longer must scale to the window size

        // We don't care about the magnitude of the velocity vector passed in
        // We keep its direction and scale it to speed, defined above
        double velocityMag = GameUtils.distance(vx, vy);
        this.vx = vx / velocityMag * speed;
        this.vy = vy / velocityMag * speed;
    }
}
