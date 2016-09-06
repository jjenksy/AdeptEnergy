package com.logicode.AdeptEnergy;

import com.tridium.history.db.BLocalDbHistory;

import javax.baja.naming.BOrd;
import javax.baja.sys.*;


/**
 * Created by jjenkins on 9/2/2016.
 * This module takes inputs from a meter then perform the calculations
 * to display consumption and usage for daily, monthly and annually
 * inherits properties from BComponent
 */
public class BEnergyTracker extends BComponent{


    // boolean property: fooBar
//    public static final Property fooBar = newProperty(0, true);
//    public boolean getFooBar() { return getBoolean(fooBar); }
//    public void setFooBar(boolean v) { setBoolean(fooBar, v); }

    // int property: cool
//    public static final Property cool = newProperty(0, 100);
//    public int getCool() { return getInt(cool); }
//    public void setCool(int v) { setInt(cool, v); }

    // create a property consumption with a defalt val of 75.0
    public static final Property consumption = newProperty(0, 75.0);
    public double getConsumption() { return getDouble(consumption); }
    public void setConsumption(double v) { setDouble(consumption, v); }

    // double property: analog
    public static final Property demand  = newProperty(0, 75.0);
    public double getDemand () { return getDouble(demand); }
    public void setDemand (double v) { setDouble(demand , v); }

    // String property: description
    public static final Property description = newProperty(0, "describe me");
    public String getDescription() { return getString(description); }
    public void setDescription(String x) { setString(description, x); }

    // BObject property: timestamp
    public static final Property timestamp = newProperty(0, BAbsTime.DEFAULT);
    public BAbsTime getTimestamp() { return (BAbsTime)get(timestamp); }
    public void setTimestamp(BAbsTime v) { set(timestamp, v); }


    // action: makeMyDay
    public static final Action calculateUsage = newAction(0);
    public void calculateUsage() { invoke(calculateUsage, null, null); }
    public void doCalculateUsage() {  System.out.println("Usage Calculated!!"); }


    public static final Property BQLQuery = newProperty(0, "describe me");
    public String getBQLQuery() { return getString(BQLQuery); }
    public void setBQLQuery(String v) { setString(BQLQuery, v); }

    // action: history
    public static final Action retHistory = newAction(0);
    public void retHistory() {
        invoke(retHistory, null, null);
    }
    public void doRetHistory(){

        BLocalDbHistory db = (BLocalDbHistory) BOrd.make(getBQLQuery()).get();




        //create an istance of the history db
//        BHistoryDatabase db =((BHistoryService) Sys.getService(BHistoryService.TYPE)).getDatabase();
//        System.out.print(db);

//        try (HistorySpaceConnection conn = db.getConnection(null))
//        {
//            BIHistory history = conn.getHistory(null);
//
//            BAbsTime startTime = conn.getFirstTimestamp(history);
//            //creates an ABSTIME and make a BMmont
//            BAbsTime endTime = BAbsTime.make(2014, BMonth.make(0), 1);
//
//            BITable<BHistoryRecord> collection = conn.timeQuery(history, startTime, endTime);
//            if (collection != null)
//            {
//                try(Cursor<BHistoryRecord> cursor = collection.cursor())
//                {
//                    while (cursor.next())
//                    {
//                        BHistoryRecord rec = cursor.get();
//                        if (rec instanceof BNumericTrendRecord)
//                        {
//                            System.out.print(rec);
//                        }
//                    }
//                }
//            }
//        }
    }

    // topic: exploded
    public static final Topic exploded = newTopic(0);
    public void fireExploded(BString event) { fire(exploded, event, null); }
    ////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BEnergyTracker.class);

}
