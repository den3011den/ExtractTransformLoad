package bds.dao;


import javax.persistence.*;

@Entity
@Table(name="aenaflight_source")
public class TargetEntity {


  @Id
  @Column(name="id")
  private long id;

  @Column(name="adep")
  private String adep;

  @Column(name="ades")
  private String ades;

  @Column(name="flight_code")
  private String flightCode;

  @Column(name="flight_number")
  private String flightNumber;

  @Column(name="carrier_code")
  private String carrierCode;

  @Column(name="carrier_number")
  private String carrierNumber;

  @Column(name="status_info")
  private String statusInfo;

  @Column(name="schd_dep_lt")
  private java.sql.Timestamp schdDepLt;

  @Column(name="schd_arr_lt")
  private java.sql.Timestamp schdArrLt;

  @Column(name="est_dep_lt")
  private java.sql.Timestamp estDepLt;

  @Column(name="est_arr_lt")
  private java.sql.Timestamp estArrLt;

  @Column(name="act_dep_lt")
  private java.sql.Timestamp actDepLt;

  @Column(name="act_arr_lt")
  private java.sql.Timestamp actArrLt;

  @Column(name="flt_leg_seq_no")
  private long fltLegSeqNo;

  @Column(name="aircraft_name_scheduled")
  private String aircraftNameScheduled;

  @Column(name="baggage_info")
  private String baggageInfo;

  @Column(name="counter")
  private String counter;

  @Column(name="gate_info")
  private String gateInfo;

  @Column(name="lounge_info")
  private String loungeInfo;

  @Column(name="terminal_info")
  private String terminalInfo;

  @Column(name="arr_terminal_info")
  private String arrTerminalInfo;

  @Column(name="source_data")
  private String sourceData;

  @Column(name="created_at")
  private java.sql.Timestamp createdAt;


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAdep() {
    return this.adep;
  }

  public void setAdep(String adep) {
    this.adep = adep;
  }

  public String getAdes() {
    return this.ades;
  }

  public void setAdes(String ades) {
    this.ades = ades;
  }

  public String getFlightCode() {
    return this.flightCode;
  }

  public void setFlightCode(String flightCode) {
    this.flightCode = flightCode;
  }

  public String getFlightNumber() {
    return this.flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getCarrierCode() {
    return this.carrierCode;
  }

  public void setCarrierCode(String carrierCode) {
    this.carrierCode = carrierCode;
  }

  public String getCarrierNumber() {
    return this.carrierNumber;
  }

  public void setCarrierNumber(String carrierNumber) {
    this.carrierNumber = carrierNumber;
  }

  public String getStatusInfo() {
    return this.statusInfo;
  }

  public void setStatusInfo(String statusInfo) {
    this.statusInfo = statusInfo;
  }

  public java.sql.Timestamp getSchdDepLt() {
    return this.schdDepLt;
  }

  public void setSchdDepLt(java.sql.Timestamp schdDepLt) {
    this.schdDepLt = schdDepLt;
  }

  public java.sql.Timestamp getSchdArrLt() {
    return this.schdArrLt;
  }

  public void setSchdArrLt(java.sql.Timestamp schdArrLt) {
    this.schdArrLt = schdArrLt;
  }

  public java.sql.Timestamp getEstDepLt() {
    return this.estDepLt;
  }

  public void setEstDepLt(java.sql.Timestamp estDepLt) {
    this.estDepLt = estDepLt;
  }

  public java.sql.Timestamp getEstArrLt() {
    return this.estArrLt;
  }

  public void setEstArrLt(java.sql.Timestamp estArrLt) {
    this.estArrLt = estArrLt;
  }

  public java.sql.Timestamp getActDepLt() {
    return this.actDepLt;
  }

  public void setActDepLt(java.sql.Timestamp actDepLt) {
    this.actDepLt = actDepLt;
  }

  public java.sql.Timestamp getActArrLt() {
    return this.actArrLt;
  }

  public void setActArrLt(java.sql.Timestamp actArrLt) {
    this.actArrLt = actArrLt;
  }

  public long getFltLegSeqNo() {
    return this.fltLegSeqNo;
  }

  public void setFltLegSeqNo(long fltLegSeqNo) {
    this.fltLegSeqNo = fltLegSeqNo;
  }

  public String getAircraftNameScheduled() {
    return this.aircraftNameScheduled;
  }

  public void setAircraftNameScheduled(String aircraftNameScheduled) {
    this.aircraftNameScheduled = aircraftNameScheduled;
  }

  public String getBaggageInfo() {
    return this.baggageInfo;
  }

  public void setBaggageInfo(String baggageInfo) {
    this.baggageInfo = baggageInfo;
  }

  public String getCounter() {
    return this.counter;
  }

  public void setCounter(String counter) {
    this.counter = counter;
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

  public String getSourceData() {
    return this.sourceData;
  }

  public void setSourceData(String sourceData) {
    this.sourceData = sourceData;
  }

  public java.sql.Timestamp getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }
}
