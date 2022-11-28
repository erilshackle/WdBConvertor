/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convertor;

/**
 *
 * @author Fabio
 * @author Eril
 */
public class Convertor {
    
    Convertor(){
        
    }
    
    public static double convert(double value, ConvertionType type){
        switch(type){
            case dBm_watt -> {
                return dBm_watt(value);
            }
            case dBm_mW -> {
                return dBm_mW(value);
            }
            case dBm_dBW -> {
                return dBm_dBW(value);
            }
            case dBW_dBm -> {
                return dBW_dBm(value);
            }
            case dBW_watt -> {
                return dBW_watt(value);
            }
            case watt_dBW -> {
                return watt_dBW(value);
            }
            case watt_dBm -> {
                return watt_dBm(value);
            }
            case watt_MW -> {
                return watt_MW(value);
            }
            case watt_kW -> {
                return watt_kW(value);
            }
            case watt_mW -> {
                return watt_mW(value);
            }
            case kW_watt -> {
                return kW_watt(value);
            }
            case kW_mW -> {
                return kW_mW(value);
            }
            case kW_MW -> {
                return kW_MW(value);
            }
            case mW_dBm -> {
                return mW_dBm(value);
            }
            case mW_watt -> {
                return mW_watt(value);
            }
            case mW_kW -> {
                return mW_kW(value);
            }
            default -> throw new AssertionError(type.name()); 
        }
    }
     
    public static double dBm_watt(double dBm){
        return Math.pow(10,((dBm-30)/10));
    }
    public static double dBm_mW(double dBm){
        return Math.pow(10,(dBm/10));
    }
    public static double dBm_dBW(double dBm){
        return dBm - 30;
    }
    public static double dBW_dBm(double dBW){
        return dBW + 30;
    }
    public static double dBW_watt(double dBW){
        return Math.pow(10, (dBW/10) );
    }
    public static double watt_dBW(double W){
        return 10*Math.log10(W) ;
    }
    public static double watt_dBm(double W){
        return 10 * Math.log10(W) + 30;
    }
    public static double watt_MW(double W){
        return W * 1000000;
    }
    public static double watt_mW(double W){
        return W * 1000;
    }
    public static double watt_kW(double W){
        return W / 1000;
    }
    public static double kW_watt(double kW){
        return kW * 1000;
    }
    public static double kW_mW(double kW){
        return kW * 1000000;
    }
    public static double kW_MW(double kW){
        return kW / 1000;
    }
    public static double mW_kW(double mW){
        return mW / 1000000;
    }
    public static double mW_watt(double mW){
        return mW / 1000;
    }
    public static double mW_dBm(double mW){
        return 10 * Math.log10(mW);
    }
    
}
