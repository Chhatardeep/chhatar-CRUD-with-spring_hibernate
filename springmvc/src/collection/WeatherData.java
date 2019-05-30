package collection;

import java.util.Date;

public class WeatherData {
	
	private Date time;
	private float precipitation;
	private float humidity;
	private float barometricPressure;
	private float windSpeed;
	private float direction;
	
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(float precipitation) {
		this.precipitation = precipitation;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getBarometricPressure() {
		return barometricPressure;
	}
	public void setBarometricPressure(float barometricPressure) {
		this.barometricPressure = barometricPressure;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	
	
}
