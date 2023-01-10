package com.demo.microservi.models;

import com.demo.microservi.config.utils.HashCreator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import static com.demo.microservi.config.utils.DatesUtils.sumDates;

@Document(value = "token_user")
@Data
@NoArgsConstructor
public class TokenEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String idUser;
    private String token;
    private Date expiredDate;

    public  TokenEntity(String idUser){
        // create user
        this.idUser = idUser;
        this.token = HashCreator.createMD5Hash(idUser);
        this.expiredDate = sumDates(2);
    }
}
