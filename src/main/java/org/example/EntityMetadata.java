/**
 * Classification: Trimble Confidential.
 *
 * @author Dinesh Kumar Sarangapani
 * @Project objectmatch
 * @since 26/08/24
 **/

package org.example;

import java.util.List;

public class EntityMetadata {

  private final String entityName;
  private final List<AttributeMetadata> allAttributes;

  public EntityMetadata(String entityName, List<AttributeMetadata> allAttributes) {
    this.entityName = entityName;
    this.allAttributes = allAttributes;
  }

  public String getEntityName() {
    return entityName;
  }

  public List<AttributeMetadata> getAllAttributes() {
    return allAttributes;
  }
}
