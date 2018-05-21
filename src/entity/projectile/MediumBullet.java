package entity.projectile;

import entity.Entity;

import java.awt.Color;

public class MediumBullet extends Projectile {

    public MediumBullet(double px, double py, double vx, double vy, Entity parent) {
        super(px, py, vx, vy, parent);

        this.color = Color.white;
        this.damage = 2;
        this.speed = 20;
    }
}
