package ex0001;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Christopher Andrä
 */
public class WetterModell extends AbstractListModel
{

    private ArrayList<WetterWert> liste = new ArrayList();

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

    public void save()
    {

    }

    public void load()
    {

    }

}
