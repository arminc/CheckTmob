/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.coralic.j2me.checktmob;

import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

/**
 *
 * @author Armin Čoralić
 */
public class Logger
{

    private static final boolean log = false;
    private static final String DEBUG = "Debug";
    private static final String ERROR = "Error";

    public static void debug(String str, Class cls)
    {
        if (Logger.log)
        {
            Logger.writeToSystemOut(str);
            Logger.writeToFile(str, cls, Logger.DEBUG);
        }
    }

    public static void error(Exception e, Class cls)
    {
        if (Logger.log)
        {
            Logger.writeToSystemOut(e.getMessage());
            Logger.writeToFile(e.getMessage(), cls, Logger.ERROR);
        }
    }

    private static synchronized void writeToSystemOut(String str)
    {
        System.out.println(str);
    }

    private static synchronized void writeToFile(String str, Class cls, String level)
    {
        try
        {
            FileConnection fileConnection = (FileConnection) Connector.open("file:///e:/CheckTmobDebug.txt");
            if (!fileConnection.exists())
            {
                fileConnection.create();
            }
            byte[] b = new byte[(int) fileConnection.fileSize()];
            int len = fileConnection.openInputStream().read(b);
            StringBuffer strBuff = new StringBuffer();
            strBuff.append(new String(b, 0, len));
            strBuff.append("\n");
            strBuff.append(getDate());
            strBuff.append(" ");
            strBuff.append(cls.getName());
            strBuff.append(" ");
            strBuff.append(level);
            strBuff.append(" - ");
            strBuff.append(str);
            OutputStream out = fileConnection.openOutputStream();
            out.write(strBuff.toString().getBytes());
            out.flush();
            out.close();
            fileConnection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String getDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return ""+calendar.get(Calendar.DATE)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+":"+calendar.get(Calendar.MILLISECOND);
    }
}
