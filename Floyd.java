import java.util.ArrayList;
import java.util.HashMap;

public class Floyd {

    String cnt = "";
    Integer[][] t;
    String Mtr2 [][];
    public String [] [] recarcular(String [] [] Matriz)
    {
        Mtr2=copiar(Matriz);
        t = new Integer[Mtr2.length][Mtr2.length];
        for(int i=0;i<Mtr2.length;i++) {
            for (int j = 0; j < Mtr2.length; j++) {
                t[i][j]=0;
            }
        }

        for(int k =1;k<Mtr2.length;k++)
        {
            for(int i=1;i<Mtr2.length;i++)
            {
                for(int j=1;j<Mtr2.length;j++)
                {
                    int cambio = Integer.parseInt(Mtr2[i][j]);
                    int a = Integer.parseInt(Mtr2[i][k]);
                    int b = Integer.parseInt(Mtr2[k][j]);

                    if (cambio>a+b)
                    {
                        Mtr2[i][j]=(a+b)+"";
                        t[i][j]=k;
                    }
                }
            }
        }

        return Mtr2;
    }

    public void path(int q, int r)
    {
        if (t[q][r]!=0)
        {
            path(q,t[q][r]);
            System.out.println("Para llegar al destino se paso por:"+ Mtr2[0][t[q][r]]);
            path(t[q][r],r);

        }
    }

    public  void centro()
    {
        HashMap<Integer,Integer> posiciones = new HashMap<>();
        int x=0,y=0;
        int [] menor= new int[Mtr2.length];
        for (int i=1;i< Mtr2.length;i++)
        {
            for (int j=1; j<Mtr2.length;j++)
            {
                if(Integer.parseInt(Mtr2[i][j])>menor[i]) {
                    menor[i]=Integer.parseInt(Mtr2[i][j]);
                    x=i;

                }
            }
            posiciones.put(menor[i],x);

        }
        int menor2=0;
        for (int i =0;i<menor.length-1;i++)
        {
            if(menor[i]<menor[i+1]) {
                menor2=menor[i];
            }
            else
            {
                menor2=menor[i+1];
            }
        }

        System.out.println("El centro del grafo es:"+ Mtr2[posiciones.get(menor2)][0]);
    }

    private String [] [] copiar(String [] [] M1 )
    {
        String [] [] M2 = new String[M1.length][M1.length];

        for (int i =0;i<M1.length;i++)
        {
            for (int j =0;j<M1.length;j++)
            {
                M2[i][j]=M1[i][j];
            }
        }

        return M2;
    }

    public String [][] cambio(String [][] Matriz,int x,int y,String cambio)
    {
        Matriz[x][y]=cambio;
        return  Matriz;
    }
}