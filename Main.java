import java.security.Key;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Floyd F= new Floyd();
        Reader read = new Reader();

        String [] [] Original = read.Reader("guategrafo.txt");
        String [] [] Matriz = read.Reader("guategrafo.txt");

        boolean continuar=true;
        while (continuar) {
            System.out.println("\n.................Menu Principal.................");
            System.out.println("1)Destino Total");
            System.out.println("2)Ciudad-Centro del grafo");
            System.out.println("3)Modificar grafo ");
            System.out.println("4)Eliminar grafo ");
            System.out.println("5)Salir\n");


            String input = scan.nextLine();


            Matriz=F.recarcular(Original);

            int size = Matriz.length;

            System.out.println("");
            HashMap<String,Integer> Relaciones =read.posiciones();
            if (input.equals("1")) {
                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Selecione la Ciudad de origen");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <cont)
                        {
                            x=Integer.parseInt(a);
                            Ciudada=false;
                        }
                        else
                        {
                            System.out.println("Opcion invalida");
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                while (Ciudadb)
                {
                    System.out.println("Selecione la Ciudad a la que quiere llegar: ");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <cont)
                        {
                            y=Integer.parseInt(a);
                            Ciudadb=false;
                        }
                        else
                        {
                            System.out.println("Opcion invalida");
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }
                if (!Matriz[x][y].equals("10000000")) {
                    System.out.println("La distancia en Kilometros es de:" + Matriz[x][y]);
                    F.path(x, y);
                }
                else
                {
                    System.out.println("Esas carreteras no conectan las ciudades que solicito");
                }

            } else if (input.equals("2")) {
                F.centro();


            } else if (input.equals("3")) {
                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Selecione la Ciudad de origen");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            x=Integer.parseInt(a);
                            Ciudada=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                while (Ciudadb)
                {
                    System.out.println("Selecione la Ciudad a la que quiere llegar: ");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            y=Integer.parseInt(a);
                            Ciudadb=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }
                boolean num=true;
                while (num)
                {
                    System.out.println("Ingrese el nuevo kilometraje");

                    String a=scan.nextLine();
                    try
                    {
                        int res = Integer.parseInt(a);
                        Original=F.cambio(Original,x,y,res+"");
                        Matriz=F.cambio(Matriz,x,y,res+"");
                        num=false;
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }




            }else if (input.equals("4")) {

                boolean Ciudada= true;
                boolean Ciudadb= true;
                int x=0,y=0;
                while (Ciudada)
                {
                    System.out.println("Selecione la Ciudad de origen");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            x=Integer.parseInt(a);
                            Ciudada=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                while (Ciudadb)
                {
                    System.out.println("Selecione la Ciudad a la que quiere llegar: ");
                    int cont =1;
                    for (String key : Relaciones.keySet())
                    {
                        System.out.println(cont+")"+ Matriz[0][cont]);
                        cont++;
                    }

                    String a=scan.nextLine();
                    try
                    {
                        if (Integer.parseInt(a) <=cont)
                        {
                            y=Integer.parseInt(a);
                            Ciudadb=false;
                        }
                    }
                    catch (IllegalFormatException e)
                    {
                        System.out.println("Opcion invalida");
                    }
                }

                Original=F.cambio(Original,x,y,10000000+"");
                Matriz=F.cambio(Matriz,x,y,10000000+"");


            }

            else if (input.equals("5")) {
                continuar = false;

            } else {
                System.out.println("Opcion invalida");
            }
        }

    }

}