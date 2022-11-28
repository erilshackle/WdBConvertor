/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package convertor;

/**
 *
 * @author Admin
 */
public enum ConvertionType {
    dBm_watt("dBm -> Watts", "dBm para Watts", "10ˆ((dBm-30)/10)"),
    dBm_mW("dBm -> mW", "dBm para miliWatts", "1mW • 10ˆ(dBm/10)"),
    dBm_dBW("dBm -> dBW", "dBm para dBW", "dBm - 30"),
    dBW_dBm("dBW -> dBm", "dBW para dBm", "dBm + 30"),
    dBW_watt("dBW -> Watts", "dBW para Watts", "10ˆ(dBW/10)"),
    watt_dBW("watts -> dBW", "watts para dBW", "10 • log10(W)"),
    watt_dBm("watts -> dBm", "watts para dBm", "10 • log10(W)+30"),
    watt_MW("watts -> MW", "watts para MegaWatts", "W • 10ˆ(6)"),
    watt_mW("watts -> mW", "watts para miliWatts", "W • 10ˆ(3)"),
    watt_kW("watts -> kW", "watts para kiloWatts", "W • 10ˆ(-3)"),
    kW_watt("kW -> Watts", "kiloWatts para Watts", "kW • 10ˆ3"),
    kW_MW("kW -> MW", "kiloWatts para MegaWatts", "kW • 10ˆ(-3)"),
    kW_mW("kW -> mW", "kiloWatts para miliWatts", "kW • 10ˆ6"),
    mW_kW("mW -> kW", "miliWatts para kiloWatts", "mW • 10ˆ(-6)"),
    mW_watt("mW -> Watt", "miliWatts para Watt", "mW • 10ˆ(-3)"),
    mW_dBm("mW -> dBm", "mW para dBm", "10⋅log10(P(mW)/1mW)");
    
    private final String value;
    private final String description;
    private final String formula;
    
    ConvertionType(String v, String d, String f){
        value = v;
        description = d;
        formula = f;
    }
    
    @Override
    public String toString(){
        return value;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getFormula(){
        return formula;
    }
    
}