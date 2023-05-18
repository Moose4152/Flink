
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Region","Country","State","City","Month","Day","Year","AvgTemperature"})
public class CityTemperature {
    public String Region;
    public String Country;
    public String State;
    public String City;
    public int Month;
    public int Day;
    public int Year;
    public double AvgTemperature;

    public CityTemperature(){}

    public CityTemperature(final String Region,final String Country,final String State,final String City,final int Month,final int Day,final int Year,final double AvgTemperature ){
        this.Region=Region;
        this.Country=Country;
        this.State=State;
        this.City=City;
        this.Month=Month;
        this.Day=Day;
        this.Year=Year;
        this.AvgTemperature=AvgTemperature;
    }

    @Override
    public String toString(){
        return "Region : "+ this.Region +" Country "+this.Country +" State "+this.State +" City "+ this.City + " Month "+this.Month +" Day "+this.Day+" Year "+this.Year+" AvgTemperature "+this.AvgTemperature;
    }


}


//Region,Country,State,City,Month,Day,Year,AvgTemperature
//        Africa,Algeria,,Algiers,1,1,1995,64.2