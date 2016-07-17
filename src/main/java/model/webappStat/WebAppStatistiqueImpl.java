package model.webappStat;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class WebAppStatistiqueImpl implements WebAppStatistique{
    
private static Logger logger = Logger.getLogger( WebAppStatistiqueImpl.class);
private Hashtable<String, Integer> Statisque=new Hashtable<String, Integer>();

/*
 * 
 * 
 */
public boolean addStatValue(String value, Integer initial)
{
    if(value!=null &&initial!=null&&!"".equals( value ))
    {
        Statisque.put( value, initial );
        return true;
    }
    return false;
}

/*
 * 
 * 
 */

public boolean updateValue(String value, Integer toAdd )
{
    if(value!=null &&toAdd!=null&&!"".equals( value ))
    {
        if(Statisque.containsKey(value)){
        //just update a value, we add the number to the current
        Statisque.put(value, Statisque.get( ( value))+toAdd );
        
        return true;
        }
    }
    return false;
}

public boolean deletValue(String value, Integer toAdd )
{
    if(value!=null &&toAdd!=null&&!"".equals( value ))
    {
        if(Statisque.containsKey(value)){
        //delete a value
        Statisque.remove(value);
        
        return true;
        }
    }
    return false;
}

public boolean resetValue(String value, Integer toAdd )
{
    if(value!=null &&toAdd!=null&&!"".equals( value ))
    {
        if(Statisque.containsKey(value)){
        //reset a value
        Statisque.put(value, 1 );
        
        return true;
        }
    }
    return false;
}

public boolean resetAll()
{
    
        //clear all values
      Statisque.clear();
        
   
    return true;
}
}
