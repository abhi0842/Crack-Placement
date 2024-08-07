package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class InsertDeleteGetRandomDuplicatesallowed {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();
    public InsertDeleteGetRandomDuplicatesallowed () {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
    }

    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if ( ! contain ) map.put( val, new LinkedHashSet<Integer>() );
        map.get(val).add(nums.size());
        nums.add(val);
        return ! contain ;
    }

    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if ( ! contain ) return false;
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < nums.size() - 1 ) {
            int lastone = nums.get( nums.size()-1 );
            nums.set( loc , lastone );
            map.get(lastone).remove( nums.size()-1);
            map.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);

        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }

}
