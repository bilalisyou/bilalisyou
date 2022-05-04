package com.Baba.Elements;

import java.io.FileNotFoundException;

public class Text extends Elements
{
    private String ref = "";
   public Text(String name, int posX, int posY,int direction) throws FileNotFoundException
   {
       super(name,posX,posY,direction);
       this.ref = name.substring(5);
   }

    public String getRef() {return ref;}

    @Override
    public boolean getIsPush() {
        return true;
    }
}
