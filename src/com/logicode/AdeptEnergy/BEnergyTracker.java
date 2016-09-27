package com.logicode.AdeptEnergy;

import javax.baja.naming.BOrd;
import javax.baja.naming.OrdTarget;
import javax.baja.status.BStatusString;
import javax.baja.sys.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


/**
 * Created by jjenkins on 9/2/2016.
 * This module takes inputs from a meter then perform the calculations
 * to display consumption and usage for daily, monthly and annually
 * inherits properties from BComponent
 */
public class BEnergyTracker extends BComponent{

    /*************************************************************************************************
     * This Code will Export a History file and save it as a .csv.
     *
     * The "history" will be the bql query call for the history file you wish to create.
     * The "historyName" will be the file name that it is saved as.
     * The file is saved in the "Path" location.
     * The "Path" must include a final "/" ,and the folder that you are saving to must already exist.
     * @author  CMH, Xex-com		07/31/09
     */

        /**Enter the the bql query call for the history file you wish to create.*/
        public static final Property history = newProperty(Flags.SUMMARY, new BStatusString());
        public BStatusString getHistory() { return (BStatusString)get(history);}
        public void setHistory (BStatusString v) {set(history,v);}

        /**Enter the filename of the export*/
        public static final Property historyName = newProperty(Flags.SUMMARY, new BStatusString());
        public BStatusString getHistoryName() { return (BStatusString)get(historyName);}
        public void setHistoryName (BStatusString v) {set(historyName,v);}

        /**Enter the path for the .CSV file.  Default is the Daemon folder.  Must include a final "/" ,and the folder that you are saving to must already exist.*/
        public static final Property path = newProperty(Flags.SUMMARY, new BStatusString());
        public BStatusString getPath() { return (BStatusString)get(path);}
        public void setPath (BStatusString v) {set(path,v);}



        /**
         * This action:
         *   - executes bql query which returns a ITable
         *   - formats the table as an in-memory CSV file
         *   - saves the CSV file as an file
         */
        public static final Action execute = newAction(0);
        public void execute(){
            invoke(execute, null);
        }
        public void doExecute(){
            try{
                OrdTarget table = query();
                System.out.print("Table");
                System.out.println(table);
                //the arg to get the historyname
                hist(getHistoryName().toString() ,table);
            }
            catch(Exception e){
                System.out.println(e.toString());
            }
        }

        /**
         * Perform a bql query which returns an OrdTarget for a BITable
         */
        private OrdTarget query()
                throws Exception
        {
            System.out.println("Query result: ");
            System.out.println(BOrd.make(getHistory().getValue()).resolve());
            return BOrd.make(getHistory().getValue()).resolve();
        }



        /**
         * This action saves the converted History file in the Path specified using the History name as the file name.
         */

        private void hist(String fileName, OrdTarget attachment)
                throws Exception
        {
            try
            {


                System.out.print(fileName);
                System.out.print("Attachment: ");
                System.out.println(attachment);
                FileOutputStream fos = new FileOutputStream( getPath().getValue() + getHistoryName().getValue() + ".csv", false);
                System.out.print("Arg for output stream");
                System.out.println(getPath().getValue() + getHistoryName().getValue() + ".csv");
                System.out.print("FileOutputStream: ");
                System.out.println(fos);
                ObjectOutputStream oos = new ObjectOutputStream (fos);
                System.out.print("ObjectOutputStream: ");
                System.out.println(oos);
               // oos.writeObject(attachment);
                oos.close();
            }
            catch (FileNotFoundException fnfe)
            {
                System.out.println( " Unable to find " + getHistoryName() + ".csv" );
            }
        }
        //todo set an icon
//        public BIcon getIcon() { return icon; }
//        private static final BIcon icon = BIcon.make("module://axCommunity/org/axcommunity/niagara/graphics/XENCOM_LogoMini.png");

    ////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BEnergyTracker.class);

}
