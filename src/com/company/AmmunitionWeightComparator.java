package com.company;

import Obj.Ammunition;

public class AmmunitionWeightComparator implements java.util.Comparator<Ammunition> {
    public int compare(Ammunition am1, Ammunition am2) {return Double.compare(am1.getWeight(),am2.getWeight());}
}
