package mcptek.jdevcloud.mapacovid19;

import java.util.ArrayList;
import java.util.List;

public class ListasCasos {
    //Listas
    private List<String> Provincia = new ArrayList<String>();
    private List<Integer> TotalProvincial = new ArrayList<Integer>();
    private List<Double> lat = new ArrayList<Double>();
    private List<Double> lng = new ArrayList<Double>();

    public ListasCasos(List<String> provincia, List<Integer> totalProvincial, List<Double> lat, List<Double> lng) {
        Provincia = provincia;
        TotalProvincial = totalProvincial;
        this.lat = lat;
        this.lng = lng;
    }

    public List<String> getProvincia() {
        return Provincia;
    }

    public void setProvincia(List<String> provincia) {
        Provincia = provincia;
    }

    public List<Integer> getTotalProvincial() {
        return TotalProvincial;
    }

    public void setTotalProvincial(List<Integer> totalProvincial) {
        TotalProvincial = totalProvincial;
    }

    public List<Double> getLat() {
        return lat;
    }

    public void setLat(List<Double> lat) {
        this.lat = lat;
    }

    public List<Double> getLng() {
        return lng;
    }

    public void setLng(List<Double> lng) {
        this.lng = lng;
    }
}
