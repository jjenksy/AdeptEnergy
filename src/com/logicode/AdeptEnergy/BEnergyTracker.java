package com.logicode.AdeptEnergy;
import javax.baja.sys.*;


import javax.baja.sys.BAbsTime;

/**
 * Created by jjenkins on 9/2/2016.
 * This module takes inputs from a meter then perform the calculations
 * to display consumpstion and usage for daily, monthly and annually
 * inherits properties from BComponent
 */
public class BEnergyTracker extends BComponent{


    // boolean property: fooBar
    public static final Property fooBar = newProperty(0, true);
    public boolean getFooBar() { return getBoolean(fooBar); }
    public void setFooBar(boolean v) { setBoolean(fooBar, v); }

    // int property: cool
    public static final Property cool = newProperty(0, 100);
    public int getCool() { return getInt(cool); }
    public void setCool(int v) { setInt(cool, v); }

    // double property: analog
    public static final Property analog = newProperty(0, 75.0);
    public double getAnalog() { return getDouble(analog); }
    public void setAnalog(double v) { setDouble(analog, v); }

    // float property: description
    public static final Property description = newProperty(0, "describe me");
    public String getDescription() { return getString(description); }
    public void setDescription(String x) { setString(description, x); }

    // BObject property: timestamp
    public static final Property timestamp = newProperty(0, BAbsTime.DEFAULT);
    public BAbsTime getTimestamp() { return (BAbsTime)get(timestamp); }
    public void setTimestamp(BAbsTime v) { set(timestamp, v); }


    // action: makeMyDay
    public static final Action makeMyDay = newAction(0);
    public void makeMyDay() { invoke(makeMyDay, null, null); }
    public void doMakeMyDay() {  System.out.println("Make my day!"); }

    // action: increment


//    public static final Action increment = newAction(0, new BInteger(1));
//    public BInteger increment(BInteger v)
//    { return (BInteger)invoke(increment, v, null); }
//    public BInteger doIncrement(BInteger i)
//    { return new BInteger(i.getInt()+1); }



    // topic: exploded
    public static final Topic exploded = newTopic(0);
    public void fireExploded(BString event) { fire(exploded, event, null); }
    ////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    public Type getType() { return TYPE; }
    public static final Type TYPE = Sys.loadType(BEnergyTracker.class);

}
