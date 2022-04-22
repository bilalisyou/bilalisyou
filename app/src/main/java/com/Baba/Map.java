package com.Baba;
import com.Baba.Elements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map
{
    public void ReadMap()
    {
        try
        {
            File MyMap = new File("map.txt");                   // lecture du fichier map
            Scanner Lecture = new Scanner(MyMap);
            String FirstLine = Lecture.nextLine();                       //lis la premiere ligne qui est la taille de la map
            String[] SuperficieMap = FirstLine.split(" ");

            ArrayList<Elements> AllElements = new ArrayList<Elements>();
            while(Lecture.hasNextLine())
            {
                String data = Lecture.nextLine();                         // lecture des elements ligne par ligne
                String[] obj = data.split(" ");
                Elements entities = new Elements(obj[0],Integer.parseInt(obj[1]),Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                /* separe la ligne en creant un tableau et lis la ligne en transformant les string en int */
                AllElements.add(entities);                // ajoute chaque elements dans le tableau afin de sauvgarder les entities
            }
            Lecture.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println("une erreur est détectée");
            e.printStackTrace();
        }

    }

}
