package com.Baba.Elements;

import com.Baba.Grille;
import com.Baba.Map;

import java.util.ArrayList;

public class Rules
{
    public static void updaterules(Map map)
    {
        Grille grid = map.getGrid();
        for(Elements i : grid.getArrayIs())
        {
           for( Elements leftelem : grid.getElementsAtPos(i.getPosX()-1, i.getPosY()))
           {
               if(leftelem instanceof Text)
               {
                   for (Elements rightelem : grid.getElementsAtPos(i.getPosX() + 1, i.getPosY()))
                   {
                       if (rightelem instanceof Action || rightelem instanceof Text)
                       {
                           if (rightelem.getName().equals("you"))
                               for (Elements textelem : map.getAllElements())
                                   if (textelem.getName().equals(((Text)leftelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                           else if (rightelem.getName().equals("push"))
                           {
                              for (Elements textelem : map.getAllElements())
                                  if(textelem.getName().equals(((Text)leftelem).getRef()))
                                      textelem.setIsPush(true);
                                  else
                                      textelem.setIsPush(false);
                           }
                           else if (rightelem.getName().equals("stop"))
                           {
                               for (Elements textelem : map.getAllElements())
                                   if(textelem.getName().equals(((Text)leftelem).getRef()))
                                       textelem.setIsStop(true);
                                   else
                                       textelem.setIsStop(false);
                           }
                           else if (rightelem.getName().equals("win"))
                           {
                               for (Elements textelem : map.getAllElements())
                                   if(textelem.getName().equals(((Text)leftelem).getRef()))
                                       textelem.setIsWin(true);
                                   else
                                       textelem.setIsWin(false);
                           }

                       }
                   }
               }
           }

            for( Elements upelem : grid.getElementsAtPos(i.getPosX(), i.getPosY() -1))
            {
                if(upelem instanceof Text)
                {
                    for (Elements downelem : grid.getElementsAtPos(i.getPosX() , i.getPosY() +1))
                    {
                        if (downelem instanceof Action || downelem instanceof Text)
                        {
                            if (downelem.getName().equals("you"))
                                for (Elements textelem : map.getAllElements())
                                    if (textelem.getName().equals(((Text)upelem).getRef()))
                                        textelem.setIsYou(true);
                                    else
                                        textelem.setIsYou(false);

                            else if (downelem.getName().equals("push"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Text)upelem).getRef()))
                                        textelem.setIsPush(true);
                                    else
                                        textelem.setIsPush(false);
                            }
                            else if (downelem.getName().equals("stop"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Text)upelem).getRef()))
                                        textelem.setIsStop(true);
                                    else
                                        textelem.setIsStop(false);
                            }
                            else if (downelem.getName().equals("win"))
                            {
                                for (Elements textelem : map.getAllElements())
                                    if(textelem.getName().equals(((Text)upelem).getRef()))
                                        textelem.setIsWin(true);
                                    else
                                        textelem.setIsWin(false);
                            }
                        }
                    }
                }
            }
        }
    }
}
