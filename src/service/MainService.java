package service;

import datastr.MyGraph;

public class MainService
{
    public static void main(String[] args) throws Exception {
        MyGraph<String> map = new MyGraph<>();
        try{
            map.addVertice("Daugavpils");
            map.addVertice("Liepaja");
            map.addVertice("Dagda");
            map.addVertice("Ventspils");
            map.addVertice("Riga");
            map.addVertice("Aizkraukle");
            map.addVertice("Rezekne");

            map.addEdge("Daugavpils", "Liepaja", 400);
            map.addEdge("Liepaja", "Dagda", 400);
            map.addEdge("Ventspils", "Aizkraukle", 200);
            map.addEdge("Dagda", "Liepaja", 500);
            map.addEdge("Riga", "Ventspils", 180);
            map.addEdge("Aizkraukle", "Ventspils", 180);
            map.addEdge("Rezekne", "Riga", 300);
            map.addEdge("Rezekne", "Dagda", 280);
            map.addEdge("Rezekne", "Rezekne", 580);

            map.print();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
