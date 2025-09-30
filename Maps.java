// 9/30/25
// ncruz
// HashMap = key-value pairs
// Maps are used to associate a key (like a name) with a value (like an ID number)
// This program uses a HashMap to map String names to Integer employee IDs

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        // Create a HashMap that maps employee names (String) to ID numbers (Integer)
        HashMap<String, Integer> emIds = new HashMap<>();

        // Add key-value pairs to the map using put(key, value)
        emIds.put("Jerry", 11111);     // Add Jerry with ID 11111
        emIds.put("Pam", 22222);       // Add Pam with ID 22222
        emIds.put("Derek", 333333);    // Add Derek with ID 333333
        emIds.put("Angela", 44444);    // Add another employee

        // Output the entire map
        System.out.println("Full Map: " + emIds);

        // Get a value from the map using get(key)
        System.out.println("Jerry's ID: " + emIds.get("Jerry")); // Should print 11111
        System.out.println("Pam's ID: " + emIds.get("Pam"));     // Should print 22222

        // Check if certain keys exist using containsKey(key)
        System.out.println("Contains key 'Pam'? " + emIds.containsKey("Pam")); // true
        System.out.println("Contains key 'Joe'? " + emIds.containsKey("Joe")); // false

        // Check if certain values exist using containsValue(value)
        System.out.println("Contains value 22222? " + emIds.containsValue(22222)); // true
        System.out.println("Contains value 99999? " + emIds.containsValue(99999)); // false

        // Remove a key-value pair using remove(key)
        emIds.remove("Derek");  // Removes Derek from the map
        System.out.println("After removing Derek: " + emIds);

        // Show the size of the map (how many key-value pairs)
        System.out.println("Size of map: " + emIds.size()); // Should be 3 after removing Derek

        // Try to get a removed or nonexistent key
        System.out.println("Derek's ID after removal: " + emIds.get("Derek")); // Should print null
    }
}
