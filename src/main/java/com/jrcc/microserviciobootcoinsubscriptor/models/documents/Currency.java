package com.jrcc.microserviciobootcoinsubscriptor.models.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "currencys")
@Data
@ToString
@AllArgsConstructor
public class Currency {

    @Id
    @JsonProperty("id_currency")
    private String idCurrency;
    private String name;
    private String description;
    @Field("buying_rate")
    @JsonProperty("buying_rate")
    private Double buyingRate;
    @Field("selling_rate")
    @JsonProperty("selling_rate")
    private Double sellingRate;
    @Field("creation_date")
    @JsonProperty("creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    private Date creationDate;
}
