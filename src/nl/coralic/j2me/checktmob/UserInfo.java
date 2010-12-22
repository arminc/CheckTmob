/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.coralic.j2me.checktmob;

import javax.microedition.rms.RecordStore;

/**
 *
 * @author Armin Čoralić
 */
public class UserInfo
{
    private String username = "";
    private String password = "";
    private InternalDB db = new InternalDB();

    public boolean userExists()
    {
        Logger.debug("Check if user exists.", UserInfo.class);
        RecordStore rs = db.openRecStore();
        if(rs == null)
        {
            //something went wrong while opening DB
            return false;
        }
        String[] tmpData = db.readRecords(rs);
        if(tmpData == null)
        {
            db.closeRecStore(rs);
            //no data
            return false;
        }
        setUsername(tmpData[0]);
        setPassword(tmpData[1]);
        db.closeRecStore(rs);
        return true;
    }

    public boolean checkSubmitedData(String tmpUsername, String tmpPassword, boolean save)
    {
        if (tmpUsername.equalsIgnoreCase(""))
        {
            return false;
        }
        if (tmpPassword.equalsIgnoreCase(""))
        {
            return false;
        }
        if(!save)
        {
            setUsername(tmpUsername);
            setPassword(tmpPassword);
            return true;
        }
        else
        {
            setUsername(tmpUsername);
            setPassword(tmpPassword);
            db.deleteRecStore();
            RecordStore rs = db.openRecStore();
            db.writeRecord(rs, getUsername());
            db.writeRecord(rs, getPassword());
            return true;
        }
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
