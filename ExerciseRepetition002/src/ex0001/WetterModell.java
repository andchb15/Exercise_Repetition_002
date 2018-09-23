package ex0001;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Christopher Andrä
 */
public class WetterModell extends AbstractListModel
{

    private final ArrayList<WetterWert> liste = new ArrayList();

    public void add(WetterWert w)
    {
        liste.add(w);
    }

    @Override
    public int getSize()
    {
        return liste.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return liste.get(index);
    }

    public String[] getWetter()
    {
        String[] wetterDaten = new String[liste.size()];
        for (int i = 0; i < wetterDaten.length; ++i)
        {
            wetterDaten[i] = liste.get(i).getZeitpunkt() + "  -  " + liste.get(i).getTemperatur() + "%  -  " + liste.get(i).getLuftfeuchtigkeit() + "° ";
        }
        return wetterDaten;

    }

    public void save(File datei) throws FileNotFoundException
    {
        try (PrintWriter printWriter = new PrintWriter(datei))
        {
            for (WetterWert ww : liste)
            {
                printWriter.print(ww.getZeitpunkt() + ";");
                printWriter.print(ww.getTemperatur() + ";");
                printWriter.println(ww.getLuftfeuchtigkeit() + ";");
            }
        }

    }

    public void load(File datei) throws FileNotFoundException, IOException
    {
        FileReader fReader = new FileReader(datei);
        BufferedReader bReader = new BufferedReader(fReader);
        String line = "";

        while ((line = bReader.readLine()) != null)
        {
            String[] s = line.split(";");
            add(new WetterWert(Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[0]));
        }
        bReader.close();
        fReader.close();

    }

}
