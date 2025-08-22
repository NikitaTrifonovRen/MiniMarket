package ed.core.minimarket.dto;

import jakarta.persistence.*;


public class ImageDto {

    private Long id;

    private String format;

    private String refToFile;

    private Long size;

    private String offerId;

    public ImageDto() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRefToFile() {
        return refToFile;
    }

    public void setRefToFile(String refToFile) {
        this.refToFile = refToFile;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
