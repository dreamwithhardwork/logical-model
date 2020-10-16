package org.models.core.location;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
  private Coordinates coordinates;
  private LocationDetails locationDetails;
  private Boolean primary;

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public LocationDetails getLocationDetails() {
    return locationDetails;
  }

  public void setLocationDetails(LocationDetails locationDetails) {
    this.locationDetails = locationDetails;
  }

  public Boolean getPrimary() {
    return primary;
  }

  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }
}
