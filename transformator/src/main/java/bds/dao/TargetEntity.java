package bds.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="aenaflight_source")
public class TargetEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  private long id;

  public TargetEntity()  {};

  public TargetEntity(List<SourceEntity> sourceList) throws ParseException {

      String act_arr_date_time_lt = "";     //last
      String arr_apt_code_iata = "";        //last
      String aircraft_name_scheduled = "";  //last
      String arr_apt_name_es = "";          //last
      String baggage_info = "";         //LIFO
      String carrier_airline_name_en = ""; //last
      String carrier_icao_code = "";      //last
      String carrier_number = "";         //last
      String counter = "";                //LIFO
      String dep_apt_name_es = "";         //last
      String dep_apt_code_iata = "";        //last
      String est_arr_date_time_lt = "";      //last
      String est_dep_date_time_lt = "";      // last
      String flight_airline_name_en = "";    // last
      String flight_airline_name = "";      // last
      String flight_icao_code = "";      // last
      String flight_number = "";      // last
      String flt_leg_seq_no = "";      // last
      String gate_info = "";      // LIFO
      String lounge_info = "";      // LIFO
      String schd_arr_only_date_lt = "";      // last
      String schd_arr_only_time_lt = "";      // last
      String source_data = "";      // last
      String status_info = "";      // last
      String terminal_info = "";      // LIFO
      String arr_terminal_info = "";      // LIFO
      String act_dep_date_time_lt = "";      // last
      String schd_dep_only_date_lt = "";      // last
      String schd_dep_only_time_lt = "";      // last

      for (SourceEntity sourceEntity : sourceList) {

          if (act_arr_date_time_lt.isEmpty())
              if (sourceEntity.getActArrDateTimeLt() != null)
                  act_arr_date_time_lt = sourceEntity.getActArrDateTimeLt();

          if (arr_apt_code_iata.isEmpty()) {
              if (sourceEntity.getArrAptCodeIata() != null)
                  arr_apt_code_iata = sourceEntity.getArrAptCodeIata();
          }

          if (aircraft_name_scheduled.isEmpty()) {
              if (sourceEntity.getAircraftNameScheduled() != null)
                  aircraft_name_scheduled = sourceEntity.getAircraftNameScheduled();
          }

          if (arr_apt_name_es.isEmpty()) {
              if (sourceEntity.getArrAptNameEs() != null)
                  arr_apt_name_es = sourceEntity.getArrAptNameEs();
          }

          if (baggage_info.isEmpty()) {
              if (sourceEntity.getBaggageInfo() != null)
                  baggage_info = sourceEntity.getBaggageInfo();
          } else {
              if (sourceEntity.getBaggageInfo() != null)
                  if (!baggage_info.contains(sourceEntity.getBaggageInfo()))
                      baggage_info = baggage_info + ", " + sourceEntity.getBaggageInfo();
          }

          if (carrier_airline_name_en.isEmpty()) {
              if (sourceEntity.getCarrierAirlineNameEn() != null)
                  carrier_airline_name_en = sourceEntity.getCarrierAirlineNameEn();
          }

          if (carrier_icao_code.isEmpty()) {
              if (sourceEntity.getCarrierIcaoCode() != null)
                  carrier_icao_code = sourceEntity.getCarrierIcaoCode();
          }

          if (carrier_number.isEmpty()) {
              if (sourceEntity.getCarrierNumber() != null)
                  carrier_number = sourceEntity.getCarrierNumber();
          }

          if (counter.isEmpty()) {
              if (sourceEntity.getCounter() != null)
                  counter = sourceEntity.getCounter();
          } else {
              if (sourceEntity.getCounter() != null)
                  if (!counter.contains(sourceEntity.getCounter()))
                      counter = counter + ", " + sourceEntity.getCounter();
          }

          if (dep_apt_name_es.isEmpty()) {
              if (sourceEntity.getDepAptNameEs() != null)
                  dep_apt_name_es = sourceEntity.getDepAptNameEs();
          }

          if (dep_apt_code_iata.isEmpty()) {
              if (sourceEntity.getDepAptCodeIata() != null)
                  dep_apt_code_iata = sourceEntity.getDepAptCodeIata();
          }

          if (est_arr_date_time_lt.isEmpty()) {
              if (sourceEntity.getEstArrDateTimeLt() != null)
                  est_arr_date_time_lt = sourceEntity.getEstArrDateTimeLt();
          }

          if (est_dep_date_time_lt.isEmpty()) {
              if (sourceEntity.getEstDepDateTimeLt() != null)
                  est_dep_date_time_lt = sourceEntity.getEstDepDateTimeLt();
          }

          if (flight_airline_name_en.isEmpty()) {
              if (sourceEntity.getFlightAirlineNameEn() != null)
                  flight_airline_name_en = sourceEntity.getFlightAirlineNameEn();
          }

          if (flight_airline_name.isEmpty()) {
              if (sourceEntity.getFlightAirlineName() != null)
                  flight_airline_name = sourceEntity.getFlightAirlineName();
          }

          if (flight_icao_code.isEmpty()) {
              if (sourceEntity.getFlightIcaoCode() != null)
                  flight_icao_code = sourceEntity.getFlightIcaoCode();
          }

          if (flight_number.isEmpty()) {
              if (sourceEntity.getFlightNumber() != null)
                  flight_number = sourceEntity.getFlightNumber();
          }

          if (flt_leg_seq_no.isEmpty()) {
              if (sourceEntity.getFltLegSeqNo() != null)
                  flt_leg_seq_no = sourceEntity.getFltLegSeqNo();
          }

          if (gate_info.isEmpty()) {
              if (sourceEntity.getGateInfo() != null)
                  gate_info = sourceEntity.getGateInfo();
          } else {
              if (sourceEntity.getGateInfo() != null)
                  if (!gate_info.contains(sourceEntity.getGateInfo()))
                      gate_info = gate_info + ", " + sourceEntity.getGateInfo();
          }

          if (lounge_info.isEmpty()) {
              if (sourceEntity.getLoungeInfo() != null)
                  lounge_info = sourceEntity.getLoungeInfo();
          } else {
              if (sourceEntity.getLoungeInfo() != null)
                  if (!lounge_info.contains(sourceEntity.getLoungeInfo()))
                      lounge_info = lounge_info + ", " + sourceEntity.getLoungeInfo();
          }

          if (schd_arr_only_date_lt.isEmpty()) {
              if (sourceEntity.getSchdArrOnlyDateLt() != null)
                  schd_arr_only_date_lt = sourceEntity.getSchdArrOnlyDateLt();
          }

          if (schd_arr_only_time_lt.isEmpty()) {
              if (sourceEntity.getSchdArrOnlyTimeLt() != null)
                  schd_arr_only_time_lt = sourceEntity.getSchdArrOnlyTimeLt();
          }

          if (source_data.isEmpty()) {
              if (sourceEntity.getSourceData() != null)
                  source_data = sourceEntity.getSourceData();
          }

          if (status_info.isEmpty()) {
              if (sourceEntity.getStatusInfo() != null)
                  status_info = sourceEntity.getStatusInfo();
          }

          if (terminal_info.isEmpty()) {
              if (sourceEntity.getTerminalInfo() != null)
                  terminal_info = sourceEntity.getTerminalInfo();
          } else {
              if (sourceEntity.getTerminalInfo() != null)
                  if (!terminal_info.contains(sourceEntity.getTerminalInfo()))
                      terminal_info = terminal_info + ", " + sourceEntity.getTerminalInfo();
          }

          if (arr_terminal_info.isEmpty()) {
              if (sourceEntity.getArrTerminalInfo() != null)
                  arr_terminal_info = sourceEntity.getArrTerminalInfo();
          } else {
              if (sourceEntity.getArrTerminalInfo() != null)
                  if (!arr_terminal_info.contains(sourceEntity.getArrTerminalInfo()))
                      arr_terminal_info = arr_terminal_info + ", " + sourceEntity.getArrTerminalInfo();
          }

          if (act_dep_date_time_lt.isEmpty()) {
              if (sourceEntity.getActDepDateTimeLt() != null)
                  act_dep_date_time_lt = sourceEntity.getActDepDateTimeLt();
          }

          if (schd_dep_only_date_lt.isEmpty()) {
              if (sourceEntity.getSchdDepOnlyDateLt() != null)
                  schd_dep_only_date_lt = sourceEntity.getSchdDepOnlyDateLt();
          }

          if (schd_dep_only_time_lt.isEmpty()) {
              if (sourceEntity.getSchdDepOnlyTimeLt() != null)
                  schd_dep_only_time_lt = sourceEntity.getSchdDepOnlyTimeLt();
          }

      }

      this.adep = dep_apt_code_iata;
      this.ades = arr_apt_code_iata;
      this.flightCode = flight_icao_code;
      this.flightNumber = flight_number;
      this.carrierCode = carrier_icao_code;
      this.carrierNumber = carrier_number;
      this.statusInfo = status_info;

      Date date = new Date();

      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");

      if (!schd_dep_only_date_lt.isEmpty() && !schd_dep_only_time_lt.isEmpty()) {
          date = formatter.parse(schd_dep_only_date_lt + " " + schd_dep_only_time_lt);
          this.schdDepLt = Timestamp.from(date.toInstant());
      }

      if (!schd_arr_only_date_lt.isEmpty() && !schd_arr_only_time_lt.isEmpty()) {
          date = formatter.parse(schd_arr_only_date_lt + " " + schd_arr_only_time_lt);
          this.schdArrLt = Timestamp.from(date.toInstant());
      }



      if (!est_dep_date_time_lt.isEmpty()) {
          date = formatter.parse(est_dep_date_time_lt);
          this.estDepLt = Timestamp.from(date.toInstant());
      }

      if (!est_dep_date_time_lt.isEmpty()) {
          date = formatter.parse(est_dep_date_time_lt);
          this.estDepLt = Timestamp.from(date.toInstant());
      }

      if (!est_arr_date_time_lt.isEmpty()) {
          date = formatter.parse(est_arr_date_time_lt);
          this.estArrLt = Timestamp.from(date.toInstant());
      }

      if (!act_dep_date_time_lt.isEmpty()) {
          date = formatter.parse(act_dep_date_time_lt);
          this.actDepLt = Timestamp.from(date.toInstant());
      }

      if (!act_arr_date_time_lt.isEmpty()) {
          date = formatter.parse(act_arr_date_time_lt);
          this.actArrLt = Timestamp.from(date.toInstant());
      }

      this.fltLegSeqNo = Long.valueOf(flt_leg_seq_no);
      this.aircraftNameScheduled = aircraft_name_scheduled;
      this.baggageInfo = baggage_info;
      this.counter = counter;
      this.gateInfo = gate_info;
      this.loungeInfo = lounge_info;
      this.terminalInfo = terminal_info;
      this.arrTerminalInfo = arr_terminal_info;
      this.sourceData = source_data;
      this.createdAt = Timestamp.from((new Date().toInstant()));


      if(this.schdDepLt==null) {
          date = formatter.parse("01/01/70 00:00");
          this.schdDepLt = Timestamp.from(date.toInstant());
      }

      if(this.schdArrLt==null) {
          date = formatter.parse("01/01/70 00:00");
          this.schdArrLt = Timestamp.from(date.toInstant());
      }

      if (this.adep == null) {
          this.adep = "00000000";
      }

      if (this.adep == null) {
          this.ades = "00000000";
      }

      if (this.flightCode == null) {
          this.flightCode = "00000000";
      }

      if (this.flightNumber == null) {
          this.flightNumber = "00000000";
      }

      if (this.statusInfo == null) {
          this.statusInfo = "No data";
      }






  }


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
