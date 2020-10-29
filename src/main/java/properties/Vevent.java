package properties;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

public class Vevent extends Property implements Comparable<Vevent> {
    /*
    DTSTART : Date de début de l'événement
    DTEND : Date de fin de l'événement
    SUMMARY : Titre de l'événement
    LOCATION : Lieu de l'événement
    CATEGORIES : Catégorie de l'événement (ex: Conférence, Fête...)
    STATUS : Statut de l'événement (TENTATIVE, CONFIRMED, CANCELLED)
    DESCRIPTION : Description de l'événement
    TRANSP : Définit si la ressource affectée à l'événement est rendu indisponible (OPAQUE, TRANSPARENT)
    SEQUENCE : Nombre de mises à jour, la première mise à jour est à 1
    */
    private String DTSTART;
    private String DTEND;
    private String SUMMARY;
    private String LOCATION;
    private String CATEGORIES;
    private String STATUS;
    private String DESCRIPTION;
    private String TRANSP;
    private String SEQUENCE;
    private String CREATED;
    private String LAST_MODIFIED;

    public Vevent() {
        super();
    }

    @Override
    public void parse(Map<String, String> content) {

        Set<Map.Entry<String, String>> entries = content.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            switch (entry.getKey()) {
                case "DTSTART" -> DTSTART = entry.getValue();
                case "DTEND" -> DTEND = entry.getValue();
                case "SUMMARY" -> SUMMARY = entry.getValue();
                case "LOCATION" -> LOCATION = entry.getValue();
                case "CATEGORIES" -> CATEGORIES = entry.getValue();
                case "STATUS" -> STATUS = entry.getValue();
                case "DESCRIPTION" -> DESCRIPTION = entry.getValue();
                case "TRANSP" -> TRANSP = entry.getValue();
                case "SEQUENCE" -> SEQUENCE = entry.getValue();
                case "CREATED" -> CREATED = entry.getValue();
                case "LAST-MODIFIED" -> LAST_MODIFIED = entry.getValue();
            }
        }
    }

    private final DateTimeFormatter sd = DateTimeFormatter.ofPattern("yyyyMMdd['T']HHmmss[X]");

    public LocalDateTime getDTSTARTDate() {
        return OffsetDateTime.parse(DTSTART, sd).toLocalDateTime();
    }

    public String getDTSTART() {
        return DTSTART;
    }

    public String getDTEND() {
        return DTEND;
    }

    public String getSUMMARY() {
        return SUMMARY;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public String getCATEGORIES() {
        return CATEGORIES;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getTRANSP() {
        return TRANSP;
    }

    public String getSEQUENCE() {
        return SEQUENCE;
    }

    public String getCREATED() {
        return CREATED;
    }

    public String getLAST_MODIFIED() {
        return LAST_MODIFIED;
    }

    @Override
    public int compareTo(@NotNull Vevent o) {
        return getDTSTARTDate().compareTo(o.getDTSTARTDate());
    }
}
