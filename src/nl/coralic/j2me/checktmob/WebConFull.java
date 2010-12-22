/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.coralic.j2me.checktmob;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpsConnection;

/**
 *
 * @author Armin Čoralić
 */
public class WebConFull
{

    private final String START_URL = "https://www.t-mobile.nl/persoonlijk/htdocs/page/homepage.aspx";
    private final String REDIRECT_URL = "https://www.t-mobile.nl/persoonlijk/htdocs/page/homepage.aspx?vid=PersoonlijkLoginLanding";
    private final String OVERVIEW_URL = "https://www.t-mobile.nl/My_T-mobile/htdocs/page/calling/status/callstatusview.aspx";
    String server_cookie = null;
    private UserInfo user;
    HttpsConnection https;

    public void start(UserInfo user)
    {
        this.user = user;
        initCall();
        login();
    }

    private void initCall()
    {
        try
        {
            //initial call
            https = (HttpsConnection) Connector.open(START_URL);
            Logger.debug("First response code: " + https.getResponseCode(), WebConFull.class);
            if (https.getResponseCode() == HttpsConnection.HTTP_OK)
            {
                server_cookie = https.getHeaderField("set-cookie");
                Logger.debug("Got cookie: " + server_cookie, WebConFull.class);
            }
            https.close();
        }
        catch (Exception e)
        {
            Logger.error(e, WebConFull.class);
        }
    }

    private void login()
    {
        try
        {
            //login call
            https = (HttpsConnection) Connector.open(START_URL, Connector.READ_WRITE);
            https.setRequestMethod(https.POST);
            String body = "__EVENTTARGET=ctl00%24ctl00%24ctl03%24relatedLinkRepeater%24ctl00%24ctl00%24ctl00%24loginControl%24loginButton&ctl00$ctl00$ctl03$relatedLinkRepeater$ctl00$ctl00$ctl00$loginControl$usernameTextBox=" + user.getUsername() + "&ctl00$ctl00$ctl03$relatedLinkRepeater$ctl00$ctl00$ctl00$loginControl$passwordTextBox=" + user.getPassword();
            //must set this
            https.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            https.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
            https.setRequestProperty("Content-Length", Integer.toString(body.length()));
            if (server_cookie != null)
            {
                https.setRequestProperty("cookie", server_cookie);
            }
            //write the data
            OutputStream out = https.openOutputStream();
            out.write(body.getBytes());
            out.flush();
            Logger.debug("Second response code: " + https.getResponseCode(), WebConFull.class);
            //must set the new cookie containing the ID if all went oke
            server_cookie = server_cookie + " " + https.getHeaderField("set-cookie");
            https.close();

            //redirect call
            https = (HttpsConnection) Connector.open(REDIRECT_URL, Connector.READ_WRITE);
            https.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
            if (server_cookie != null)
            {
                https.setRequestProperty("cookie", server_cookie);
            }
            Logger.debug("Third response code: " + https.getResponseCode(), WebConFull.class);
            https.close();
        }
        catch (Exception e)
        {
            Logger.error(e, WebConFull.class);
        }
    }

    public void getSaldoData(DataBean data)
    {
        try
        {
            https = (HttpsConnection) Connector.open(OVERVIEW_URL, Connector.READ_WRITE);
            https.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
            if (server_cookie != null)
            {
                https.setRequestProperty("cookie", server_cookie);
            }
            String tmpData = readOutput(https.openInputStream(), (int) https.getLength());
            https.close();
            //get time
            int t1 = tmpData.indexOf("ctl00_ctl00_ctl03_rowRepeater_ctl03_columnRepeater_ctl00_cellRepeater_ctl00_ctl00_ctl00_UpdateDateColumn");
            t1 = tmpData.indexOf("<b>", t1);
            int t2 = tmpData.indexOf("</b>", t1);
            data.setDate(tmpData.substring(t1 + 3, t2));
            Logger.debug("DATE = " + data.getDate(), WebConFull.class);

            //get abo
            t1 = tmpData.indexOf("&nbsp;", t1);
            t2 = tmpData.indexOf("</span>", t1);
            data.setAbo_type(tmpData.substring((t1 + 6), t2));
            Logger.debug("ABO type = " + data.getAbo_type(), WebConFull.class);

            //saldo
            t1 = tmpData.indexOf("Resterend beltegoed voor deze maand:");
            t1 = tmpData.indexOf("<td", t1);
            t1 = tmpData.indexOf(">", t1);
            t2 = tmpData.indexOf("</td>", t1);
            data.setSaldo(tmpData.substring(t1 + 5, t2));
            Logger.debug("SALDO = " + data.getSaldo(), WebConFull.class);

            //other kosts
            t1 = tmpData.indexOf("ctl00_ctl00_ctl03_rowRepeater_ctl03_columnRepeater_ctl00_cellRepeater_ctl00_ctl00_ctl00_UsageCostColumn");
            t1 = tmpData.indexOf("<strong>", t1);
            t2 = tmpData.indexOf("</strong>", t1);
            data.setOther_kosts(tmpData.substring(t1 + 12, t2));
            Logger.debug("OTHER kosts = " + data.getOther_kosts(), WebConFull.class);
        }
        catch (Exception e)
        {
            Logger.error(e, WebConFull.class);
        }
    }

    public String readOutput(InputStream is, int length) throws Exception
    {
        String str;
        if (length != -1)
        {
            byte serverData[] = new byte[length];
            is.read(serverData);
            str = new String(serverData);
        }
        else
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int ch;
            while ((ch = is.read()) != -1)
            {
                bos.write(ch);
            }
            str = new String(bos.toByteArray());
        }
        return str;
    }
}
