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

public class Phagocyte extends Cell {

    /**
     * Create a new Mycoplasma.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Phagocyte(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
     * This is how the Phagocyte decides if it's alive or not
     */
     public void act() {
       List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
       setNextState(true);
       
       
       if(isAlive()){
           switch(neighbours.size()){
            case 1:
                setColor(Color.GREEN);
                break;
            case 2: case 3: 
                setColor(Color.RED);
                break;
           }
        }
      

    }
}
