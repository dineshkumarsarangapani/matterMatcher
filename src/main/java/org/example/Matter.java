/**
 * Classification: Trimble Confidential.
 *
 * @author Dinesh Kumar Sarangapani
 * @Project objectmatch
 * @since 26/08/24
 **/

package org.example;

import java.util.HashMap;
import java.util.Map;

public class Matter {
  private Map<String, Object> attributes = new HashMap<>();

  // Method to set an attribute
  public void setAttribute(String attributeName, Object value) {
    attributes.put(attributeName, value);
  }

  // Method to get an attribute
  public Object getAttribute(String attributeName) {
    return attributes.get(attributeName);
  }

  // Method to get all attributes
  public Map<String, Object> getAllAttributes() {
    return attributes;
  }

  // Override toString for easy debugging
  @Override
  public String toString() {
    return "Entity{" +
        "attributes=" + attributes +
        '}';
  }
}

