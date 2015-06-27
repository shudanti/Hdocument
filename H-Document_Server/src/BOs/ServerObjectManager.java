/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOs;

import java.net.ServerSocket;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author 12123_000
 */
public class ServerObjectManager {

   
    
    private static Map<String, ServerObject> objects = new TreeMap<String, ServerObject>();
        // object pool
    
    public static void InitAllObject()
    {
        List<ServerObject> documents = Document.GetAllDocument();
        
        int maxHandle = 1;
        
        for(ServerObject so : documents)
        {
            objects.put(so.Handle, so);
            
            if(maxHandle < Integer.parseInt(so.Handle))
            {
                maxHandle = Integer.parseInt(so.Handle);
            }
        }
        
        List<ServerObject> accounts = Account.GetAllAccount();
        
        
        
        for(ServerObject so : accounts )
        {
            objects.put(so.Handle, so);
            
            if(maxHandle < Integer.parseInt(so.Handle))
            {
                maxHandle = Integer.parseInt(so.Handle);
            }
        }
        
       ServerObject._NextAvailableHandle = maxHandle + 1;
    }

        public static void RegisterObject(ServerObject serverObject)
        {
            //objects.Add(serverObject);
            objects.put(serverObject.Handle, serverObject);
        }

        public static void UnregisterObject(ServerObject serverObject)
        {
            //objects.Remove(serverObject);
            objects.remove(serverObject.Handle);
        }

        public static ServerObject FindObject(int handle)
        {
            return objects.get(handle);
        }




        public static String CreateNewObject(String ObjectType)
        {
            ServerObject obj = null;
            switch (ObjectType)
            {
                case "Account": obj = new Account(); break;
                case "Document": obj = new Document(); break;
            }
            if (obj != null)
                return obj.Handle;
            return "";
        }

        public static boolean SetAttributeValue(String Handle, String strAttributeName, Object newValue)
        {
            if (IsValidHandle(Handle))
            {
                ServerObject object = objects.get(Handle);
                boolean b = object.SetAttributeValue(strAttributeName, newValue);
                objects.put(Handle, object);
                return b;
            }
            return false;
        }

        private static boolean IsValidHandle(String Handle)
        {
            return Handle.compareTo("-1") != 0;
        }

        public static Object GetAttributeValue(String Handle, String strAttributeName)
        {
            if (IsValidHandle(Handle))
            {
                return objects.get(Handle).GetAttributeValue(strAttributeName);
                
            }
            return null;
        }

        public static Object ExecuteMethod(String Handle, String strFunctionName, Object param)
        {
            if (IsValidHandle(Handle))
            {
              
                ServerObject object = objects.get(Handle);
                Object o = object.ExecuteFunction(strFunctionName, param);
                objects.put(Handle, object);
                return o;
            }
            return null;
        }
    
        
        public static Object ExecuteStaticMethod(String ObjectType, String strFunctionName, Object param)
        {
            Object obj = null;
            switch (ObjectType)
            {
                case "Account":
                    obj = Account.ExecuteStaticFunction(strFunctionName, param); break;
                case "Document":
                    obj = Document.ExecuteStaticFunction(strFunctionName, param); break;
            }
            return obj;
        }
        
        public static boolean AddBindingInfor(String Handle, BindingInfor bi)
        {
            if (IsValidHandle(Handle))
            {
                ServerObject object = objects.get(Handle);
                boolean b = object.AddBindingInfor(bi);
                objects.put(Handle, object);
                return b;
            }
            return false;
        }
}
