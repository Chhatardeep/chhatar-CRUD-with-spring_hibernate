package collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.google.gson.Gson;

public class Practise {

	public static void main(String[] args) throws ParseException {

		Map<String, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>> country = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = formatter.parse("2010-12-20 00:00:00");
		Date endDate = formatter.parse("2010-12-21 00:00:00");

		Map<Date, List<WeatherData>> weatherData = getWeatherDataWithTimeBloack(startDate, endDate, 12);
		List<LatLong> latlonglist = getLatLong(10);
		Map<String, Map<Date, List<WeatherData>>> weatherDataByLatLong = getWeatherDataByLatLong(latlonglist,
				weatherData);
		List<String> areaWiseLatLong = AreaWiseLatLong();
		Map<String, Map<String, Map<Date, List<WeatherData>>>> areaWiseLatLongData = AreaWiseLatLongData(
				weatherDataByLatLong, areaWiseLatLong);
		List<String> cityWiseAreaList = CityWiseAreaList();
		Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>> cityWiseAreaData = CityWiseAreaData(
				cityWiseAreaList, areaWiseLatLongData);
		List<String> StateWiseCityList = StateWiseCityList();
		Map<String, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>> StateWiseCityData = StateDataCityWise(
				StateWiseCityList, cityWiseAreaData);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(StateWiseCityData);
		System.out.println(jsonInString);

	}

	public static Map<Date, List<WeatherData>> getWeatherDataWithTimeBloack(Date startDate, Date endDate, int block) {
		Map<Date, List<WeatherData>> weatherDatas = new TreeMap<Date, List<WeatherData>>();
		while (startDate.before(endDate)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			startDate = calendar.getTime();
			List<WeatherData> WeatherDataList = new ArrayList<WeatherData>();
			for (int i = 0; i < block * 15; i += 15) {
				WeatherData weatherData = new WeatherData();
				Date objectTime = startDate;
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(objectTime);
				calendar2.add(Calendar.MINUTE, i);
				objectTime = calendar2.getTime();
				weatherData.setTime(objectTime);
				weatherData.setBarometricPressure(1.1f + i);
				weatherData.setDirection(1.1f + i + i);
				weatherData.setHumidity(1.1f + i + i + i);
				weatherData.setPrecipitation(1.1f + i + i + i);
				weatherData.setWindSpeed(1.1f + i + i + i + i);
				WeatherDataList.add(weatherData);

			}
			weatherDatas.put(startDate, WeatherDataList);
		}
		return weatherDatas;
	}

	public static Map<String, Map<Date, List<WeatherData>>> getWeatherDataByLatLong(List<LatLong> list,
			Map<Date, List<WeatherData>> map) {
		Map<String, Map<Date, List<WeatherData>>> LatLongWiseData = new TreeMap<String, Map<Date, List<WeatherData>>>();

		for (LatLong local : list) {
			String lat = String.valueOf(local.getLat());
			String longi = String.valueOf(local.getLongi());
			String mapKey = "Lat = " + lat + " Long = " + longi;
			LatLongWiseData.put(mapKey, map);
		}

		return LatLongWiseData;

	}

	public static List<LatLong> getLatLong(int number) {
		List<LatLong> latlonglist = new ArrayList<LatLong>();
		for (int i = 5; i <= number; i += 5) {
			LatLong latlong = new LatLong();
			latlong.setLat(i * 2);
			latlong.setLongi(i * 3);
			latlonglist.add(latlong);
		}
		return latlonglist;

	}

	public static Map<String, Map<String, Map<Date, List<WeatherData>>>> AreaWiseLatLongData(
			Map<String, Map<Date, List<WeatherData>>> weatherDataByLatLong, List<String> area) {
		Map<String, Map<String, Map<Date, List<WeatherData>>>> AreaWiseLatLongDataMap = new TreeMap<String, Map<String, Map<Date, List<WeatherData>>>>();
		for (String localArea : area) {
			AreaWiseLatLongDataMap.put(localArea, weatherDataByLatLong);
		}
		return AreaWiseLatLongDataMap;

	}

	public static List<String> AreaWiseLatLong() {
		List<String> area = new ArrayList<String>();
		for (int i = 1; i <= 2; i++) {
			String localArea = "LocalArea = " + i;
			area.add(localArea);
		}
		return area;

	}

	public static List<String> CityWiseAreaList() {
		List<String> cities = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			String localCity = "City=" + i;
			cities.add(localCity);
		}
		return cities;

	}

	public static List<String> StateWiseCityList() {
		List<String> state = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			String State = "State = " + i;
			state.add(State);
		}
		return state;

	}

	private static Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>> CityWiseAreaData(
			List<String> cityWiseAreaList, Map<String, Map<String, Map<Date, List<WeatherData>>>> areaWiseLatLongData) {
		Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>> cityWiseAreaDataMap = new TreeMap<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>();
		for (String city : cityWiseAreaList) {
			cityWiseAreaDataMap.put(city, areaWiseLatLongData);
		}
		return cityWiseAreaDataMap;

	}

	private static Map<String, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>> StateDataCityWise(
			List<String> StateList, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>> map) {
		Map<String, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>> StateWiseCityDataMap = new TreeMap<String, Map<String, Map<String, Map<String, Map<Date, List<WeatherData>>>>>>();
		for (String state : StateList) {
			StateWiseCityDataMap.put(state, map);
		}
		return StateWiseCityDataMap;

	}

}
