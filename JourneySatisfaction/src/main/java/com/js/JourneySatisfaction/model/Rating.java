package com.js.JourneySatisfaction.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rating {

    private int seatQuality;
    private int safeDriving;
    private int amenities;
    private int restRoomStops;
    private int luggageSafety;

    // Getters and Setters
    public int getSeatQuality() {
        return seatQuality;
    }

    public void setSeatQuality(int seatQuality) {
        this.seatQuality = seatQuality;
    }

    public int getSafeDriving() {
        return safeDriving;
    }

    public void setSafeDriving(int safeDriving) {
        this.safeDriving = safeDriving;
    }

    public int getAmenities() {
        return amenities;
    }

    public void setAmenities(int amenities) {
        this.amenities = amenities;
    }

    public int getRestRoomStops() {
        return restRoomStops;
    }

    public void setRestRoomStops(int restRoomStops) {
        this.restRoomStops = restRoomStops;
    }

    public int getLuggageSafety() {
        return luggageSafety;
    }

    public void setLuggageSafety(int luggageSafety) {
        this.luggageSafety = luggageSafety;
    }

	@Override
	public String toString() {
		return "Rating [seatQuality=" + seatQuality + ", safeDriving=" + safeDriving + ", amenities=" + amenities
				+ ", restRoomStops=" + restRoomStops + ", luggageSafety=" + luggageSafety + "]";
	}
    
    
}
