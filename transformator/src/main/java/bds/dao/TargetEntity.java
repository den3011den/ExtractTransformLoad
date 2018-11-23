package bds.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Таблица - результат
@Entity
@Table(name = "aenaflight_source")
public class TargetEntity {

    // уникальный id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    public TargetEntity() {
    }

    // в качестве параметра - список записей, которые в результирующей таблице будут свёрнуты в одну запись
    public TargetEntity(List<SourceEntity> sourceList) throws ParseException {

        String act_arr_date_time_lt = "";               //last
        String arr_apt_code_iata = "";                  //last
        String aircraft_name_scheduled = "";            //last
        String arr_apt_name_es = "";                    //last
        StringBuilder baggage_info = new StringBuilder();         //LIFO
        String carrier_airline_name_en = "";            //last
        String carrier_icao_code = "";                  //last
        String carrier_number = "";                     //last
        StringBuilder counter = new StringBuilder();               //LIFO
        String dep_apt_name_es = "";                    //last
        String dep_apt_code_iata = "";                  //last
        String est_arr_date_time_lt = "";               //last
        String est_dep_date_time_lt = "";               // last
        String flight_airline_name_en = "";             // last
        String flight_airline_name = "";                // last
        String flight_icao_code = "";                   // last
        String flight_number = "";                      // last
        String flt_leg_seq_no = "";                     // last
        StringBuilder gate_info = new StringBuilder();            // LIFO
        StringBuilder lounge_info = new StringBuilder();          // LIFO
        String schd_arr_only_date_lt = "";              // last
        String schd_arr_only_time_lt = "";              // last
        String source_data = "";                        // last
        String status_info = "";                        // last
        StringBuilder terminal_info = new StringBuilder();         // LIFO
        StringBuilder arr_terminal_info = new StringBuilder();     // LIFO
        String act_dep_date_time_lt = "";               // last
        String schd_dep_only_date_lt = "";              // last
        String schd_dep_only_time_lt = "";              // last

        // сбор данных полей результирующей записи таблица на основе записей исходной таблицы
        for (SourceEntity sourceEntity : sourceList) {

            if (act_arr_date_time_lt.isEmpty())
                if (sourceEntity.getActArrDateTimeLt() != null && (!sourceEntity.getActArrDateTimeLt().equals("-")))
                    act_arr_date_time_lt = sourceEntity.getActArrDateTimeLt();

            if (arr_apt_code_iata.isEmpty()) {
                if (sourceEntity.getArrAptCodeIata() != null && (!sourceEntity.getArrAptCodeIata().equals("-")))
                    arr_apt_code_iata = sourceEntity.getArrAptCodeIata();
            }

            if (aircraft_name_scheduled.isEmpty()) {
                if (sourceEntity.getAircraftNameScheduled() != null && (!sourceEntity.getAircraftNameScheduled().equals("-")))
                    aircraft_name_scheduled = sourceEntity.getAircraftNameScheduled();
            }

            if (arr_apt_name_es.isEmpty()) {
                if (sourceEntity.getArrAptNameEs() != null && (!sourceEntity.getArrAptNameEs().equals("-")))
                    arr_apt_name_es = sourceEntity.getArrAptNameEs();
            }

            if (baggage_info.toString().isEmpty()) {
                if (sourceEntity.getBaggageInfo() != null && (!sourceEntity.getBaggageInfo().equals("-")))
                    baggage_info.append(sourceEntity.getBaggageInfo());
            } else {
                if (sourceEntity.getBaggageInfo() != null && (!sourceEntity.getBaggageInfo().equals("-")))
                    if (!baggage_info.toString().contains(sourceEntity.getBaggageInfo()))
                        baggage_info.append(", ").append(sourceEntity.getBaggageInfo());
            }

            if (carrier_airline_name_en.isEmpty()) {
                if (sourceEntity.getCarrierAirlineNameEn() != null && (!sourceEntity.getCarrierAirlineNameEn().equals("-")))
                    carrier_airline_name_en = sourceEntity.getCarrierAirlineNameEn();
            }

            if (carrier_icao_code.isEmpty()) {
                if (sourceEntity.getCarrierIcaoCode() != null && (!sourceEntity.getCarrierIcaoCode().equals("-")))
                    carrier_icao_code = sourceEntity.getCarrierIcaoCode();
            }

            if (carrier_number.isEmpty()) {
                if (sourceEntity.getCarrierNumber() != null && (!sourceEntity.getCarrierNumber().equals("-")))
                    carrier_number = sourceEntity.getCarrierNumber();
            }

            if (counter.toString().isEmpty()) {
                if ((sourceEntity.getCounter() != null) && (!sourceEntity.getCounter().equals("-")))
                    counter.append(sourceEntity.getCounter());
            } else {
                if ((sourceEntity.getCounter() != null) && (!sourceEntity.getCounter().equals("-")))
                    if (!counter.toString().contains(sourceEntity.getCounter()))
                        counter.append(", ").append(sourceEntity.getCounter());
            }

            if (dep_apt_name_es.isEmpty()) {
                if ((sourceEntity.getDepAptNameEs() != null) && (!sourceEntity.getDepAptNameEs().equals("-")))
                    dep_apt_name_es = sourceEntity.getDepAptNameEs();
            }

            if (dep_apt_code_iata.isEmpty()) {
                if (sourceEntity.getDepAptCodeIata() != null && (!sourceEntity.getDepAptCodeIata().equals("-")))
                    dep_apt_code_iata = sourceEntity.getDepAptCodeIata();
            }

            if (est_arr_date_time_lt.isEmpty()) {
                if (sourceEntity.getEstArrDateTimeLt() != null && (!sourceEntity.getEstArrDateTimeLt().equals("-")))
                    est_arr_date_time_lt = sourceEntity.getEstArrDateTimeLt();
            }

            if (est_dep_date_time_lt.isEmpty()) {
                if (sourceEntity.getEstDepDateTimeLt() != null && (!sourceEntity.getEstDepDateTimeLt().equals("-")))
                    est_dep_date_time_lt = sourceEntity.getEstDepDateTimeLt();
            }

            if (flight_airline_name_en.isEmpty()) {
                if (sourceEntity.getFlightAirlineNameEn() != null && (!sourceEntity.getFlightAirlineNameEn().equals("-")))
                    flight_airline_name_en = sourceEntity.getFlightAirlineNameEn();
            }

            if (flight_airline_name.isEmpty()) {
                if (sourceEntity.getFlightAirlineName() != null && (!sourceEntity.getFlightAirlineName().equals("-")))
                    flight_airline_name = sourceEntity.getFlightAirlineName();
            }

            if (flight_icao_code.isEmpty()) {
                if (sourceEntity.getFlightIcaoCode() != null && (!sourceEntity.getFlightIcaoCode().equals("-")))
                    flight_icao_code = sourceEntity.getFlightIcaoCode();
            }

            if (flight_number.isEmpty()) {
                if (sourceEntity.getFlightNumber() != null && (!sourceEntity.getFlightNumber().equals("-")))
                    flight_number = sourceEntity.getFlightNumber();
            }

            if (flt_leg_seq_no.isEmpty()) {
                if (sourceEntity.getFltLegSeqNo() != null && (!sourceEntity.getFltLegSeqNo().equals("-")))
                    flt_leg_seq_no = sourceEntity.getFltLegSeqNo();
            }

            if (gate_info.toString().isEmpty()) {
                if (sourceEntity.getGateInfo() != null && (!sourceEntity.getGateInfo().equals("-")))
                    gate_info.append(sourceEntity.getGateInfo());
            } else {
                if (sourceEntity.getGateInfo() != null && (!sourceEntity.getGateInfo().equals("-")))
                    if (!gate_info.toString().contains(sourceEntity.getGateInfo()))
                        gate_info.append(", ").append(sourceEntity.getGateInfo());
            }

            if (lounge_info.toString().isEmpty()) {
                if (sourceEntity.getLoungeInfo() != null && (!sourceEntity.getLoungeInfo().equals("-")))
                    lounge_info.append(sourceEntity.getLoungeInfo());
            } else {
                if (sourceEntity.getLoungeInfo() != null && (!sourceEntity.getLoungeInfo().equals("-")))
                    if (!lounge_info.toString().contains(sourceEntity.getLoungeInfo()))
                        lounge_info.append(", ").append(sourceEntity.getLoungeInfo());
            }

            if (schd_arr_only_date_lt.isEmpty()) {
                if (sourceEntity.getSchdArrOnlyDateLt() != null && (!sourceEntity.getSchdArrOnlyDateLt().equals("-")))
                    schd_arr_only_date_lt = sourceEntity.getSchdArrOnlyDateLt();
            }

            if (schd_arr_only_time_lt.isEmpty()) {
                if (sourceEntity.getSchdArrOnlyTimeLt() != null && (!sourceEntity.getSchdArrOnlyTimeLt().equals("-")))
                    schd_arr_only_time_lt = sourceEntity.getSchdArrOnlyTimeLt();
            }

            if (source_data.isEmpty()) {
                if (sourceEntity.getSourceData() != null && (!sourceEntity.getSourceData().equals("-")))
                    source_data = sourceEntity.getSourceData();
            }

            if (status_info.isEmpty()) {
                if (sourceEntity.getStatusInfo() != null && (!sourceEntity.getStatusInfo().equals("-")))
                    status_info = sourceEntity.getStatusInfo();
            }

            if (terminal_info.toString().isEmpty()) {
                if (sourceEntity.getTerminalInfo() != null && (!sourceEntity.getTerminalInfo().equals("-")))
                    terminal_info.append(sourceEntity.getTerminalInfo());
            } else {
                if (sourceEntity.getTerminalInfo() != null && (!sourceEntity.getTerminalInfo().equals("-")))
                    if (!terminal_info.toString().contains(sourceEntity.getTerminalInfo()))
                        terminal_info.append(", ").append(sourceEntity.getTerminalInfo());
            }

            if (arr_terminal_info.toString().isEmpty()) {
                if (sourceEntity.getArrTerminalInfo() != null && (!sourceEntity.getArrTerminalInfo().equals("-")))
                    arr_terminal_info.append(sourceEntity.getArrTerminalInfo());
            } else {
                if (sourceEntity.getArrTerminalInfo() != null && (!sourceEntity.getArrTerminalInfo().equals("-")))
                    if (!arr_terminal_info.toString().contains(sourceEntity.getArrTerminalInfo()))
                        arr_terminal_info.append(", ").append(sourceEntity.getArrTerminalInfo());
            }

            if (act_dep_date_time_lt.isEmpty()) {
                if (sourceEntity.getActDepDateTimeLt() != null && (!sourceEntity.getActDepDateTimeLt().equals("-")))
                    act_dep_date_time_lt = sourceEntity.getActDepDateTimeLt();
            }

            if (schd_dep_only_date_lt.isEmpty()) {
                if (sourceEntity.getSchdDepOnlyDateLt() != null && (!sourceEntity.getSchdDepOnlyDateLt().equals("-")))
                    schd_dep_only_date_lt = sourceEntity.getSchdDepOnlyDateLt();
            }

            if (schd_dep_only_time_lt.isEmpty()) {
                if (sourceEntity.getSchdDepOnlyTimeLt() != null && (!sourceEntity.getSchdDepOnlyTimeLt().equals("-")))
                    schd_dep_only_time_lt = sourceEntity.getSchdDepOnlyTimeLt();
            }

        }

        // заполнение данных записи выходной таблицы
        this.adep = dep_apt_code_iata;
        this.ades = arr_apt_code_iata;
        this.flightCode = flight_icao_code;
        this.flightNumber = flight_number;
        this.carrierCode = carrier_icao_code;
        this.carrierNumber = carrier_number;
        this.statusInfo = status_info;

        Date date;

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
        this.baggageInfo = baggage_info.toString();
        this.counter = counter.toString();
        this.gateInfo = gate_info.toString();
        this.loungeInfo = lounge_info.toString();
        this.terminalInfo = terminal_info.toString();
        this.arrTerminalInfo = arr_terminal_info.toString();
        this.sourceData = source_data;
        this.createdAt = Timestamp.from((new Date().toInstant()));


        if (this.schdDepLt == null) {
            date = formatter.parse("01/01/70 00:00");
            this.schdDepLt = Timestamp.from(date.toInstant());
        }

        if (this.schdArrLt == null) {
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

    // IATA/ICAO code of departure airport
    @Column(name = "adep")
    private String adep;

    // IATA/ICAO code of destination airport
    @Column(name = "ades")
    private String ades;

    // IATA/ICAO airline code of flight
    @Column(name = "flight_code")
    private String flightCode;

    // flight number
    @Column(name = "flight_number")
    private String flightNumber;

    // IATA/ICAO airline code of carrier
    @Column(name = "carrier_code")
    private String carrierCode;

    // carrier number
    @Column(name = "carrier_number")
    private String carrierNumber;

    // flight status
    @Column(name = "status_info")
    private String statusInfo;

    // scheduled departure timestamp
    @Column(name = "schd_dep_lt")
    private java.sql.Timestamp schdDepLt;

    // scheduled arrival timestamp
    @Column(name = "schd_arr_lt")
    private java.sql.Timestamp schdArrLt;

    // estimated departure timestamp
    @Column(name = "est_dep_lt")
    private java.sql.Timestamp estDepLt;

    // estimated arrival timestamp
    @Column(name = "est_arr_lt")
    private java.sql.Timestamp estArrLt;

    // actual departure timestamp
    @Column(name = "act_dep_lt")
    private java.sql.Timestamp actDepLt;

    // actual arrival timestamp
    @Column(name = "act_arr_lt")
    private java.sql.Timestamp actArrLt;

    // flight leg sequence number
    @Column(name = "flt_leg_seq_no")
    private long fltLegSeqNo;

    // scheduled aircraft name
    @Column(name = "aircraft_name_scheduled")
    private String aircraftNameScheduled;

    // baggage information
    @Column(name = "baggage_info")
    private String baggageInfo;

    // counter information
    @Column(name = "counter")
    private String counter;

    // gate information
    @Column(name = "gate_info")
    private String gateInfo;

    // lounge information
    @Column(name = "lounge_info")
    private String loungeInfo;

    // terminal information
    @Column(name = "terminal_info")
    private String terminalInfo;

    // arrival terminal information
    @Column(name = "arr_terminal_info")
    private String arrTerminalInfo;

    // source of data
    @Column(name = "source_data")
    private String sourceData;

    // record creation timestamp
    @Column(name = "created_at")
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
