import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.util.ListIterator;

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

    private int mycoCount;
   
    private int numberEaten;
/**
     * Create a new Mycoplasma.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Phagocyte(Field field, Location location, Color col) {
        super(field, location, col);
        numberEaten = 0;
        mycoCount = 0;
    }

    /**
     * This is how the Phagocyte decides if it's alive or not
     */
     public void act() {
     
       setColor(Color.BLUE);
       eatsMyco();
       
       if (numberEaten >= 5){
           setColor(Color.RED);
        }
       setNextState(true);
      
             
        }
   
     private void eatsMyco(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        ListIterator<Location> it = adjacent.listIterator();
        while (isAlive() && it.hasNext()) {
            Location loc = it.next();
            Cell cell = field.getObjectAt(loc);
            if(cell.isAlive() && instanceOfMyco(cell)) {
                cell.setNextState(false);
                numberEaten++; 
            }
        }  
        
    }
    
}
