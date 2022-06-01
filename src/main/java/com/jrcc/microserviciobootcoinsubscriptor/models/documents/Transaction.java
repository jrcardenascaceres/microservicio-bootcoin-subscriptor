package com.jrcc.microserviciobootcoinsubscriptor.models.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "transactions")
@Data
@ToString
@AllArgsConstructor
public class Transaction {

    @Id
    @JsonProperty("id_transaction")
    private String idTransaction;
    @Field("id_wallet")
    @JsonProperty("id_wallet")
    private String idWallet;
    private String source;
    private String destination;
    private String subject;
    private String description;
    private String currency;
    private Double amount;
    private Double commission;
    @Field("creation_date")
    @JsonProperty("creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    private Date creationDate;
}
