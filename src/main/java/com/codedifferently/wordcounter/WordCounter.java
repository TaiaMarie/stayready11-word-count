package com.codedifferently.wordcounter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter 
{
    public static void main(String[] args) throws FileNotFoundException
     {
        HashMap<String, Integer> hash = new HashMap<String,Integer>();

        String text = Filer.reader();
        String [] words = text.split(" ");
        for(String word : words)
        {
            if(!hash.containsKey(word) && !word.trim().isEmpty())
            {
                hash.put(word, 1);
            }
            else if(hash.containsKey(word) && !word.trim().isEmpty())
            {
                hash.replace(word, hash.get(word) + 1);
            }
        }
        sort(hash);
      }
    

    public static String sort(Map <String, Integer> hash)
    {
        String s = " ";
        List <String> sortedKeys = new ArrayList <String> (hash.keySet());

        Collections.sort(sortedKeys);

        for (String word : sortedKeys)
        {
            s += (word + "(Seen " + hash.get(word) + ")\n");
        }

        System.out.println(s);
        return s;
    }

  
} 


