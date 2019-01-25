package br.selftron.impinj.bridge.dto;

import com.impinj.octane.GpsCoordinates;

public class GpsCoordinatesDTO {
	
	private double latitude;
	private double longitude;
	
	public GpsCoordinatesDTO() {
	}
	
	public GpsCoordinatesDTO(GpsCoordinates gpsCoordinates) {
		this.latitude = gpsCoordinates.getLatitude();
		this.longitude = gpsCoordinates.getLongitude();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
