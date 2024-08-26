/**
 * Classification: Trimble Confidential.
 *
 * @author Dinesh Kumar Sarangapani
 * @Project objectmatch
 * @since 26/08/24
 **/

package org.example;

import java.util.*;

public class MatterMatcher {

  // Method to compare a Matter object with a list of Matter objects
  public static Map<String, Object> matchMatters(Matter matter1, List<BaseFolder> mattersToCompare, List<String> matchingFields) {
    BaseFolder bestMatch = null;
    int maxMatches = 0;
    List<String> bestMatchingFields = new ArrayList<>();

    // Iterate through each Matter in the list
    for (BaseFolder baseFolder : mattersToCompare) {
      List<String> matchedFields = new ArrayList<>();
      int matchedCount = 0;

      // Compare fields for each Matter
      for (String field : matchingFields) {
        Object value1 = matter1.getAttribute(field);
        Object value2 = baseFolder.getAttribute(field);

        if (value1 != null && value1.equals(value2)) {
          matchedFields.add(field);
          matchedCount++;
        }
      }

      // Keep track of the Matter with the most matches
      if (matchedCount > maxMatches) {
        maxMatches = matchedCount;
        bestMatch = baseFolder;
        bestMatchingFields = matchedFields;
      }
    }

    // Create a result map to return the best match and the matching fields
    Map<String, Object> result = new HashMap<>();
    result.put("bestMatch", bestMatch);
    result.put("matchedFields", bestMatchingFields);
    result.put("matchedCount", maxMatches);

    return result;
  }

  public static void main(String[] args) {
    // Generate a sample Matter object (matter1)
    Matter matter1 = new Matter();
    matter1.setAttribute("id", 1);
    matter1.setAttribute("matterType", "Legal Case");
    matter1.setAttribute("matterSubtype", "Litigation");
    matter1.setAttribute("jurisdiction", "US");
    matter1.setAttribute("matterOwner", "John Doe");
    matter1.setAttribute("matterClient", "Client A");
    matter1.setAttribute("XXXX", "XXXX");

    // Generate a list of Matters to compare with matter1
    List<BaseFolder> mattersToCompare = new ArrayList<>();

    BaseFolder baseFolder = new BaseFolder();
    baseFolder.setAttribute("id", 2);
    baseFolder.setAttribute("matterType", "Legal Case");
    baseFolder.setAttribute("matterSubtype", "Advisory");
    baseFolder.setAttribute("jurisdiction", "US");
    baseFolder.setAttribute("matterOwner", "Jane Smith");
    baseFolder.setAttribute("matterClient", "Client A");

    BaseFolder baseFolder1 = new BaseFolder();
    baseFolder1.setAttribute("id", 3);
    baseFolder1.setAttribute("matterType", "Corporate Matter");
    baseFolder1.setAttribute("matterSubtype", "Litigation");
    baseFolder1.setAttribute("jurisdiction", "UK");
    baseFolder1.setAttribute("matterOwner", "John Doe");
    baseFolder1.setAttribute("matterClient", "Client B");

    BaseFolder baseFolder2 = new BaseFolder();
    baseFolder2.setAttribute("id", 4);
    baseFolder2.setAttribute("matterType", "Legal Case");
    baseFolder2.setAttribute("matterSubtype", "Litigation");
    baseFolder2.setAttribute("jurisdiction", "US");
    baseFolder2.setAttribute("matterOwner", "John Doe");
    baseFolder2.setAttribute("matterClient", "Client A");
    baseFolder2.setAttribute("matterClient1", "Client A");

    // Add matters to the list
    mattersToCompare.add(baseFolder);
    mattersToCompare.add(baseFolder1);
    mattersToCompare.add(baseFolder2);

    // Define the matching fields
    List<String> matchingFields = Arrays.asList("matterType", "matterSubtype", "jurisdiction", "matterOwner", "matterClient");

    // Call the matching method
    Map<String, Object> result = matchMatters(matter1, mattersToCompare, matchingFields);

    // Output the result
    System.out.println("Best Matching Matter: " + result.get("bestMatch"));
    System.out.println("Number of matching fields: " + result.get("matchedCount"));
    System.out.println("Matching fields: " + result.get("matchedFields"));
  }
}
