import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int  Size =3;

    private static final int  DotToWin =3;

    private static final char  DotX ='X';

    private static final char  DotO ='o';

    private static final char  DotEmpty ='.';

    private  static char[][] Map;

    private static Scanner Scann = new Scanner(System.in);

    private static Random Rand = new Random();



    public static void main(String[] args) {
        InitMap();
        PrintMap();
        int xContinue = 1;
        do{
            UserChoose();
            PrintMap();
            if(CheckWin(DotX))
            {
                System.out.println("Вы победили!");
                System.out.println("Ещё раз - 1; Выход - любая кнопка");
                xContinue = Scann.nextInt();
                InitMap();
                continue;
            }
            if(IsFull()){
                System.out.println("Ничья!");
                System.out.println("Ещё раз - 1; Выход - любая кнопка");
                xContinue = Scann.nextInt();
                InitMap();
                continue;
            }
            CompChoose();
            PrintMap();
            if(CheckWin(DotO))
            {
                System.out.println("Победил компьютер!");
                System.out.println("Ещё раз - 1; Выход - любая кнопка");
                xContinue = Scann.nextInt();
                InitMap();
                continue;
            }
            if(IsFull()){
                System.out.println("Ничья!");
                System.out.println("Ещё раз - 1; Выход - любая кнопка");
                xContinue = Scann.nextInt();
                InitMap();
                continue;
            }
        }while(xContinue==1);

    }

    private static boolean CheckWin(char pClient) {
        boolean xCheck ;
        for(int i = 0; i< Map.length;i++) {
            xCheck = true;
            for (int j = 0; j < Map[i].length; j++){
                xCheck = xCheck&& Map[i][j]==pClient;
            }
            if(xCheck)
                return xCheck;
        }

        for(int i = 0; i< Map.length;i++) {
            xCheck = true;
            for (int j = 0; j < Map[i].length; j++){
                xCheck = xCheck&& Map[j][i]==pClient;
            }
            if(xCheck)
                return xCheck;
        }
        xCheck = true;
        for(int i = 0; i< Map.length;i++) {

            for (int j = 0; j < Map[i].length; j++){
                if(i==j)
                    xCheck = xCheck&& Map[i][j]==pClient;
            }
        }
        if(xCheck)
            return xCheck;

        xCheck = true;
        for(int i = 0; i< Map.length;i++) {
            for (int j = 0; j < Map[i].length; j++){
                if(i+j==Size-1)
                    xCheck = xCheck&& Map[i][j]==pClient;
            }
        }
        if(xCheck)
            return xCheck;

        return false;

    }

    private  static void InitMap()
    {
        Map = new char[Size][Size];
        for(int i = 0; i< Map.length;i++){
            for (int j = 0; j< Map[i].length;j++)
            {
                Map[i][j] = DotEmpty;
            }

        }
    }


    private  static void PrintMap()
    {
        System.out.print("  ");
        for(int i = 1; i<= Map.length;i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        for(int i = 0; i< Map.length;i++){
            System.out.print(i+1 + " ");
            for (int j = 0; j< Map[i].length;j++){
                System.out.printf("%c ", Map[i][j]);
            }
            System.out.println();
        }
    }

    private  static void UserChoose()
    {
        int x;
        int y;
        do{
            System.out.println("Введите х у");
            x = Scann.nextInt()-1;
            y = Scann.nextInt()-1;
        }while (!CheckXY(x, y));
        Map[x][y] = DotX;
    }

    private  static void CompChoose()
    {
        int x, y;
        do{
            x = Rand.nextInt(Size);
            y = Rand.nextInt(Size);
        } while (!CheckXY(x, y));
        Map[x][y] = DotO;
    }

    private  static boolean CheckXY(int pX, int pY)
    {
        if(pX<0 || pY<0|| pX>=Size||pY>=Size)
            return false;
        return Map[pX][pY] ==DotEmpty;
    }

    private  static boolean IsFull()
    {
        for(int i = 0; i< Map.length;i++){
            for (int j = 0; j< Map[i].length;j++)
            {
                if(Map[i][j] == DotEmpty)
                    return false;
            }
        }
        return true;
    }
}
