package com.company;

import Obj.Ammunition;
/**Description of the AmmunitionWeightComparator class
 * This class stores a method that defines a rule for comparing elements of the Ammunition type
 */
public class AmmunitionWeightComparator implements java.util.Comparator<Ammunition> {
    /**This method defines a rule for comparing elements of the type Ammunition*/
    public int compare(Ammunition am1, Ammunition am2) {return Double.compare(am1.getWeight(),am2.getWeight());}
}
