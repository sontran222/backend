package com.DeviceManager.Device.dto.smallDTO;

public class GetCountDeviceDTO {
    private String area;
    private int tablet;
    private int barcode;

    public GetCountDeviceDTO(String area, int tablet, int barcode) {
        this.area = area;
        this.tablet = tablet;
        this.barcode = barcode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTablet() {
        return tablet;
    }

    public void setTablet(int tablet) {
        this.tablet = tablet;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
