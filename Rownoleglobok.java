import java.util.Scanner;
import static java.lang.Math.abs;

public class Rownoleglobok
{
    public static int parserInt(String number, int rangeBegin, int rangeEnd)
    {
        boolean flag = false;
        int result = -101; //deklaracja tu ? z jaka wartością ? -101 bo nie mieści się w wymaganiach

        try {
            result = Integer.parseInt (number);
        } catch(NumberFormatException e) {
            System.out.println ("Podano nieliczbową wartosc");
            flag = false;
        }
        if (flag == true) {
            if (result < rangeBegin || result > rangeEnd) {
                System.out.println("Podana wartosc jest za duza lub za mała");
                flag = false;
            }
        }
        if (flag == false) {
            System.out.println("Wpisz ponownie ilosc wierszy choinki:");
        }
        return result;
    }
    public static void main (String[] args)
    {
        System.out.println ("Podaj dlugosci bokow rownolegloboku i kat: ");
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
        System.out.println("rozmiar tablicy: " + tabString.length);

        int width, height, angle; //szerokosc, wysokosc i kat rownolegloboku
        //width = Integer.parseInt(tabString[0]);
        height = Integer.parseInt(tabString[1]);
        angle = Integer.parseInt(tabString[2]);
        width = parserInt(tabString[0]);

        //---------------------------------------------------------------klasa rownoleglobok
        System.out.println(width + " - szerokosc\n" + height + " - wysokosc");
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
sprawdzać czy tabStringów >= 3
czy
*/