package bds.dao;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

// Таблица для сохранения текущего статуса вычислений
@Entity
@Table(name = "proceed_table")
public class ProceedEntity {

    // уникальный индекс
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    // IATA/ICAO flight airline code
    @Column(name = "flight_icao_code")
    private String flightIcaoCode;

    // flight number
    @Column(name = "flight_number")
    private String flightNumber;

    // scheduled departure date
    @Column(name = "schd_dep_only_date_lt")
    private String schdDepOnlyDateLt;

    // признак, что запись уже обработана и результат обработки записан в результирующую таблицу
    @Column(name = "done")
    private boolean done;


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

    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
