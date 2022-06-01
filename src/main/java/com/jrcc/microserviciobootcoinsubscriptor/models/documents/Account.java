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

@Document(collection = "accounts")
@Data
@ToString
@AllArgsConstructor
public class Account {

    @Id
    @JsonProperty("id_account")
    private String idAccount;
    @Field("id_client")
    @JsonProperty("id_client")
    private String idClient;
    @Field("account_number")
    @JsonProperty("account_number")
    private String accountNumber;
    private Double balance;
    @Field("creation_date")
    @JsonProperty("creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    private Date creationDate;
}
