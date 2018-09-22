
package ex0001;

import java.util.Date;

/**
 *
 * @author Christopher Andrä
 */
public class WetterWert
{
    private int temperatur;
    private int luftfeuchtigkeit;
    private Date zeitpunkt;

    public int getTemperatur()
    {
        return temperatur;
    }

    public void setTemperatur(int temperatur)
    {
        this.temperatur = temperatur;
    }

    public int getLuftfeuchtigkeit()
    {
        return luftfeuchtigkeit;
    }

    public void setLuftfeuchtigkeit(int luftfeuchtigkeit)
    {
        this.luftfeuchtigkeit = luftfeuchtigkeit;
    }

    public Date getZeitpunkt()
    {
        return zeitpunkt;
    }

    public void setZeitpunkt(Date zeitpunkt)
    {
        this.zeitpunkt = zeitpunkt;
    }
    
    
    
}
