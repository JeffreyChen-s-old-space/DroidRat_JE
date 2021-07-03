package com.je_chen.droidrat_je.rat.modules.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationGeocode {
    private final Geocoder geocoder;

    public LocationGeocode(Context context) {
        Locale locale = Locale.getDefault();
        this.geocoder = new Geocoder(context, locale);
    }

    private List<Address> getAddressList(double latitude, double longitude, int dataCount) throws IOException {
        return this.geocoder.getFromLocation(latitude, longitude, dataCount);
    }

    public String getAddressLine(double latitude, double longitude, int dataCount) throws IOException {
        StringBuilder addressString = new StringBuilder();
        List<Address> addressList = getAddressList(latitude, longitude, dataCount);
        if (addressList == null || addressList.size() == 0)
            return "can't get info";
        Address address = addressList.get(0);
        for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
            addressString.append(address.getAddressLine(i)).append("\n");
        return addressString.toString();
    }

    public Address getAddress(double latitude, double longitude, int dataCount) throws IOException {
        List<Address> addressList = getAddressList(latitude, longitude, dataCount);
        if (addressList == null || addressList.size() == 0)
            return null;
        return addressList.get(0);
    }

}
