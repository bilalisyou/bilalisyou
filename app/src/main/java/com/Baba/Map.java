package com.Baba;
import com.Baba.Elements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map
{
    private int map_width;
    private int map_height;

    private Grille grid;

    private ArrayList<Elements> AllElements = new ArrayList<Elements>();

    public Map(String path)
    {

        try
        {
            File MyMap = new File(path);                   // lecture du fichier map
            Scanner Lecture = new Scanner(MyMap);
            String FirstLine = Lecture.nextLine();                       //lis la premiere ligne qui est la taille de la map
            String[] superficieMap = FirstLine.split(" ");
            map_width = Integer.parseInt(superficieMap[0]);
            map_height = Integer.parseInt(superficieMap[1]);
            grid = new Grille(map_width, map_height);

            while(Lecture.hasNextLine())
            {
                String data = Lecture.nextLine();                         // lecture des elements ligne par ligne
                String[] obj = data.split(" ");
                Elements element = null;
                if(obj[0].equals("is"))
                {
                    element = new Is(obj[0], Integer.parseInt(obj[1]), Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);

                }
                else if (obj[0].length() > 5 && obj[0].substring(0, 5).equals("text_"))
                {
                    element = new Text(obj[0],Integer.parseInt(obj[1]),Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                }
                else if (obj[0].equals("rock") ||obj[0].equals("wall")||obj[0].equals("lava")||obj[0].equals("water")||obj[0].equals("baba")||obj[0].equals("flag")||obj[0].equals("skull"))
                {
                    element = new Material(obj[0],Integer.parseInt(obj[1]),Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                }
                else if (obj[0].equals("you")|| obj[0].equals("win")||obj[0].equals("stop")||obj[0].equals("push")||obj[0].equals("hot"))
                {
                    element = new Action(obj[0],Integer.parseInt(obj[1]),Integer.parseInt(obj[2]), obj.length > 3 ? Integer.parseInt(obj[3]) : 0);
                }
                grid.addElementAtPos(element.getPosX(), element.getPosY(), element);
                AllElements.add(element);     // ajoute chaque elements dans le tableau afin de sauvgarder les entities
            }
            Lecture.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println("une erreur est d??tect??e");
            e.printStackTrace();
        }
    }

    public ArrayList<Elements> getAllElements() {
        return AllElements;
    }

    public Grille getGrid() {
        return grid;
    }
}
