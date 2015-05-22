/**
 * LatLng.java
 * Created at 2014年8月11日
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.bean;

/**
 * <p>
 * ClassName: LatLng
 * </p>
 * <p>
 * Description: TODO
 * </p>
 * <p>
 * Author: Fanhuawei
 * </p>
 * <p>
 * Date: 2014年8月11日
 * </p>
 */
public class LatLng {
    private double lat;
    private double lng;

    public LatLng(double lat, double lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    @Override
    public String toString() {
        return lat + ";" + lng;
    }

}
