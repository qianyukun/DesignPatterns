package behavior.strategy;

public class Strategy {

    public static void main(String[] args) {
        AZombie a = new AZombie();
        BZombie b = new BZombie();

        a.display();
        b.display();

        a.setAttackable(new HitAttackAble());
        a.attack();
        b.attack();

        a.move();
        b.move();
    }
}

interface Movable {

    void move();
}
interface Attackable {

    void attack();
}
abstract class Zombie {

    abstract public void display();
    protected Movable movable;

    protected Attackable attackable;
    abstract void move();

    abstract void attack();


    public Zombie(Movable movable, Attackable attackable) {
        this.movable = movable;
        this.attackable = attackable;
    }

    public Movable getMovable() {
        return movable;
    }

    public void setMovable(Movable movable) {
        this.movable = movable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }

}

class HitAttackAble implements Attackable {
    @Override
    public void attack() {
        System.out.println("HitAttackAble");
    }
}

class AZombie extends Zombie {


    public AZombie() {
        super(() -> {

        }, () -> {

        });
    }

    public AZombie(Movable movable, Attackable attackable) {
        super(movable, attackable);
    }

    @Override
    public void display() {
        System.out.println("a display");
    }

    @Override
    void move() {
        System.out.println("a move");
    }

    @Override
    void attack() {
        System.out.println("a attack");
    }
}

class StepMovable implements Movable {

    @Override
    public void move() {
        System.out.println("StepMovable");
    }
}

class ShootAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("ShootAttack");
    }
}

class BZombie extends Zombie {

    public BZombie() {
        super(new StepMovable(), new ShootAttack());
    }

    public BZombie(Movable movable, Attackable attackable) {
        super(movable, attackable);
    }

    @Override
    public void display() {
        System.out.println("b display");
    }

    @Override
    void move() {
        movable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}
