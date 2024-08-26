/**
 * Classification: Trimble Confidential.
 *
 * @author Dinesh Kumar Sarangapani
 * @Project objectmatch
 * @since 26/08/24
 **/

package org.example;

public class AttributeMetadata {

  private final String name;
  private final String type;
  private final int length;

  public AttributeMetadata(String name, String type, int length) {
        this.name = name;
        this.type = type;
        this.length = length;
  }


  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public int getLength() {
    return length;
  }
}
