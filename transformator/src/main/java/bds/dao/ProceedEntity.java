package bds.dao;


import javax.persistence.*;

@Entity
@Table(name="proceed_table")
public class ProceedEntity {

  @Id
  @Column(name="id")
  private long id;

  @Column(name="flight_icao_code")
  private String flightIcaoCode;

  @Column(name="flight_number")
  private String flightNumber;

  @Column(name="schd_dep_only_date_lt")
  private String schdDepOnlyDateLt;

  @Column(name="done")
  private String done;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFlightIcaoCode() {
    return this.flightIcaoCode;
  }

  public void setFlightIcaoCode(String flightIcaoCode) {
    this.flightIcaoCode = flightIcaoCode;
  }

  public String getFlightNumber() {
    return this.flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getSchdDepOnlyDateLt() {
    return this.schdDepOnlyDateLt;
  }

  public void setSchdDepOnlyDateLt(String schdDepOnlyDateLt) {
    this.schdDepOnlyDateLt = schdDepOnlyDateLt;
  }

  public String getDone() {
    return this.done;
  }

  public void setDone(String done) {
    this.done = done;
  }
}
