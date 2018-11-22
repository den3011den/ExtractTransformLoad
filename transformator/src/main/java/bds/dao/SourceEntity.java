package bds.dao;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

// таблица - источник данных
@Entity
@Table(name = "aenaflight_2017_01")
public class SourceEntity {

    // уникальный id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    // actual arrival timestamp
    @Column(name = "act_arr_date_time_lt")
    private String actArrDateTimeLt;

    // scheduled aircraft name
    @Column(name = "aircraft_name_scheduled")
    private String aircraftNameScheduled;

    // Arrival airport name in Spanish
    @Column(name = "arr_apt_name_es")
    private String arrAptNameEs;

    // IATA/ICAO code of arrival airport
    @Column(name = "arr_apt_code_iata")
    private String arrAptCodeIata;

    // Baggage information of flight
    @Column(name = "baggage_info")
    private String baggageInfo;

    // Carrier airline name English
    @Column(name = "carrier_airline_name_en")
    private String carrierAirlineNameEn;

    // Carrier IATA/ICAO code
    @Column(name = "carrier_icao_code")
    private String carrierIcaoCode;

    // Carrier number
    @Column(name = "carrier_number")
    private String carrierNumber;

    // Registration counter
    @Column(name = "counter")
    private String counter;

    // Departure airport name Spanish
    @Column(name = "dep_apt_name_es")
    private String depAptNameEs;

    // IATA/ICAO code of departure airport
    @Column(name = "dep_apt_code_iata")
    private String depAptCodeIata;

    // estimated arrival timestamp
    @Column(name = "est_arr_date_time_lt")
    private String estArrDateTimeLt;

    // estimated departure timestamp
    @Column(name = "est_dep_date_time_lt")
    private String estDepDateTimeLt;

    // Flight airline name English
    @Column(name = "flight_airline_name_en")
    private String flightAirlineNameEn;

    // Flight Airline name
    @Column(name = "flight_airline_name")
    private String flightAirlineName;

    // IATA/ICAO flight airline code
    @Column(name = "flight_icao_code")
    private String flightIcaoCode;

    // flight number
    @Column(name = "flight_number")
    private String flightNumber;

    // flight leg sequence id
    @Column(name = "flt_leg_seq_no")
    private String fltLegSeqNo;

    // gate information
    @Column(name = "gate_info")
    private String gateInfo;

    // gate information
    @Column(name = "lounge_info")
    private String loungeInfo;

    // scheduled arrival date
    @Column(name = "schd_arr_only_date_lt")
    private String schdArrOnlyDateLt;

    // scheduled arrival time
    @Column(name = "schd_arr_only_time_lt")
    private String schdArrOnlyTimeLt;

    // source of data
    @Column(name = "source_data")
    private String sourceData;

    // flight status
    @Column(name = "status_info")
    private String statusInfo;

    // terminal information
    @Column(name = "terminal_info")
    private String terminalInfo;

    // arrival terminal information
    @Column(name = "arr_terminal_info")
    private String arrTerminalInfo;

    // unix timestamp when record was created
    @Column(name = "created_at")
    private long createdAt;

    // actual departure timestamp
    @Column(name = "act_dep_date_time_lt")
    private String actDepDateTimeLt;

    // actual departure timestamp
    @Column(name = "schd_dep_only_date_lt")
    private String schdDepOnlyDateLt;

    // scheduled departure time
    @Column(name = "schd_dep_only_time_lt")
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
