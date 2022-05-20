import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Reader {

    HashMap<String,Integer> posx;
    public String [] [] Reader(String name) {

        ArrayList<String> temporal = new ArrayList<>();
        try {
            File file = new File(name);
            Scanner Reader = new Scanner(file);

            while (Reader.hasNextLine()) {

                String readd = Reader.nextLine();
                String[] splitt = readd.split(" ");

                if (temporal.size()==0) {
                    temporal.add(splitt[0]);
                    temporal.add(splitt[1]);
                } else{
                    if (!temporal.contains(splitt[0])){
                        temporal.add(splitt[0]);
                    }if (!temporal.contains(splitt[1])){
                        temporal.add(splitt[1]);
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Error, no se puede abrir el archivo "+ e);
        }
        
        int sze = temporal.size()+1;
        String [] [] plaze = new String[sze][sze];
        posx = new HashMap<String, Integer>();
        for (int i =0;i<sze;i++){

            for (int j =0;j<sze;j++){
                plaze[i][j]="10000000";
            }
        } for (int j =0;j<sze;j++)
        {
            plaze[j][j]="0";
        }

        int x=1;
        int y=0;
        try {
            File file = new File(name);
            Scanner Reader = new Scanner(file);

            while (Reader.hasNextLine()){

                String Line = Reader.nextLine();
                String [] splitt = Line.split(" ");
                boolean fll =true;
                if (x==1){
                    plaze[0][x]=splitt[0];
                    plaze[x][0]=splitt[0];
                    posx.put(splitt[0],x);
                    x++;
                    plaze[0][x]=splitt[1];
                    plaze[x][0]=splitt[1];
                    posx.put(splitt[1],x);
                    x++;
                }
                else{

                    y=0;

                    for (int k=0;k<2;k++) {
                        fll=true;
                        for (int i = 0; i < plaze[0].length; i++) {
                            if (plaze[0][i].equals(splitt[k])) {
                                fll=false;
                            }
                        }
                        if (fll){
                            plaze[0][x]=splitt[k];
                            posx.put(splitt[k],x);
                            plaze[x][0]=splitt[k];
                            x++;
                        }
                    }
                }plaze[posx.get(splitt[0])][posx.get(splitt[1])]=splitt[2];
            }
        }catch (FileNotFoundException e){
            System.out.println("Error, no se puede abrir el archivo "+ e);
        }return plaze;
    }

    public HashMap<String,Integer> posiciones() {
        return posx;
    }
}