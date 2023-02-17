import java.awt.Color;
import java.util.List;
import java.util.Random;

/**
 * Simplest form of life.
 * Fun Fact: Mycoplasma are one of the simplest forms of life.  A type of
 * bacteria, they only have 500-1000 genes! For comparison, fruit flies have
 * about 14,000 genes.
 *
 * @author David J. Barnes, Michael Kölling & Jeffery Raphael
 * @version 2022.01.06 (1)
 */

public class Mycoplasma extends Cell {

    /**
     * Create a new Mycoplasma.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Mycoplasma(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
     * This is how the Mycoplasma decides if it's alive or not
     */
     public void act() {
       List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
       setNextState(false);
       //Location loc = new Location(3,3);
       //System.out.println(getField().getLivingNeighbours(loc));
       
       if(isAlive()){
           switch(neighbours.size()){
            case 0: case 1: case 4: case 5: case 6: case 7:
            case 8: setNextState(false);
                    break;
            case 2: case 3:
                    setNextState(true);
                    break;
           }
        }
       
        if(!isAlive() && neighbours.size() == 3){
           setNextState(true);
        }

    }
}
