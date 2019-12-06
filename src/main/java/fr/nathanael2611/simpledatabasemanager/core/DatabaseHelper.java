package fr.nathanael2611.simpledatabasemanager.core;

/**
 * A simple helper to manage your databases
 *
 * @author Nathanael2611
 */
public class DatabaseHelper {

    /**
     * The database
     */
    private Database db;

    public DatabaseHelper(Database db){
        this.db = db;
    }

    /*
    public Map.Entry getNumberEntry(HashMap<String, ? extends Number> map, String getType){
        if(map.isEmpty())return SDMHelpers.createEntry("empty_map", 0);
        Map.Entry<String, Number> max = null;
        for(Map.Entry<String, ? extends Number> entry : map.entrySet()){
            if(max == null)max = (Map.Entry<String, Number>) entry;
            else {
                if(getType.equalsIgnoreCase("min")) {
                    if (max.getValue().doubleValue() < entry.getValue().doubleValue())
                        max = (Map.Entry<String, Number>) entry;
                }else if(getType.equalsIgnoreCase("max")){
                    if (max.getValue().doubleValue() > entry.getValue().doubleValue())
                        max = (Map.Entry<String, Number>) entry;
                }
            }
        }
        return max;
    }*/

    /**
     * Increment an integer in the database
     */
    public void incrementInteger(String key, int value){
        db.setInteger(
                key,
                db.getInteger(key) + value
        );
    }

    /**
     * Decrement an integer in the database
     */
    public void decrementInteger(String key, int value){
        incrementInteger(key, -value);
    }

    /**
     * Increment a double in the database
     */
    public void incrementDouble(String key, double value){
        db.setDouble(
                key,
                db.getDouble(key) + value
        );
    }

    /**
     * Decrement a double in the database
     */
    public void decrementDouble(String key, double value){
        incrementDouble(key, -value);
    }

    /**
     * Increment a float in the database
     */
    public void incrementFloat(String key, float value){
        db.setFloat(
                key,
                db.getFloat(key) + value
        );
    }

    /**
     * Decrement a float in the database
     */
    public void decrementFloat(String key, float value){
        incrementFloat(key, -value);
    }

}