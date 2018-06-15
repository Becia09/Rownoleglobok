import java.util.Scanner;
import static java.lang.Math.abs;

public class Main
{
    public static void main (String[] args)
    {
        /*boolean flag = false;

        while (flag == false) {
            h1 = scanner.nextLine();
            flag = true;
            try {
                height = Integer.parseInt (h1);
            } catch(NumberFormatException e) {
                System.out.println ("Podano niepoprawna wartosc");
                flag = false;
            }
            if (flag == true) {
                if (height <=0 || height > 250) {
                    if (height <= 0) {
                        System.out.println("Choinka nie może mieć tak mało wierszy");
                    } else if (height > 250) {
                        System.out.println("Ooo, takiej ogromnej choinki to chyba nawet Mikolaj nie widzial. Moze cos mniejszego ?");
                    }
                    flag = false;
                }
            }
            if (flag == false) {
                System.out.println("Wpisz ponownie ilosc wierszy choinki:");
            }
        }*/



        System.out.println ("Podaj liczbe bokow rownolegloboku i kat: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); //czy dlugosc str > 0

        //String tabString[] = new String[3]; //czy są 3 elementy ?
        String tabString[] = str.split(" ");
        //String actualValue[] = str.split(" "); - czemu nie tak, tylko jak wyzej (dynamicznie czy statycznie) ?

        /*int tabInt[] = new int[3]; - tablica intow latwiejsza, ale malo mowi bez nazw poszczegolnych wartosci
        for (int i = 0; i < tabString.length; i++)
        {
            tabInt[i] = Integer.parseInt(tabString[i]);
            //System.out.println("Liczby: " + tabString[i]);
        }*/

        int width, height, angle; //szerokosc, wysokosc i kat rownolegloboku
        width = Integer.parseInt(tabString[0]);
        height = Integer.parseInt(tabString[1]);
        angle = Integer.parseInt(tabString[2]);

        //---------------------------------------------------------------klasa rownoleglobok
        System.out.println(width + " " + height + " " + angle);

        String verse = "";
        for (int i = 0; i < width; i++)
        {
            verse += "*";
        }

        if (angle == 0 || height == 1) //prostokat
        {
            for (int i = 0; i < height - 1; i++)
            {
                System.out.println(verse);
            }
            System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
        }
        else //rownoleglobok
        {
            String space = "";
            for (int i = 0; i < abs(angle); i++)
            {
                space += " ";
            }

            if (angle > 0)
            {
                for (int i = 0; i < height - 1; i++)
                {
                    System.out.println(verse);
                    verse = space + verse;
                }
                System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
            }
            else //angle < 0
            {
                String allSpace = space;
                for (int i = 0; i < height; i++)
                {
                    allSpace += space;
                }

                verse = allSpace + verse;
                for (int i = 0; i < height; i++)
                {
                    System.out.println(verse);
                    verse = verse.substring(angle);
                }
                //System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
            }
        }
    }
}


/*
slownik:
szerokosc      - width
wysokosc       - height
kąt nachylenia - slope angle
wiersz         - verse

zrobić funkcję która sprawdza czy się sparsowało do inta, jako parametr funkcji - zakres intów
sprawdzać czy tabStringów = 3
czy
*/