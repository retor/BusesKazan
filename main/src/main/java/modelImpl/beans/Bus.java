package modelImpl.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by retor on 29.12.2014.
 */
public class Bus {
    @JsonProperty("updated_at")
    private String updated_at;
    @JsonProperty("data")
    private Data data;

    private double prevLatitude;
    private double prevLongitude;
    private float alpha = 1;
    private boolean visible = true;

/*    public Bus(JSONObject object) {
        if (object != null) {
            GaragNumb = object.optJSONObject("data").optInt("GaragNumb");
            Azimuth = object.optJSONObject("data").optLong("Azimuth");
            Graph = object.optJSONObject("data").optInt("Graph");
            Latitude = object.optJSONObject("data").optDouble("Latitude");
            Longitude = object.optJSONObject("data").optDouble("Longitude");
            Marsh = object.optJSONObject("data").optString("Marsh");
            Smena = object.optJSONObject("data").optInt("Smena");
            Speed = object.optJSONObject("data").optInt("Speed");
            TimeNav = object.optJSONObject("data").optString("TimeNav");
            updated_at = object.optString("updated_at");
        }
    }*/

    public Bus() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public double getPrevLatitude() {
        return prevLatitude;
    }

    public void setPrevLatitude(double prevLatitude) {
        this.prevLatitude = prevLatitude;
    }

    public double getPrevLongitude() {
        return prevLongitude;
    }

    public void setPrevLongitude(double prevLongitude) {
        this.prevLongitude = prevLongitude;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public class Data {
        @JsonProperty("Marsh")
        private String Marsh;
        @JsonProperty("Smena")
        private int Smena;
        @JsonProperty("Speed")
        private int Speed;
        @JsonProperty("TimeNav")
        private String TimeNav;
        @JsonProperty("GaragNumb")
        private int GaragNumb;
        @JsonProperty("Azimuth")
        private long Azimuth;
        @JsonProperty("Graph")
        private int Graph;
        @JsonProperty("Latitude")
        private double Latitude;
        @JsonProperty("Longitude")
        private double Longitude;
        public long getAzimuth() {
            return Azimuth;
        }

        public void setAzimuth(long azimuth) {
            Azimuth = azimuth;
        }

        public int getGaragNumb() {
            return GaragNumb;
        }

        public void setGaragNumb(int garagNumb) {
            GaragNumb = garagNumb;
        }

        public int getGraph() {
            return Graph;
        }

        public void setGraph(int graph) {
            Graph = graph;
        }

        public double getLatitude() {
            return Latitude;
        }

        public void setLatitude(double latitude) {
            Latitude = latitude;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLongitude(double longitude) {
            Longitude = longitude;
        }

        public String getMarsh() {
            return Marsh;
        }

        public void setMarsh(String marsh) {
            Marsh = marsh;
        }
        public int getSmena() {
            return Smena;
        }

        public void setSmena(int smena) {
            Smena = smena;
        }

        public int getSpeed() {
            return Speed;
        }

        public void setSpeed(int speed) {
            Speed = speed;
        }

        public String getTimeNav() {
            return TimeNav;
        }

        public void setTimeNav(String timeNav) {
            TimeNav = timeNav;
        }
    }
}
