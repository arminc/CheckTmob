/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.coralic.j2me.checktmob;

/**
 *
 * @author Armin Čoralić
 */
public class DataBean
{
    private String saldo = "";
    private String date = "";
    private String abo_type = "";
    private String other_kosts = "";

    public String getSaldo()
    {
        return saldo;
    }

    public void setSaldo(String saldo)
    {
        this.saldo = saldo;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getAbo_type()
    {
        return abo_type;
    }

    public void setAbo_type(String abo_type)
    {
        this.abo_type = abo_type;
    }

    public String getOther_kosts()
    {
        return other_kosts;
    }

    public void setOther_kosts(String other_kosts)
    {
        this.other_kosts = other_kosts;
    }
}
