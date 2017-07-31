package edu.hyd.test;

import java.util.ArrayList;
import java.util.Iterator;

public class Arrayli extends ArrayList{
	

private static final Arrayli String1 = null;

public String toString() {
        Iterator<String> i = iterator();
        if (! i.hasNext())
           return "[]";
 StringBuilder sb = new StringBuilder();
       sb.append('[');
     for (;;) {
           String e = i.next();
            sb.append(String1 == this ? "(this Collection)" : e);
            if (! i.hasNext())            
               return sb.append(']').toString();            
           sb.append(",\n");
         
      }
   }
}