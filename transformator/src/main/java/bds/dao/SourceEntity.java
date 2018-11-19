package bds.dao;


import javax.persistence.*;

@Entity
@Table(name="aenaflight_2017_01")
public class SourceEntity {

  @Id
  @Column(name="id")
  private long id;

  @Column(name="act_arr_date_time_lt")
  private String actArrDateTimeLt;

  @Column(name="aircraft_name_scheduled")
  private String aircraftNameScheduled;

  @Column(name="arr_apt_name_es")
  private String arrAptNameEs;

  @Column(name="arr_apt_code_iata")
  private String arrAptCodeIata;

  @Column(name="baggage_info")
  private String baggageInfo;

  @Column(name="carrier_airline_name_en")
  private String carrierAirlineNameEn;

  @Column(name="carrier_icao_code")
  private String carrierIcaoCode;

  @Column(name="carrier_number")
  private String carrierNumber;

  @Column(name="counter")
  private String counter;

  @Column(name="dep_apt_name_es")
  private String depAptNameEs;

  @Column(name="dep_apt_code_iata")
  private String depAptCodeIata;

  @Column(name="est_arr_date_time_lt")
  private String estArrDateTimeLt;

  @Column(name="est_dep_date_time_lt")
  private String estDepDateTimeLt;

  @Column(name="flight_airline_name_en")
  private String flightAirlineNameEn;

  @Column(name="flight_airline_name")
  private String flightAirlineName;

  @Column(name="flight_icao_code")
  private String flightIcaoCode;

  @Column(name="flight_number")
  private String flightNumber;

  @Column(name="flt_leg_seq_no")
  private String fltLegSeqNo;

  @Column(name="gate_info")
  private String gateInfo;

  @Column(name="lounge_info")
  private String loungeInfo;

  @Column(name="schd_arr_only_date_lt")
  private String schdArrOnlyDateLt;

  @Column(name="schd_arr_only_time_lt")
  private String schdArrOnlyTimeLt;

  @Column(name="source_data")
  private String sourceData;

  @Column(name="status_info")
  private String statusInfo;

  @Column(name="terminal_info")
  private String terminalInfo;

  @Column(name="arr_terminal_info")
  private String arrTerminalInfo;

  @Column(name="created_at")
  private long createdAt;

  @Column(name="act_dep_date_time_lt")
  private String actDepDateTimeLt;

  @Column(name="schd_dep_only_date_lt")
  private String schdDepOnlyDateLt;

  @Column(name="schd_dep_only_time_lt")
  private String schdDepOnlyTimeLt;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getActArrDateTimeLt() {
    return this.actArrDateTimeLt;
  }

  public void setActArrDateTimeLt(String actArrDateTimeLt) {
    this.actArrDateTimeLt = actArrDateTimeLt;
  }

  public String getAircraftNameScheduled() {
    return this.aircraftNameScheduled;
  }

  public void setAircraftNameScheduled(String aircraftNameScheduled) {
    this.aircraftNameScheduled = aircraftNameScheduled;
  }

  public String getArrAptNameEs() {
    return this.arrAptNameEs;
  }

  public void setArrAptNameEs(String arrAptNameEs) {
    this.arrAptNameEs = arrAptNameEs;
  }

  public String getArrAptCodeIata() {
    return this.arrAptCodeIata;
  }

  public void setArrAptCodeIata(String arrAptCodeIata) {
    this.arrAptCodeIata = arrAptCodeIata;
  }

  public String getBaggageInfo() {
    return this.baggageInfo;
  }

  public void setBaggageInfo(String baggageInfo) {
    this.baggageInfo = baggageInfo;
  }

  public String getCarrierAirlineNameEn() {
    return this.carrierAirlineNameEn;
  }

  public void setCarrierAirlineNameEn(String carrierAirlineNameEn) {
    this.carrierAirlineNameEn = carrierAirlineNameEn;
  }

  public String getCarrierIcaoCode() {
    return this.carrierIcaoCode;
  }

  public void setCarrierIcaoCode(String carrierIcaoCode) {
    this.carrierIcaoCode = carrierIcaoCode;
  }

  public String getCarrierNumber() {
    return this.carrierNumber;
  }

