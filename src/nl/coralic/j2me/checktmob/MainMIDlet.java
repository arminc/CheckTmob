/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.coralic.j2me.checktmob;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Armin Čoralić
 */
public class MainMIDlet extends MIDlet implements CommandListener
{

    private boolean midletPaused = false;
    private UserInfo user = new UserInfo();
    WebConFull webFull = new WebConFull();
    DataBean data = new DataBean();

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private Form formShowData;
    private StringItem saldo;
    private StringItem editDate;
    private StringItem aboType;
    private StringItem otherKosts;
    private Form formSetLogin;
    private ChoiceGroup setSave;
    private TextField password;
    private TextField username;
    private Alert alertDataEmpty;
    private WaitScreen logInWaitScreen;
    private TextBox infoTextBox;
    private Form infoForm;
    private StringItem infoText;
    private Command exitCommand;
    private Command exitCommand1;
    private Command okCommand;
    private Command itemCommand1;
    private Command editUser;
    private Command info;
    private Command exitCommand2;
    private Command okCommand1;
    private Command helpCommand;
    private Command backCommand;
    private SimpleCancellableTask runLogin;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MainMIDlet constructor.
     */
    public MainMIDlet()
    {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    /**
     * Switches a display to previous displayable of the current displayable.
     * The <code>display</code> instance is obtain from the <code>getDisplay</code> method.
     */
    private void switchToPreviousDisplayable()
    {
        Displayable __currentDisplayable = getDisplay().getCurrent();
        if (__currentDisplayable != null)
        {
            Displayable __nextDisplayable = (Displayable) __previousDisplayables.get(__currentDisplayable);
            if (__nextDisplayable != null)
            {
                switchDisplayable(null, __nextDisplayable);
            }
        }
    }
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize()
    {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet()
    {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        checkUserDataExists();//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet()
    {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
        exitMIDlet();//GEN-LINE:|4-resumeMIDlet|1|4-postAction
    // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable)
    {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        Displayable __currentDisplayable = display.getCurrent();
        if (__currentDisplayable != null  &&  nextDisplayable != null)
        {
            __previousDisplayables.put(nextDisplayable, __currentDisplayable);
        }
        if (alert == null)
        {
            display.setCurrent(nextDisplayable);
        }
        else
        {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: checkUserDataExists ">//GEN-BEGIN:|14-if|0|14-preIf
    /**
     * Performs an action assigned to the checkUserDataExists if-point.
     */
    public void checkUserDataExists()
    {//GEN-END:|14-if|0|14-preIf
        // enter pre-if user code here
        if (user.userExists())//GEN-BEGIN:|14-if|1|15-preAction
        {//GEN-END:|14-if|1|15-preAction
            // write pre-action user code here
            switchDisplayable(null, getLogInWaitScreen());//GEN-LINE:|14-if|2|15-postAction
        // write post-action user code here
        }//GEN-BEGIN:|14-if|3|16-preAction
        else
        {//GEN-END:|14-if|3|16-preAction
            // write pre-action user code here
            switchDisplayable(null, getFormSetLogin());//GEN-LINE:|14-if|4|16-postAction
        // write post-action user code here
        }//GEN-LINE:|14-if|5|14-postIf
    // enter post-if user code here
    }//GEN-BEGIN:|14-if|6|
    //</editor-fold>//GEN-END:|14-if|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable)
    {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == formSetLogin)//GEN-BEGIN:|7-commandAction|1|77-preAction
        {
            if (command == exitCommand)
            {//GEN-END:|7-commandAction|1|77-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|2|77-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|27-preAction
            else if (command == okCommand)
            {//GEN-END:|7-commandAction|3|27-preAction
                // write pre-action user code here

                checkSubmitedData();//GEN-LINE:|7-commandAction|4|27-postAction

            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|33-preAction
        }
        else if (displayable == formShowData)
        {
            if (command == editUser)
            {//GEN-END:|7-commandAction|5|33-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormSetLogin());//GEN-LINE:|7-commandAction|6|33-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|23-preAction
            else if (command == exitCommand)
            {//GEN-END:|7-commandAction|7|23-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|8|23-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|37-preAction
            else if (command == info)
            {//GEN-END:|7-commandAction|9|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getInfoForm());//GEN-LINE:|7-commandAction|10|37-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|124-preAction
        }
        else if (displayable == infoForm)
        {
            if (command == backCommand)
            {//GEN-END:|7-commandAction|11|124-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|12|124-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|107-preAction
        }
        else if (displayable == logInWaitScreen)
        {
            if (command == WaitScreen.FAILURE_COMMAND)
            {//GEN-END:|7-commandAction|13|107-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|14|107-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|106-preAction
            else if (command == WaitScreen.SUCCESS_COMMAND)
            {//GEN-END:|7-commandAction|15|106-preAction
                // write pre-action user code here
                switchDisplayable(null, getFormShowData());//GEN-LINE:|7-commandAction|16|106-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|7-postCommandAction
        }//GEN-END:|7-commandAction|17|7-postCommandAction
    // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|18|
    //</editor-fold>//GEN-END:|7-commandAction|18|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formShowData ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initiliazed instance of formShowData component.
     * @return the initialized component instance
     */
    public Form getFormShowData()
    {
        if (formShowData == null)
        {//GEN-END:|17-getter|0|17-preInit

            formShowData = new Form("Data", new Item[] { getEditDate(), getAboType(), getSaldo(), getOtherKosts() });//GEN-BEGIN:|17-getter|1|17-postInit
            formShowData.addCommand(getExitCommand());
            formShowData.addCommand(getEditUser());
            formShowData.addCommand(getInfo());
            formShowData.setCommandListener(this);//GEN-END:|17-getter|1|17-postInit
        // write post-init user code here

        }//GEN-BEGIN:|17-getter|2|
        return formShowData;
    }
    //</editor-fold>//GEN-END:|17-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formSetLogin ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of formSetLogin component.
     * @return the initialized component instance
     */
    public Form getFormSetLogin()
    {
        if (formSetLogin == null)
        {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            formSetLogin = new Form("Set Login Details", new Item[] { getUsername(), getPassword(), getSetSave() });//GEN-BEGIN:|18-getter|1|18-postInit
            formSetLogin.addCommand(getOkCommand());
            formSetLogin.addCommand(getExitCommand());
            formSetLogin.setCommandListener(this);//GEN-END:|18-getter|1|18-postInit
        // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return formSetLogin;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand()
    {
        if (exitCommand == null)
        {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|22-getter|1|22-postInit
        // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1()
    {
        if (exitCommand1 == null)
        {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|24-getter|1|24-postInit
        // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand()
    {
        if (okCommand == null)
        {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|26-getter|1|26-postInit
        // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: editUser ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of editUser component.
     * @return the initialized component instance
     */
    public Command getEditUser()
    {
        if (editUser == null)
        {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            editUser = new Command("EditUser", Command.ITEM, 0);//GEN-LINE:|32-getter|1|32-postInit
        // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return editUser;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of itemCommand1 component.
     * @return the initialized component instance
     */
    public Command getItemCommand1()
    {
        if (itemCommand1 == null)
        {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            itemCommand1 = new Command("Item", Command.ITEM, 0);//GEN-LINE:|34-getter|1|34-postInit
        // write post-init user code here
        }//GEN-BEGIN:|34-getter|2|
        return itemCommand1;
    }
    //</editor-fold>//GEN-END:|34-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: info ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of info component.
     * @return the initialized component instance
     */
    public Command getInfo()
    {
        if (info == null)
        {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            info = new Command("Info", Command.ITEM, 0);//GEN-LINE:|36-getter|1|36-postInit
        // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return info;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|68-getter|0|68-preInit
    /**
     * Returns an initiliazed instance of exitCommand2 component.
     * @return the initialized component instance
     */
    public Command getExitCommand2()
    {
        if (exitCommand2 == null)
        {//GEN-END:|68-getter|0|68-preInit
            // write pre-init user code here
            exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|68-getter|1|68-postInit
        // write post-init user code here
        }//GEN-BEGIN:|68-getter|2|
        return exitCommand2;
    }
    //</editor-fold>//GEN-END:|68-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1()
    {
        if (okCommand1 == null)
        {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|70-getter|1|70-postInit
        // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: helpCommand ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of helpCommand component.
     * @return the initialized component instance
     */
    public Command getHelpCommand()
    {
        if (helpCommand == null)
        {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            helpCommand = new Command("Help", Command.HELP, 0);//GEN-LINE:|72-getter|1|72-postInit
        // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return helpCommand;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: username ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initiliazed instance of username component.
     * @return the initialized component instance
     */
    public TextField getUsername()
    {
        if (username == null)
        {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            username = new TextField("Username", null, 32, TextField.ANY);//GEN-BEGIN:|82-getter|1|82-postInit
            username.setLayout(ImageItem.LAYOUT_DEFAULT);
            username.setPreferredSize(-1, -1);//GEN-END:|82-getter|1|82-postInit
        // write post-init user code here
        }//GEN-BEGIN:|82-getter|2|
        return username;
    }
    //</editor-fold>//GEN-END:|82-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: password ">//GEN-BEGIN:|83-getter|0|83-preInit
    /**
     * Returns an initiliazed instance of password component.
     * @return the initialized component instance
     */
    public TextField getPassword()
    {
        if (password == null)
        {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            password = new TextField("Password", null, 32, TextField.ANY | TextField.PASSWORD);//GEN-BEGIN:|83-getter|1|83-postInit
            password.setLayout(ImageItem.LAYOUT_DEFAULT);//GEN-END:|83-getter|1|83-postInit
        // write post-init user code here
        }//GEN-BEGIN:|83-getter|2|
        return password;
    }
    //</editor-fold>//GEN-END:|83-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: setSave ">//GEN-BEGIN:|84-getter|0|84-preInit
    /**
     * Returns an initiliazed instance of setSave component.
     * @return the initialized component instance
     */
    public ChoiceGroup getSetSave()
    {
        if (setSave == null)
        {//GEN-END:|84-getter|0|84-preInit
            // write pre-init user code here
            setSave = new ChoiceGroup("Save", Choice.MULTIPLE);//GEN-BEGIN:|84-getter|1|84-postInit
            setSave.append("Check to save!", null);
            setSave.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
            setSave.setSelectedFlags(new boolean[] { false });
            setSave.setFont(0, null);//GEN-END:|84-getter|1|84-postInit
        // write post-init user code here
        }//GEN-BEGIN:|84-getter|2|
        return setSave;
    }
    //</editor-fold>//GEN-END:|84-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alertDataEmpty ">//GEN-BEGIN:|88-getter|0|88-preInit
    /**
     * Returns an initiliazed instance of alertDataEmpty component.
     * @return the initialized component instance
     */
    public Alert getAlertDataEmpty()
    {
        if (alertDataEmpty == null)
        {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            alertDataEmpty = new Alert("Data emoty", "You have to fill all data!", null, AlertType.ERROR);//GEN-BEGIN:|88-getter|1|88-postInit
            alertDataEmpty.setTimeout(Alert.FOREVER);//GEN-END:|88-getter|1|88-postInit
        // write post-init user code here
        }//GEN-BEGIN:|88-getter|2|
        return alertDataEmpty;
    }
    //</editor-fold>//GEN-END:|88-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: checkSubmitedData ">//GEN-BEGIN:|90-if|0|90-preIf
    /**
     * Performs an action assigned to the checkSubmitedData if-point.
     */
    public void checkSubmitedData()
    {//GEN-END:|90-if|0|90-preIf
        // enter pre-if user code here
        if (user.checkSubmitedData(getUsername().getString(), getPassword().getString(), getSetSave().isSelected(0)))//GEN-BEGIN:|90-if|1|91-preAction
        {//GEN-END:|90-if|1|91-preAction
            // write pre-action user code here
            switchDisplayable(null, getLogInWaitScreen());//GEN-LINE:|90-if|2|91-postAction
        // write post-action user code here
        }//GEN-BEGIN:|90-if|3|92-preAction
        else
        {//GEN-END:|90-if|3|92-preAction
            // write pre-action user code here
            switchDisplayable(null, getAlertDataEmpty());//GEN-LINE:|90-if|4|92-postAction
        // write post-action user code here
        }//GEN-LINE:|90-if|5|90-postIf
    // enter post-if user code here
    }//GEN-BEGIN:|90-if|6|
    //</editor-fold>//GEN-END:|90-if|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: runLogin ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of runLogin component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getRunLogin()
    {
        if (runLogin == null)
        {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            runLogin = new SimpleCancellableTask();//GEN-BEGIN:|100-getter|1|100-execute
            runLogin.setExecutable(new org.netbeans.microedition.util.Executable()
            {
                public void execute() throws Exception
                {//GEN-END:|100-getter|1|100-execute
                    Logger.debug("Filled username en password: " + user.getUsername() + " " + user.getPassword(), MainMIDlet.class);
                    webFull.start(user);
                    webFull.getSaldoData(data);
                }//GEN-BEGIN:|100-getter|2|100-postInit
            });//GEN-END:|100-getter|2|100-postInit
        // write post-init user code here
        }//GEN-BEGIN:|100-getter|3|
        return runLogin;
    }
    //</editor-fold>//GEN-END:|100-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: saldo ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of saldo component.
     * @return the initialized component instance
     */
    public StringItem getSaldo()
    {
        if (saldo == null)
        {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            saldo = new StringItem("Saldo", data.getSaldo());//GEN-LINE:|104-getter|1|104-postInit
        // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return saldo;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: logInWaitScreen ">//GEN-BEGIN:|105-getter|0|105-preInit
    /**
     * Returns an initiliazed instance of logInWaitScreen component.
     * @return the initialized component instance
     */
    public WaitScreen getLogInWaitScreen()
    {
        if (logInWaitScreen == null)
        {//GEN-END:|105-getter|0|105-preInit
            // write pre-init user code here
            logInWaitScreen = new WaitScreen(getDisplay());//GEN-BEGIN:|105-getter|1|105-postInit
            logInWaitScreen.setTitle("Loging in");
            logInWaitScreen.setCommandListener(this);
            logInWaitScreen.setFullScreenMode(true);
            logInWaitScreen.setText("Loging in please wait......");
            logInWaitScreen.setTask(getRunLogin());//GEN-END:|105-getter|1|105-postInit
        // write post-init user code here
        }//GEN-BEGIN:|105-getter|2|
        return logInWaitScreen;
    }
    //</editor-fold>//GEN-END:|105-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: editDate ">//GEN-BEGIN:|112-getter|0|112-preInit
    /**
     * Returns an initiliazed instance of editDate component.
     * @return the initialized component instance
     */
    public StringItem getEditDate()
    {
        if (editDate == null)
        {//GEN-END:|112-getter|0|112-preInit
            // write pre-init user code here
            editDate = new StringItem("Edit date", data.getDate());//GEN-LINE:|112-getter|1|112-postInit
            // write post-init user code here
        }//GEN-BEGIN:|112-getter|2|
        return editDate;
    }
    //</editor-fold>//GEN-END:|112-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: aboType ">//GEN-BEGIN:|113-getter|0|113-preInit
    /**
     * Returns an initiliazed instance of aboType component.
     * @return the initialized component instance
     */
    public StringItem getAboType()
    {
        if (aboType == null)
        {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            aboType = new StringItem("Abo type", data.getAbo_type());//GEN-LINE:|113-getter|1|113-postInit
            // write post-init user code here
        }//GEN-BEGIN:|113-getter|2|
        return aboType;
    }
    //</editor-fold>//GEN-END:|113-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: otherKosts ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of otherKosts component.
     * @return the initialized component instance
     */
    public StringItem getOtherKosts()
    {
        if (otherKosts == null)
        {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            otherKosts = new StringItem("Other kosts", data.getOther_kosts());//GEN-LINE:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return otherKosts;
    }
    //</editor-fold>//GEN-END:|115-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: infoTextBox ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of infoTextBox component.
     * @return the initialized component instance
     */
    public TextBox getInfoTextBox()
    {
        if (infoTextBox == null)
        {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            infoTextBox = new TextBox("Info CheckTmob", "This application is made by Armin Coralic. Visit http://j2me.coralic.nl for new versions. You can contact me at: j2me @ coralic . nl", 132, TextField.ANY);//GEN-LINE:|116-getter|1|116-postInit
            // write post-init user code here
        }//GEN-BEGIN:|116-getter|2|
        return infoTextBox;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: infoForm ">//GEN-BEGIN:|120-getter|0|120-preInit
    /**
     * Returns an initiliazed instance of infoForm component.
     * @return the initialized component instance
     */
    public Form getInfoForm()
    {
        if (infoForm == null)
        {//GEN-END:|120-getter|0|120-preInit
            // write pre-init user code here
            infoForm = new Form("Info CheckTmob", new Item[] { getInfoText() });//GEN-BEGIN:|120-getter|1|120-postInit
            infoForm.addCommand(getBackCommand());
            infoForm.setCommandListener(this);//GEN-END:|120-getter|1|120-postInit
            // write post-init user code here
        }//GEN-BEGIN:|120-getter|2|
        return infoForm;
    }
    //</editor-fold>//GEN-END:|120-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: infoText ">//GEN-BEGIN:|121-getter|0|121-preInit
    /**
     * Returns an initiliazed instance of infoText component.
     * @return the initialized component instance
     */
    public StringItem getInfoText()
    {
        if (infoText == null)
        {//GEN-END:|121-getter|0|121-preInit
            // write pre-init user code here
            infoText = new StringItem("", "This application is made by Armin Coralic. Visit http://j2me.coralic.nl for new versions. You can contact me at: j2me @ coralic . nl");//GEN-LINE:|121-getter|1|121-postInit
            // write post-init user code here
        }//GEN-BEGIN:|121-getter|2|
        return infoText;
    }
    //</editor-fold>//GEN-END:|121-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|123-getter|0|123-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand()
    {
        if (backCommand == null)
        {//GEN-END:|123-getter|0|123-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|123-getter|1|123-postInit
            // write post-init user code here
        }//GEN-BEGIN:|123-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|123-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay()
    {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet()
    {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp()
    {
        if (midletPaused)
        {
            resumeMIDlet();
        }
        else
        {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp()
    {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional)
    {
    }
}
