/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

/**
 *
 * @author 12123_000
 */
import java.util.Map;
import java.util.TreeMap;


public class AttributeList {
    public Map<String, Attribute> Attributes = new TreeMap<String,Attribute>();

        public void AddAttribute(Attribute attribute)
        {
            Attributes.put(attribute.Name, attribute);
        }

        public void RemoveAttribute(String name)
        {
            Attributes.remove(name);
        }

        public Attribute FindAttribute(String name)
        {
            return Attributes.get(name);
        }

        public boolean SetAttributeValue(String AttributeName, Object AttributeValue)
        {
            if (Attributes.containsKey(AttributeName))
            {
                Attributes.put(AttributeName, (Attribute)AttributeValue);
                return true;
            }
            return false;
        }

        public Object GetAttributeValue(String AttributeName)
        {
            ;
            if (Attributes.containsKey(AttributeName))
                return Attributes.get(AttributeName).Value;
            return null;
        }
        
}