  public void setCarrierNumber(String carrierNumber) {
    this.carrierNumber = carrierNumber;
  }

  public String getCounter() {
    return this.counter;
  }

  public void setCounter(String counter) {
    this.counter = counter;
  }

  public String getDepAptNameEs() {
    return this.depAptNameEs;
  }

  public void setDepAptNameEs(String depAptNameEs) {
    this.depAptNameEs = depAptNameEs;
  }

  public String getDepAptCodeIata() {
    return this.depAptCodeIata;
  }

  public void setDepAptCodeIata(String depAptCodeIata) {
    this.depAptCodeIata = depAptCodeIata;
  }

  public String getEstArrDateTimeLt() {
    return this.estArrDateTimeLt;
  }

  public void setEstArrDateTimeLt(String estArrDateTimeLt) {
    this.estArrDateTimeLt = estArrDateTimeLt;
  }

  public String getEstDepDateTimeLt() {
    return this.estDepDateTimeLt;
  }

  public void setEstDepDateTimeLt(String estDepDateTimeLt) {
    this.estDepDateTimeLt = estDepDateTimeLt;
  }

  public String getFlightAirlineNameEn() {
    return this.flightAirlineNameEn;
  }

  public void setFlightAirlineNameEn(String flightAirlineNameEn) {
    this.flightAirlineNameEn = flightAirlineNameEn;
  }

  public String getFlightAirlineName() {
    return this.flightAirlineName;
  }

  public void setFlightAirlineName(String flightAirlineName) {
    this.flightAirlineName = flightAirlineName;
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

  public String getFltLegSeqNo() {
    return this.fltLegSeqNo;
  }

  public void setFltLegSeqNo(String fltLegSeqNo) {
    this.fltLegSeqNo = fltLegSeqNo;
  }

  public String getGateInfo() {
    return this.gateInfo;
  }

  public void setGateInfo(String gateInfo) {
    this.gateInfo = gateInfo;
  }

  public String getLoungeInfo() {
    return this.loungeInfo;
  }

  public void setLoungeInfo(String loungeInfo) {
    this.loungeInfo = loungeInfo;
  }

  public String getSchdArrOnlyDateLt() {
    return this.schdArrOnlyDateLt;
  }

  public void setSchdArrOnlyDateLt(String schdArrOnlyDateLt) {
    this.schdArrOnlyDateLt = schdArrOnlyDateLt;
  }

  public String getSchdArrOnlyTimeLt() {
    return this.schdArrOnlyTimeLt;
  }

  public void setSchdArrOnlyTimeLt(String schdArrOnlyTimeLt) {
    this.schdArrOnlyTimeLt = schdArrOnlyTimeLt;
  }

  public String getSourceData() {
    return this.sourceData;
  }

  public void setSourceData(String sourceData) {
    this.sourceData = sourceData;
  }

  public String getStatusInfo() {
    return this.statusInfo;
  }

  public void setStatusInfo(String statusInfo) {
    this.statusInfo = statusInfo;
  }

  public String getTerminalInfo() {
    return this.terminalInfo;
  }

  public void setTerminalInfo(String terminalInfo) {
    this.terminalInfo = terminalInfo;
  }

  public String getArrTerminalInfo() {
    return this.arrTerminalInfo;
  }

  public void setArrTerminalInfo(String arrTerminalInfo) {
    this.arrTerminalInfo = arrTerminalInfo;
  }

  public long getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public String getActDepDateTimeLt() {
    return this.actDepDateTimeLt;
  }

  public void setActDepDateTimeLt(String actDepDateTimeLt) {
    this.actDepDateTimeLt = actDepDateTimeLt;
  }

  public String getSchdDepOnlyDateLt() {
    return this.schdDepOnlyDateLt;
  }

  public void setSchdDepOnlyDateLt(String schdDepOnlyDateLt) {
    this.schdDepOnlyDateLt = schdDepOnlyDateLt;
  }

  public String getSchdDepOnlyTimeLt() {
    return this.schdDepOnlyTimeLt;
  }

  public void setSchdDepOnlyTimeLt(String schdDepOnlyTimeLt) {
    this.schdDepOnlyTimeLt = schdDepOnlyTimeLt;
  }
}
