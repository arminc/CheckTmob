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
public class InternalDB
{

    static final String REC_STORE = "CheckTmob_DB_0";

    public RecordStore openRecStore()
    {
        try
        {
            return RecordStore.openRecordStore(REC_STORE, true);
        }
        catch (Exception e)
        {
            Logger.error(e, InternalDB.class);
            return null;
        }
    }

    public String[] readRecords(RecordStore rs)
    {
        try
        {
            String[] returnData = new String[2];
            Logger.debug("DB has " + rs.getNumRecords() + " records",InternalDB.class);
            if (rs.getNumRecords() <= 0)
            {
                Logger.debug("DB has no data.",InternalDB.class);
                return null;
            }
            if (rs.getNumRecords() > 2)
            {
                Logger.debug("DB has to much data.",InternalDB.class);
                return null;
            }
            byte[] recData = new byte[10];
            int len;
            for (int i = 1; i <= rs.getNumRecords(); i++)
            {
                if (rs.getRecordSize(i) > recData.length)
                {
                    recData = new byte[rs.getRecordSize(i)];
                }

                len = rs.getRecord(i, recData, 0);
                returnData[i-1] = new String(recData, 0, len);
                Logger.debug("Read data: " + returnData[i-1],InternalDB.class);
            }
            return returnData;
        }
        catch (Exception e)
        {
            Logger.error(e, InternalDB.class);
            return null;
        }
    }

    public void closeRecStore(RecordStore rs)
    {
        try
        {
            rs.closeRecordStore();
        }
        catch (Exception e)
        {
            Logger.error(e, InternalDB.class);
        }
    }

    public void deleteRecStore()
    {
        if (RecordStore.listRecordStores() != null)
        {
            try
            {
                RecordStore.deleteRecordStore(REC_STORE);
            }
            catch (Exception e)
            {
                Logger.error(e, InternalDB.class);
            }
        }
    }

    public void writeRecord(RecordStore rs, String str)
    {
        byte[] rec = str.getBytes();

        try
        {
            rs.addRecord(rec, 0, rec.length);
        }
        catch (Exception e)
        {
            Logger.error(e, InternalDB.class);
        }
    }
}
