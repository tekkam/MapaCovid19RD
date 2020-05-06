package mcptek.jdevcloud.mapacovid19;

public class Casos {
    private int IdCaso;
    private String Provincia;
    private int TotalProvincial;
    private int lat;
    private int lng;

    public Casos(int idCaso, String provincia, int totalProvincial, int lat, int lng) {
        IdCaso = idCaso;
        Provincia = provincia;
        TotalProvincial = totalProvincial;
        this.lat = lat;
        this.lng = lng;
    }

    public int getIdCaso() {
        return IdCaso;
    }

    public void setIdCaso(int idCaso) {
        IdCaso = idCaso;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public int getTotalProvincial() {
        return TotalProvincial;
    }

    public void setTotalProvincial(int totalProvincial) {
        TotalProvincial = totalProvincial;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
}
