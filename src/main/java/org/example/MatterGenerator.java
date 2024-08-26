/**
 * Classification: Trimble Confidential.
 *
 * @author Dinesh Kumar Sarangapani
 * @Project objectmatch
 * @since 26/08/24
 **/

package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MatterGenerator {

  // This is a simple method that generates a entity called Matter which has the following fields,
  // matterType, matterName, matterDescription, matterId, matterStatus, matterStartDate, matterEndDate
  // matterSubtype, jurstriction, matterOwner, matterClient, matterClientContact, matterClientContactEmail
  // create a attributeMetadata object for each field and add it to the list of attributes.
  // create EntityMetadata

    public EntityMetadata generateMatterEntity() {
        List<AttributeMetadata> attributes = new ArrayList<>();
        attributes.add(new AttributeMetadata("matterType", "String", 255));
        attributes.add(new AttributeMetadata("matterName", "String", 255));
        attributes.add(new AttributeMetadata("matterDescription", "String", 255));
        attributes.add(new AttributeMetadata("matterId", "Integer", 255));
        attributes.add(new AttributeMetadata("matterStatus", "String", 255));
        attributes.add(new AttributeMetadata("matterStartDate", "Date", 255));
        attributes.add(new AttributeMetadata("matterEndDate", "Date", 255));
        attributes.add(new AttributeMetadata("matterSubtype", "String", 255));
        attributes.add(new AttributeMetadata("jurisdiction", "String", 255));
        attributes.add(new AttributeMetadata("matterOwner", "String", 255));
        attributes.add(new AttributeMetadata("matterClient", "String", 255));
        attributes.add(new AttributeMetadata("matterClientContact", "String", 255));
        attributes.add(new AttributeMetadata("matterClientContactEmail", "String", 255));
        return new EntityMetadata("Matter", attributes);
    }

    // given EntityMetadata, generate a list of entities dynamic java object during runtime.
    public List<Matter> generateEntities(EntityMetadata entityMetadata, int count) {
        List<Matter> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Matter matter = new Matter();
            for (AttributeMetadata attributeMetadata : entityMetadata.getAllAttributes()) {
                String attributeName = attributeMetadata.getName();
                String attributeType = attributeMetadata.getType();
                switch (attributeType) {
                    case "String":
                        matter.setAttribute(attributeName, "value" + i);
                        break;
                    case "Integer":
                        matter.setAttribute(attributeName, i);
                        break;
                    case "Date":
                        matter.setAttribute(attributeName, new Date());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid attribute type: " + attributeType);
                }
            }
            entities.add(matter);
        }
        return entities;
    }

    // Helper method to generate a random string of a given length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Helper method to generate random Date in the past or future
    private static Date generateRandomDate() {
        Random random = new Random();
        long currentTimeMillis = System.currentTimeMillis();
        // Generate a random time between now and 5 years in the future or past
        long randomTime = (random.nextLong() % (5L * 365 * 24 * 60 * 60 * 1000)) + currentTimeMillis;
        return new Date(randomTime);
    }

    // Helper method to generate random Matter object with overlapping attributes
    public static List<Matter> generateMatters() {
        List<Matter> matters = new ArrayList<>();
        Random random = new Random();
        List<String> overlappingMatterTypes = Arrays.asList("Legal Case", "Corporate Matter", "Contract Dispute", "Tax Audit");
        List<String> overlappingOwners = Arrays.asList("John Doe", "Jane Smith", "Michael Johnson", "Emily Davis");
        List<String> overlappingSubtypes = Arrays.asList("Litigation", "Advisory", "Compliance", "Transactional");
        List<String> overlappingClients = Arrays.asList("Client A", "Client B", "Client C", "Client D");
        List<String> overlappingJurisdictions = Arrays.asList("US", "UK", "CA", "AU");

        for (int i = 0; i < 10; i++) {
            Matter matter = new Matter();

            matter.setAttribute("matterType", overlappingMatterTypes.get(random.nextInt(overlappingMatterTypes.size())));
            matter.setAttribute("matterName", generateRandomString(8));
            matter.setAttribute("matterDescription", generateRandomString(50));
            matter.setAttribute("matterId", i + 1);
            matter.setAttribute("matterStatus", random.nextBoolean() ? "Open" : "Closed");
            matter.setAttribute("matterStartDate", generateRandomDate());
            matter.setAttribute("matterEndDate", generateRandomDate());
            matter.setAttribute("matterSubtype", overlappingSubtypes.get(random.nextInt(overlappingSubtypes.size())));
            matter.setAttribute("jurisdiction", overlappingJurisdictions.get(random.nextInt(overlappingJurisdictions.size())));
            matter.setAttribute("matterOwner", overlappingOwners.get(random.nextInt(overlappingOwners.size())));
            matter.setAttribute("matterClient", overlappingClients.get(random.nextInt(overlappingClients.size())));
            matter.setAttribute("matterClientContact", generateRandomString(10));
            matter.setAttribute("matterClientContactEmail", generateRandomString(5) + "@example.com");

            matters.add(matter);
        }
        return matters;
    }
}
