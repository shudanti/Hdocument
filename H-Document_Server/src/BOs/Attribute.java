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
public class Attribute {
    public Attribute(String name, String type, Object value)
        {
            Name = name;
            Type = type;
            Value = value;
        }

        public String Name = "";

       
        public String Type = "";
        
       

        public Object Value;
        


        public String GetValueAsString()
        {
            return Value.toString();
        }
}
