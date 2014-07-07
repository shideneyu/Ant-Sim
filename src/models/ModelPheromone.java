package models;

public class ModelPheromone {
    
    private int x ;
    private int y ;
    private final int defaultCountdown = 10000 ;
    private int countdown = defaultCountdown; //A pheromone must disapeare if countdown = 0

    public ModelPheromone(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }
    
    public void decreaseCountdown(int decrease) {
        if( (this.countdown - decrease) < 0 ){
            this.countdown = 0;
        } else {
            this.countdown -= decrease ;
        }
    }
    
    public void increaseCountdown() {
        this.countdown += defaultCountdown ;
    }

    @Override
    //Equals only with x and y
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelPheromone other = (ModelPheromone) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelPheromone{" + "x=" + x + ", y=" + y + ", countdown=" + countdown + '}';
    }

}

