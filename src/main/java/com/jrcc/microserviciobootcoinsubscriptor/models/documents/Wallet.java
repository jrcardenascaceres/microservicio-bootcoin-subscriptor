package com.jrcc.microserviciobootcoinsubscriptor.models.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "wallets")
@Data
@ToString
@AllArgsConstructor
public class Wallet {

    @Id
    @JsonProperty("id_wallet")
    private String idWallet;
    @Field("id_currency")
    @JsonProperty("id_currency")
    private String idCurrency;
    @Field("identity_card")
    @JsonProperty("identity_card")
    private String identityCard;
    @Field("cellphone_number")
    @JsonProperty("cellphone_number")
    private String cellphoneNumber;
    private String email;
    private Double balance;
    @Field("id_account")
    @JsonProperty("id_account")
    private String idAccount;
    @Field("creation_date")
    @JsonProperty("creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Lima")
    private Date creationDate;
}
