/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import BOs.ServerObjectManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12123_000
 */
public abstract class ServerObject {
    static public int _NextAvailableHandle = 1;

        protected List<BindingInfor> bindingInfor;

        public String Handle = "";
        

        public ServerObject()
        {
            bindingInfor = new ArrayList<BindingInfor>();
        }

        public void UnregisterObject()
        {
            ServerObjectManager.UnregisterObject(this);
        }

        public  Object GetAttributeValue(String strAttributeName)
        {
            
            return null;
        }

        public  boolean SetAttributeValue(String strAttributeName, Object newValue)
        {
            return true;
        }

        public  Object ExecuteFunction(String strFunctionName, Object param)
        {
            switch(strFunctionName)
            {
                case "NotifyAll":
                    NotifyAll();
                    return null;
            }
            
            return null;
        }

        protected void NotifyAll()
        {
            for(int i = 0; i < bindingInfor.size(); i++)
            {
                 bindingInfor.get(i).Notify();
                
            }
        }

        public boolean AddBindingInfor(BindingInfor bi)
        {
           return bindingInfor.add(bi);
        }
}
