package collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import com.google.gson.Gson;

public class MapExample {

	public static void main(String[] args) throws ParseException {

		String dateformat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateformat);

		String dateString = null;

		WeatherData commonWeather = null;
		Map<Date, Map<String, WeatherData>> country = new HashMap<Date, Map<String, WeatherData>>();

		for (int i = 1; i <= 3; i++) {
			dateString = "2019-00-00 00:00:00".replace("00", "0" + i);
			Date date = sdf.parse(dateString);
			commonWeather = new WeatherData();
			commonWeather.setDirection(10.0f+i+0.3f);
			commonWeather.setBarometricPressure(100.10f+i+0.3f);
			commonWeather.setDirection(10.5f+i+0.3f);
			commonWeather.setWindSpeed(25.3f+i+0.3f);
			commonWeather.setHumidity(63.63f+i+0.3f);
			Map<String, WeatherData> state = new HashMap<String, WeatherData>();
			state.put("Country = " + i, commonWeather);

			country.put(date, state);
		}
		for (Date outerMapkey : country.keySet()) {
			//System.out.println("Outer Map Key = " + outerMapkey);
			Map<String, WeatherData> innerMapstate = country.get(outerMapkey);
			for (String innerMapKey : innerMapstate.keySet()) {
				/*
				 * System.out.println("Inner Map Key = " + innerMapKey); CommonWeatherDataBO
				 * commonWeatherDataBO = innerMapstate.get(innerMapKey);
				 * System.out.println(commonWeatherDataBO.getBarometricPressure());
				 * System.out.println(commonWeatherDataBO.getDirection());
				 * System.out.println(commonWeatherDataBO.getHumidity());
				 * System.out.println(commonWeatherDataBO.getWindSpeed());
				 * System.out.println(commonWeatherDataBO.getPrecipitation());
				 */
			}

		}

		Gson gson = new Gson();
		String jsonInString = gson.toJson(country);
		System.out.println(jsonInString);
	}
}
